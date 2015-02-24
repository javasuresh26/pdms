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
import com.pdms.view.ItemDisplay;
import com.pdms.view.ItemPriceDisplay;
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
public class ItemPriceDialog extends JDialog{
 private JFrame frame;
    private WindowUtils windowUtils = new WindowUtils();
    private MdlFunctions mdlFunctions = new MdlFunctions();

    private Utils utils = new Utils();
    private ItemService itemService;

    public static JScrollPane jSPItemPrice = new JScrollPane();
    public static JTable jtblItemPrice;

    //JButton Variables
    JButton btnAddNew = new JButton("Add New", windowUtils.getImageIcon("images/add new.gif"));
    JButton btnEdit = new JButton("Edit", windowUtils.getImageIcon("images/edit.gif"));
    JButton btnPreview = new JButton("Preview", windowUtils.getImageIcon("images/preview.gif"));
    JButton btnRefresh = new JButton("Refresh", windowUtils.getImageIcon("images/refresh.gif"));
    
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    private final int itemId;
    
    public ItemPriceDialog(JFrame frame, int itemId, ItemService itemService) throws Exception{
        super(frame, true);
        this.itemService = itemService;
        this.itemId = itemId;
        
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

        mdlFunctions.setJButton(btnAddNew, "add", "Add New");
        btnAddNew.setMnemonic(KeyEvent.VK_A);
        btnAddNew.addActionListener(actionListener);

        mdlFunctions.setJButton(btnEdit, "edit", "Edit");
        btnEdit.setMnemonic(KeyEvent.VK_E);
        btnEdit.addActionListener(actionListener);

        mdlFunctions.setJButton(btnPreview, "preview", "Preview");
        btnPreview.setMnemonic(KeyEvent.VK_P);
        btnPreview.addActionListener(actionListener);

        mdlFunctions.setJButton(btnRefresh, "refresh", "Refresh");
        btnRefresh.setMnemonic(KeyEvent.VK_F);
        btnRefresh.addActionListener(actionListener);
        
        //Add Label
        northPanel.add(lblIcon);
        northPanel.add(lblCaption);

        centerPanel.add(jSPItemPrice);

        southPanel.setBackground(Color.WHITE);
        southPanel.add(btnAddNew);
        southPanel.add(btnEdit);
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
            List<ItemPriceDisplay> list = itemService.getItemPriceDisplays(itemId);
            TableModel tableModel = new CollectionResultTableModel<>(list, ItemPriceDisplay.class);
            jtblItemPrice = new JTable(null) {
                public boolean isCellEditable(int iRows, int iCols) {
                    return false;
                }
            };
            //jtblItemPrice.setAutoCreateRowSorter(true);
            jtblItemPrice.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jtblItemPrice.setModel(tableModel);
            jSPItemPrice.getViewport().add(jtblItemPrice);
            hideCloummn("Id");
            hideCloummn("ItemId");
        } catch (Exception ex) {
            Logger.getLogger(ItemPriceDialog.class.getName()).log(Level.SEVERE, null, ex);
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
                case "preview":
                    break;
                case "refresh":
                    loadTable();
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
            CollectionResultTableModel tableModel = (CollectionResultTableModel) jtblItemPrice.getModel();

            int selectedRow = jtblItemPrice.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null,
                        "Please Select any one record", "Error Message",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            int columnIndex = tableModel.getColumnIndex("Id");
            int id = (Integer) jtblItemPrice.getValueAt(selectedRow, columnIndex);


            loadTable();
        } catch (Exception ex) {
            Logger.getLogger(ItemPriceDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hideCloummn(String property) {
        jtblItemPrice.getColumn(property).setWidth(0);
        jtblItemPrice.getColumn(property).setMinWidth(0);
        jtblItemPrice.getColumn(property).setMaxWidth(0);
    }

    private void remove() {
        CollectionResultTableModel tableModel = (CollectionResultTableModel) jtblItemPrice.getModel();

        int selectedRow = jtblItemPrice.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null,
                    "Please Select any one record", "Error Message",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        int columnIndex = tableModel.getColumnIndex("Id");
        ItemPriceDisplay display = new ItemPriceDisplay();
        display.setId((int) jtblItemPrice.getValueAt(selectedRow, columnIndex));

        if (JOptionPane.showConfirmDialog(this, "Are you sure want to Delete ?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {




                loadTable();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,
                        ex.getMessage(), "Error Message",
                        JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    private void loadTitle() throws Exception {
        ItemDisplay display = itemService.getItemDisplay(itemId);
        setTitle("Item Price: "+display.getName()+" - "+display.getType());
    }
}
