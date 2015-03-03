/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.frame;

import com.pdms.display.CustomerDisplay;
import com.pdms.display.InvoiceDisplay;
import com.pdms.frame.utils.CollectionResultTableModel;
import com.pdms.frame.utils.ImagePanel;
import com.pdms.frame.utils.MdlFunctions;
import com.pdms.frame.utils.WindowUtils;
import com.pdms.service.ItemService;
import com.pdms.utils.Utils;
import com.pdms.display.ItemDisplay;
import com.pdms.display.ItemPriceDisplay;
import com.pdms.frame.utils.TableColumnAdjuster;
import com.pdms.service.CustomerService;
import com.pdms.service.InvoiceService;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
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
public class CustomerInvoiceDialog extends JDialog {

    private WindowUtils windowUtils = new WindowUtils();
    private MdlFunctions mdlFunctions = new MdlFunctions();

    private Utils utils = new Utils();
    private InvoiceService invoiceService;

    public static JScrollPane jSPInvoice = new JScrollPane();
    public static JTable jtblInvoice;

    //JButton Variables
    JButton btnAddNew = new JButton("Generate New Bill", windowUtils.getImageIcon("images/add new.gif"));
    JButton btnPreview = new JButton("Preview Invoice", windowUtils.getImageIcon("images/preview.gif"));
    JButton btnRefresh = new JButton("Refresh", windowUtils.getImageIcon("images/refresh.gif"));

    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

    private CustomerDisplay customerDisplay;
    public CustomerInvoiceDialog(JFrame frame, InvoiceService invoiceService, CustomerDisplay customerDisplay) throws Exception {
        super(frame, true);
        this.invoiceService = invoiceService;
        this.customerDisplay = customerDisplay;

        loadTitle();
        setIconImage(windowUtils.getImageIcon("images/price.gif").getImage());

        JPanel jpnlMain = new JPanel();
        JPanel northPanel = new ImagePanel(new FlowLayout(), windowUtils.getImageIcon("images/header.gif").getImage());
        JPanel centerPanel = new JPanel();
        JPanel southPanel = new JPanel(new FlowLayout());

        JLabel lblIcon = new JLabel(windowUtils.getImageIcon("images/price_list.gif"));

        JLabel lblCaption = new JLabel("NOTE: This form contains all information about the ItemPrices.");
        mdlFunctions.setCaptionLabel(lblCaption);

        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBackground(Color.WHITE);

        mdlFunctions.setJButton(btnAddNew, "add", "Generate New Bill");
        btnAddNew.setMnemonic(KeyEvent.VK_A);
        btnAddNew.addActionListener(actionListener);

        mdlFunctions.setJButton(btnPreview, "preview", "Preview Invoice");
        btnPreview.setMnemonic(KeyEvent.VK_P);
        btnPreview.addActionListener(actionListener);

        mdlFunctions.setJButton(btnRefresh, "refresh", "Refresh");
        btnRefresh.setMnemonic(KeyEvent.VK_F);
        btnRefresh.addActionListener(actionListener);

        //Add Label
        northPanel.add(lblIcon);
        northPanel.add(lblCaption);

        centerPanel.add(jSPInvoice);

        southPanel.setBackground(Color.WHITE);
        southPanel.add(btnAddNew);
        southPanel.add(btnPreview);
        southPanel.add(btnRefresh);

        jpnlMain.setLayout(new BorderLayout());
        jpnlMain.setBackground(Color.WHITE);
        jpnlMain.add(northPanel, BorderLayout.PAGE_START);
        jpnlMain.add(centerPanel, BorderLayout.CENTER);
        jpnlMain.add(southPanel, BorderLayout.SOUTH);

        getContentPane().add(jpnlMain);
        loadTable();
        pack();
        setLocation((screen.width - 325) / 2, ((screen.height - 335) / 2));

        setResizable(false);
        setVisible(true);
    }

    private void loadTable() {

        try {
            List<InvoiceDisplay> list = invoiceService.getAll(customerDisplay.getId());
            TableModel tableModel = new CollectionResultTableModel<>(list, InvoiceDisplay.class);
            jtblInvoice = new JTable() {
                public boolean isCellEditable(int iRows, int iCols) {
                    return false;
                }
            };
            //jtblItemPrice.setAutoCreateRowSorter(true);
            jtblInvoice.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jtblInvoice.setModel(tableModel);

            //jtblInvoice.setPreferredScrollableViewportSize(jtblInvoice.preferredSize());
            //TableColumnAdjuster adjust = new TableColumnAdjuster(jtblInvoice);
            //adjust.adjustColumns();
            jSPInvoice.getViewport().add(jtblInvoice);

            hideCloummn("Id");
            hideCloummn("CustomerId");
            hideCloummn("CustomerDisplay");  
            hideCloummn("InvoiceItemDisplays");
        } catch (Exception ex) {
            Logger.getLogger(CustomerInvoiceDialog.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ActionListener actionListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String command = ae.getActionCommand();
            switch (command) {
                case "add":
                    generateBill();
                    break;
                case "preview":
                    previewBill();
                    break;
                case "refresh":
                    loadTable();
                    break;
            }
        }
    };

    private void generateBill() {
        try {

           
            InvoiceGenerateDialog dialog = new InvoiceGenerateDialog(this, customerDisplay, invoiceService);
       
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    ex.getMessage(), "Error Message",
                    JOptionPane.ERROR_MESSAGE);

        }
    }

    private void hideCloummn(String property) {
        jtblInvoice.getColumn(property).setWidth(0);
        jtblInvoice.getColumn(property).setMinWidth(0);
        jtblInvoice.getColumn(property).setMaxWidth(0);
    }

    private void previewBill() {
        CollectionResultTableModel tableModel = (CollectionResultTableModel) jtblInvoice.getModel();

        int selectedRow = jtblInvoice.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null,
                    "Please Select any one record", "Error Message",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        int columnIndex = tableModel.getColumnIndex("Id");
        int invoiceId = (int) jtblInvoice.getValueAt(selectedRow, columnIndex);

        
        try {
            InvoiceDisplay invoiceDisplay = invoiceService.getInvoiceDisplay(invoiceId);
            InvoicePreviewDialog dialog  =new InvoicePreviewDialog(this, invoiceDisplay);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    ex.getMessage(), "Error Message",
                    JOptionPane.ERROR_MESSAGE);

        }

    }

    private void loadTitle() throws Exception {
        setTitle("Invoice List");
    }
}
