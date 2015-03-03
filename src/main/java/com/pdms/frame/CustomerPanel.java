/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.frame;

import com.pdms.frame.utils.CollectionResultTableModel;
import com.pdms.frame.utils.ImagePanel;
import com.pdms.frame.utils.MdlFunctions;
import com.pdms.frame.utils.WindowUtils;
import com.pdms.service.CustomerService;
import com.pdms.utils.Utils;
import com.pdms.display.CustomerDisplay;
import com.pdms.frame.utils.ServiceFactory;
import com.pdms.service.InvoiceService;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Suresh
 */
//@Component
public class CustomerPanel extends JPanel {

    private JFrame frame;
    private WindowUtils windowUtils = new WindowUtils();
    private MdlFunctions mdlFunctions = new MdlFunctions();

    private Utils utils = new Utils();
    private CustomerService customerService;    
    private InvoiceService invoiceService;
    
    public JScrollPane jSPCustomer = new JScrollPane();
    public JTable jtblCustomer;

    //JButton Variables
    JButton btnAddNew = new JButton("Add New", windowUtils.getImageIcon("images/add new.gif"));
    JButton btnEdit = new JButton("Edit", windowUtils.getImageIcon("images/edit.gif"));
    JButton btnRemove = new JButton("Remove", windowUtils.getImageIcon("images/remove.gif"));
    JButton btnSearch = new JButton("Search", windowUtils.getImageIcon("images/search.gif"));
    JButton btnPreview = new JButton("Preview", windowUtils.getImageIcon("images/preview.gif"));
    JButton btnRefresh = new JButton("Refresh", windowUtils.getImageIcon("images/refresh.gif"));
    JButton btnInvoice = new JButton("Invoice Details", windowUtils.getImageIcon("images/cancel.gif"));



