/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.frame;

import com.pdms.frame.utils.CollectionResultTableModel;
import com.pdms.frame.utils.MdlFunctions;
import com.pdms.frame.utils.WindowUtils;
import com.pdms.service.CustomerService;
import com.pdms.utils.Utils;
import com.pdms.view.CustomerDisplay;
import java.awt.Color;
import java.awt.Font;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Suresh
 */
//@Component
public class CustomerPanel extends JPanel {

    private JFrame frame;
    private WindowUtils windowUtils = new WindowUtils();
    private MdlFunctions mdlFunctions = new MdlFunctions();

    private Utils utils;
    private CustomerService customerService;

    @Autowired
    public void setUtils(Utils utils) {
        this.utils = utils;
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public static JScrollPane jSPCustomer = new JScrollPane();
    public static JTable jtblCustomer;

    //JButton Variables
    JButton btnAddNew = new JButton("Add New", windowUtils.getImageIcon("images/add new.gif"));
    JButton btnEdit = new JButton("Edit", windowUtils.getImageIcon("images/edit.gif"));
    JButton btnRemove = new JButton("Remove", windowUtils.getImageIcon("images/remove.gif"));
    JButton btnSearch = new JButton("Search", windowUtils.getImageIcon("images/search.gif"));
    JButton btnPreview = new JButton("Preview", windowUtils.getImageIcon("images/preview.gif"));
    JButton btnRefresh = new JButton("Refresh", windowUtils.getImageIcon("images/refresh.gif"));
    JButton btnExit = new JButton("Cancel", windowUtils.getImageIcon("images/cancel.gif"));

    //JLabel Variables
    JLabel lblHeader = new JLabel();
    JLabel lblIcon = new JLabel();
    JLabel lblCaption = new JLabel("NOTE: This form contains all information about the Customers.");

    public CustomerPanel(JFrame frame, CustomerService customerService) {
        this.customerService = customerService;
        this.frame = frame;
        setBackground(Color.WHITE);
        setLayout(null);

        //-- Add the Table
        loadTable();
        //BrrwrsTblJSP.setBounds(5,55,708,323);		

        mdlFunctions.setJButton(btnAddNew, 5, 390, 105, 25, "add", "Add New");
        btnAddNew.setMnemonic(KeyEvent.VK_A);
        btnAddNew.addActionListener(actionListener);

        mdlFunctions.setJButton(btnEdit, 112, 390, 99, 25, "edit", "Edit");
        btnEdit.setMnemonic(KeyEvent.VK_E);
        btnEdit.addActionListener(actionListener);

        mdlFunctions.setJButton(btnRemove, 212, 390, 100, 25, "remove", "Removed");
        btnRemove.setMnemonic(KeyEvent.VK_R);
        btnRemove.addActionListener(actionListener);

        mdlFunctions.setJButton(btnSearch, 313, 390, 99, 25, "search", "Search");
        btnSearch.setMnemonic(KeyEvent.VK_S);
        btnSearch.addActionListener(actionListener);

        mdlFunctions.setJButton(btnPreview, 414, 390, 99, 25, "preview", "Preview");
        btnPreview.setMnemonic(KeyEvent.VK_P);
        btnPreview.addActionListener(actionListener);

        mdlFunctions.setJButton(btnRefresh, 514, 390, 99, 25, "refresh", "Refresh");
        btnRefresh.setMnemonic(KeyEvent.VK_F);
        btnRefresh.addActionListener(actionListener);

        mdlFunctions.setJButton(btnExit, 614, 390, 99, 25, "exit", "Unload Form");
        btnExit.setMnemonic(KeyEvent.VK_C);
        btnExit.addActionListener(actionListener);

        lblHeader.setIcon(windowUtils.getImageIcon("images/Barrowers Records.gif"));
        lblIcon.setIcon(windowUtils.getImageIcon("images/ListBarrowers.gif"));

        mdlFunctions.setJLabel(lblHeader, 0, 0, 750, 40);
        mdlFunctions.setJLabel(lblIcon, 5, 2, 50, 40);
        mdlFunctions.setJLabel(lblCaption, 60, 2, 500, 40);
        lblCaption.setFont(new Font("Dialog", Font.BOLD, 12));
        lblCaption.setForeground(new Color(255, 255, 255));

        jSPCustomer.setBounds(5, 55, 708, 323);
        add(jSPCustomer);
        //Add Labels
        add(lblCaption);
        add(lblIcon);
        add(lblHeader);

        //Add Buttons
        add(btnAddNew);
        add(btnEdit);
        add(btnRemove);
        add(btnSearch);
        add(btnPreview);
        add(btnRefresh);
        add(btnExit);
    }

    private void loadTable() {

        try {
            List<CustomerDisplay> list = customerService.getAll();
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
                case "exit":
                    break;
            }
        }
    };

    private void add() {
        try {
            CustomerDialog customerDialog = new CustomerDialog(frame, false, 0, customerService);
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
                customerService.delete(display);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,
                        ex.getMessage(), "Error Message",
                        JOptionPane.ERROR_MESSAGE);

            }
        }

    }
}
