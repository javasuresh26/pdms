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
import com.pdms.service.ItemService;
import com.pdms.utils.Utils;
import com.pdms.display.ItemDisplay;
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
public class ItemPanel extends JPanel {

    private JFrame frame;
    private WindowUtils windowUtils = new WindowUtils();
    private MdlFunctions mdlFunctions = new MdlFunctions();

    private Utils utils = new Utils();
    private ItemService itemService;

    public static JScrollPane jSPItem = new JScrollPane();
    public static JTable jtblItem;

    //JButton Variables
    JButton btnAddNew = new JButton("Add New", windowUtils.getImageIcon("images/add new.gif"));
    JButton btnEdit = new JButton("Edit", windowUtils.getImageIcon("images/edit.gif"));
    JButton btnRemove = new JButton("Remove", windowUtils.getImageIcon("images/remove.gif"));
    JButton btnSearch = new JButton("Search", windowUtils.getImageIcon("images/search.gif"));
    JButton btnPreview = new JButton("Preview", windowUtils.getImageIcon("images/preview.gif"));
    JButton btnRefresh = new JButton("Refresh", windowUtils.getImageIcon("images/refresh.gif"));
    JButton btnItemPrice = new JButton("Item Price", windowUtils.getImageIcon("images/price.gif"));

    public ItemPanel(JFrame frame, ItemService itemService) {
        this.itemService = itemService;
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

        JLabel lblCaption = new JLabel("NOTE: This form contains all information about the Items.");
        mdlFunctions.setCaptionLabel(lblCaption);

        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBackground(Color.WHITE);

        mdlFunctions.setJButton(btnAddNew, "add", "Add New");
        btnAddNew.setMnemonic(KeyEvent.VK_A);
        btnAddNew.addActionListener(actionListener);

        mdlFunctions.setJButton(btnEdit, "edit", "Edit");
        btnEdit.setMnemonic(KeyEvent.VK_E);
        btnEdit.addActionListener(actionListener);

        mdlFunctions.setJButton(btnRemove, "remove", "Removed");
        btnRemove.setMnemonic(KeyEvent.VK_R);
        btnRemove.addActionListener(actionListener);

        mdlFunctions.setJButton(btnSearch, "search", "Search");
        btnSearch.setMnemonic(KeyEvent.VK_S);
        btnSearch.addActionListener(actionListener);

        mdlFunctions.setJButton(btnPreview, "preview", "Preview");
        btnPreview.setMnemonic(KeyEvent.VK_P);
        btnPreview.addActionListener(actionListener);

        mdlFunctions.setJButton(btnRefresh, "refresh", "Refresh");
        btnRefresh.setMnemonic(KeyEvent.VK_F);
        btnRefresh.addActionListener(actionListener);

        mdlFunctions.setJButton(btnItemPrice, "itemPrice", "Item Price List");
        btnItemPrice.setMnemonic(KeyEvent.VK_I);
        btnItemPrice.addActionListener(actionListener);

        //Add Icon
        //add(lblIcon);
        //Add Label
        northPanel.add(lblIcon);
        northPanel.add(lblCaption);

        centerPanel.add(jSPItem);

        southPanel.setBackground(Color.WHITE);
        southPanel.add(btnAddNew);
        southPanel.add(btnEdit);
        southPanel.add(btnRemove);
        southPanel.add(btnSearch);
        southPanel.add(btnPreview);
        southPanel.add(btnRefresh);
        southPanel.add(btnItemPrice);

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        add(northPanel, BorderLayout.PAGE_START);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    private void loadTable() {

        try {
            List<ItemDisplay> list = itemService.getValidAll();
            TableModel tableModel = new CollectionResultTableModel<>(list, ItemDisplay.class);
            jtblItem = new JTable(null) {
                public boolean isCellEditable(int iRows, int iCols) {
                    return false;
                }
            };
            jtblItem.setAutoCreateRowSorter(true);
            jtblItem.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jtblItem.setModel(tableModel);
            jSPItem.getViewport().add(jtblItem);
            hideCloummn("Id");
            hideCloummn("Status");
        } catch (Exception ex) {
            Logger.getLogger(ItemPanel.class.getName()).log(Level.SEVERE, null, ex);
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
                case "itemPrice":
                    loadItemPrice();
                    break;
            }
        }
    };

    private void add() {
        try {
            ItemDialog itemDialog = new ItemDialog(frame, false, 0, itemService);
            loadTable();
        } catch (Exception ex) {
            Logger.getLogger(ItemPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void edit() {
        try {
            CollectionResultTableModel tableModel = (CollectionResultTableModel) jtblItem.getModel();

            int selectedRow = jtblItem.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null,
                        "Please Select any one record", "Error Message",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            int columnIndex = tableModel.getColumnIndex("Id");
            int id = (Integer) jtblItem.getValueAt(selectedRow, columnIndex);

            ItemDialog itemDialog = new ItemDialog(frame, true, id, itemService);
            loadTable();
        } catch (Exception ex) {
            Logger.getLogger(ItemPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hideCloummn(String property) {
        jtblItem.getColumn(property).setWidth(0);
        jtblItem.getColumn(property).setMinWidth(0);
        jtblItem.getColumn(property).setMaxWidth(0);
    }

    private void remove() {
        CollectionResultTableModel tableModel = (CollectionResultTableModel) jtblItem.getModel();

        int selectedRow = jtblItem.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null,
                    "Please Select any one record", "Error Message",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        int columnIndex = tableModel.getColumnIndex("Id");
        ItemDisplay display = new ItemDisplay();
        display.setId((int) jtblItem.getValueAt(selectedRow, columnIndex));

        if (JOptionPane.showConfirmDialog(this, "Are you sure want to Delete ?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                display = itemService.getItemDisplay(display.getId());
                display.setStatus(false);

                itemService.update(display);
                loadTable();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,
                        ex.getMessage(), "Error Message",
                        JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    private void loadItemPrice() {
        try {
            CollectionResultTableModel tableModel = (CollectionResultTableModel) jtblItem.getModel();

            int selectedRow = jtblItem.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null,
                        "Please Select any one record", "Error Message",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            int columnIndex = tableModel.getColumnIndex("Id");
            int id = (Integer) jtblItem.getValueAt(selectedRow, columnIndex);

            //CustomerInvoiceDialog itemPriceDialog = new CustomerInvoiceDialog(frame, id, itemService);
            loadTable();
        } catch (Exception ex) {
            Logger.getLogger(ItemPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