    public CustomerPanel(JFrame frame) {
        
        this.customerService = ServiceFactory.getCustomerService();
        this.invoiceService = ServiceFactory.getInvoiceService();
        this.frame = frame;
        setBackground(Color.WHITE);
        setLayout(null);

        //-- Add the Table
        loadTable();
        //BrrwrsTblJSP.setBounds(5,55,708,323);	
        
        JPanel northPanel = new ImagePanel(new FlowLayout(), windowUtils.getImageIcon("images/header.gif").getImage());
        JPanel centerPanel = new JPanel();
        JPanel southPanel = new JPanel(new FlowLayout());

        JLabel lblIcon = new JLabel(windowUtils.getImageIcon("images/ListBarrowers.gif"));
        
        JLabel lblCaption = new JLabel("NOTE: This form contains all information about the Customers.");
        mdlFunctions.setCaptionLabel(lblCaption);
        
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBackground(Color.WHITE);
        
        
        
        mdlFunctions.setJButton(btnAddNew, "add", "Add New");
        btnAddNew.setMnemonic(KeyEvent.VK_A);
        btnAddNew.addActionListener(actionListener);

        mdlFunctions.setJButton(btnEdit, "edit", "Edit");
        btnEdit.setMnemonic(KeyEvent.VK_E);
        btnEdit.addActionListener(actionListener);

        mdlFunctions.setJButton(btnRemove,"remove", "Removed");
        btnRemove.setMnemonic(KeyEvent.VK_R);
        btnRemove.addActionListener(actionListener);

        mdlFunctions.setJButton(btnSearch,  "search", "Search");
        btnSearch.setMnemonic(KeyEvent.VK_S);
        btnSearch.addActionListener(actionListener);

        mdlFunctions.setJButton(btnPreview,  "preview", "Preview");
        btnPreview.setMnemonic(KeyEvent.VK_P);
        btnPreview.addActionListener(actionListener);

        mdlFunctions.setJButton(btnRefresh,  "refresh", "Refresh");
        btnRefresh.setMnemonic(KeyEvent.VK_F);
        btnRefresh.addActionListener(actionListener);

        mdlFunctions.setJButton(btnInvoice,  "invoice", "Invoice Details");
        btnInvoice.setMnemonic(KeyEvent.VK_I);
        btnInvoice.addActionListener(actionListener);
        
        
        //Add Icon
        //add(lblIcon);
    
        
       
        //Add Label
        northPanel.add(lblIcon);
        northPanel.add(lblCaption);

        centerPanel.add(jSPCustomer);
        
        southPanel.setBackground(Color.WHITE);
        southPanel.add(btnAddNew);
        southPanel.add(btnEdit);
        southPanel.add(btnRemove);
        southPanel.add(btnSearch);
        southPanel.add(btnPreview);
        southPanel.add(btnRefresh);
        southPanel.add(btnInvoice);
        
        
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        add(northPanel, BorderLayout.PAGE_START);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    private void loadTable() {

        try {
            List<CustomerDisplay> list = customerService.getValidAll();
            TableModel tableModel = new CollectionResultTableModel<>(list, CustomerDisplay.class);
            jtblCustomer = new JTable(null) {
                public boolean isCellEditable(int iRows, int iCols) {
                    return false;
                }
            };
            jtblCustomer.setAutoCreateRowSorter(true);
            jtblCustomer.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jtblCustomer.setModel(tableModel);
            jSPCustomer.getViewport().add(jtblCustomer);
            hideCloummn("Id");
            hideCloummn("Status");
        } catch (Exception ex) {
            Logger.getLogger(CustomerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ActionListener actionListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String command = ae.getActionCommand();
            switch (command) {
                case "add":
                    add();
                    break;
                case "edit":
                    edit();
                    break;
                case "remove":
                    remove();
                    break;
                case "search":
                    break;
                case "preview":
                    break;
                case "refresh":
                    loadTable();
                    break;
                case "invoice":
                    invoice();
                    break;
            }
        }
    };

    private void add() {
        try {
            CustomerDialog customerDialog = new CustomerDialog(frame, false, 0, customerService);
            loadTable();
        } catch (Exception ex) {
            Logger.getLogger(CustomerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void edit() {
        try {
            CollectionResultTableModel tableModel = (CollectionResultTableModel) jtblCustomer.getModel();

            int selectedRow = jtblCustomer.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null,
                        "Please Select any one record", "Error Message",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            int columnIndex = tableModel.getColumnIndex("Id");
            int id = (Integer) jtblCustomer.getValueAt(selectedRow, columnIndex);

            CustomerDialog customerDialog = new CustomerDialog(frame, true, id, customerService);
            loadTable();
        } catch (Exception ex) {
            Logger.getLogger(CustomerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hideCloummn(String property) {
        jtblCustomer.getColumn(property).setWidth(0);
        jtblCustomer.getColumn(property).setMinWidth(0);
        jtblCustomer.getColumn(property).setMaxWidth(0);
    }

    private void remove() {
        CollectionResultTableModel tableModel = (CollectionResultTableModel) jtblCustomer.getModel();

        int selectedRow = jtblCustomer.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null,
                    "Please Select any one record", "Error Message",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        int columnIndex = tableModel.getColumnIndex("Id");
        CustomerDisplay display = new CustomerDisplay();
        display.setId((int) jtblCustomer.getValueAt(selectedRow, columnIndex));

        if (JOptionPane.showConfirmDialog(this, "Are you sure want to Delete ?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            try {
                display = customerService.getCustomerDisplay(display.getId());
                display.setStatus(false);
                customerService.update(display);
                loadTable();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,
                        ex.getMessage(), "Error Message",
                        JOptionPane.ERROR_MESSAGE);

            }
        }
    }
    
    private void invoice(){
        try {
            CollectionResultTableModel tableModel = (CollectionResultTableModel) jtblCustomer.getModel();

            int selectedRow = jtblCustomer.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null,
                        "Please Select any one record", "Error Message",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            int columnIndex = tableModel.getColumnIndex("Id");
            int id = (Integer) jtblCustomer.getValueAt(selectedRow, columnIndex);
            CustomerDisplay customerDisplay = customerService.getCustomerDisplay(id);
            CustomerInvoiceDialog invoiceDialog = new CustomerInvoiceDialog(frame, invoiceService,customerDisplay);
           
        } catch (Exception ex) {
            Logger.getLogger(CustomerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
