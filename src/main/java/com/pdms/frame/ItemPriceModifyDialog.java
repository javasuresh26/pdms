/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.frame;

import com.pdms.domain.ItemType;
import com.pdms.frame.utils.ImagePanel;
import com.pdms.frame.utils.MdlFunctions;
import com.pdms.frame.utils.WindowUtils;
import com.pdms.service.ItemService;
import com.pdms.utils.DateUtils;
import static com.pdms.utils.DateUtils.getJDatePicker;
import com.pdms.view.ItemDisplay;
import com.pdms.view.ItemPriceDisplay;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;

/**
 *
 * @author Suresh
 */
public class ItemPriceModifyDialog extends JDialog {

    private WindowUtils windowUtils = new WindowUtils();
    private MdlFunctions mdlFunctions = new MdlFunctions();

    private ItemService itemService;
    private ItemPriceDisplay display;

    private final int componentCount = 3;
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

    JPanel jpnlMain = new JPanel();
    JPanel northPanel = new ImagePanel(new FlowLayout(), windowUtils.getImageIcon("images/header.gif").getImage());
    JPanel centerPanel = new JPanel();
    JPanel southPanel = new JPanel(new FlowLayout());

    JLabel lblIcon = new JLabel(windowUtils.getImageIcon("images/price_list.gif"));
    JLabel lblCaption = new JLabel("IMPORTANT: Text Fields must not empty.");

    JButton btnUpdate = new JButton("Update", windowUtils.getImageIcon("images/save.gif"));
    JButton btnReset = new JButton("Reset", windowUtils.getImageIcon("images/reset.gif"));
    JButton btnCancel = new JButton("Cancel", windowUtils.getImageIcon("images/cancel.gif"));

    JLabel lblStartDate = new JLabel("Start Date:*");
    JLabel lblEndDate = new JLabel("End Date:*");
    JLabel lblPrice = new JLabel("Price:*");

    JDatePickerImpl dtpStartDate = DateUtils.getJDatePicker();
    JDatePickerImpl dtpEndDate = DateUtils.getJDatePicker();
    JTextField txtPrice = new JTextField();

    boolean isUpdate;

    public ItemPriceModifyDialog(JFrame frame, boolean isUpdate, int itemId,List<ItemPriceDisplay> itemPriceDisplays,ItemService itemService) throws Exception {

        super(frame, true);
        setIconImage(windowUtils.getImageIcon("images/price.gif").getImage());

        this.itemService = itemService;
        this.isUpdate = isUpdate;

        display = new ItemPriceDisplay();
        display.setId(itemId);

        if (isUpdate == true) {
            btnUpdate.setText("Save");
            display = itemService.getItemDisplay(display.getId());
            loadItem();
            setTitle("Edit Item Price Deatils");
        } else {
            setTitle("New Item Price Deatils");
            btnUpdate.setText("Add");
        }

        mdlFunctions.setCaptionLabel(lblCaption);
        northPanel.add(lblIcon);
        northPanel.add(lblCaption);

        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBackground(Color.WHITE);
        JPanel pnlLabel = new JPanel(new GridLayout(componentCount, 1, 1, 1));
        JPanel pnlfield = new JPanel(new GridLayout(componentCount, 1, 1, 1));
        pnlLabel.setBackground(Color.WHITE);
        pnlfield.setBackground(Color.WHITE);

        pnlLabel.add(mdlFunctions.setJLabel(lblStartDate));
        pnlfield.add(dtpStartDate);

        pnlLabel.add(mdlFunctions.setJLabel(lblEndDate));
        pnlfield.add(dtpEndDate);

        pnlLabel.add(mdlFunctions.setJLabel(lblPrice));
        pnlfield.add(mdlFunctions.setJTextField(txtPrice));

        centerPanel.add(BorderLayout.WEST, pnlLabel);
        centerPanel.add(BorderLayout.EAST, pnlfield);

        //-- Add the Update Button
        mdlFunctions.setJButton(btnUpdate, "update", "UPDATE");
        btnUpdate.setMnemonic(KeyEvent.VK_A);
        btnUpdate.addActionListener(JBActionListener);

        //-- Add the Reset Button
        mdlFunctions.setJButton(btnReset, "reset", "RESET");
        btnReset.setMnemonic(KeyEvent.VK_R);
        btnReset.addActionListener(JBActionListener);

        //-- Add the Cancel Button
        mdlFunctions.setJButton(btnCancel, "cancel", "CANCEL");
        btnCancel.setMnemonic(KeyEvent.VK_C);
        btnCancel.addActionListener(JBActionListener);

        southPanel.setBackground(Color.WHITE);
        southPanel.add(btnUpdate);
        southPanel.add(btnReset);
        southPanel.add(btnCancel);

        jpnlMain.setLayout(new BorderLayout());
        jpnlMain.setBackground(Color.WHITE);
        jpnlMain.add(northPanel, BorderLayout.PAGE_START);
        jpnlMain.add(centerPanel, BorderLayout.CENTER);
        jpnlMain.add(southPanel, BorderLayout.SOUTH);

        getContentPane().add(jpnlMain);

        pack();
        setLocation((screen.width - 325) / 2, ((screen.height - 335) / 2));

        setResizable(false);
        setVisible(true);
    }

    ActionListener JBActionListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String command = ae.getActionCommand();
            switch (command) {
                case "update":
                    update();
                    break;
                case "reset":
                    reset();
                    break;
                case "cancel":
                    dispose();
                    break;
            }
        }
    };

    private void update() {
        display.setPrice(txtPrice.getText());
        display.setStartDate((Date) (dtpStartDate.getModel().getValue()));

        try {
            if (isUpdate) {
                itemService.update(display);
            } else {
                itemService.insert(display);
            }
            dispose();
        } catch (Exception ex) {
            Logger.getLogger(ItemPriceModifyDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void reset() {
        if (isUpdate) {
            loadItem();
        } else {
            txtPrice.setText("");
        }
    }

    private void loadItem() {
        txtPrice.setText(display.getPrice());
        
        Date startDate = display.getStartDate();
        dtpEndDate.getModel().setDate(startDate.getYear(), startDate.getMonth(), startDate.getDate());

        Date endDate = display.getStartDate();
        dtpEndDate.getModel().setDate(endDate.getYear(), endDate.getMonth(), endDate.getDate());
        
    }

    private JComboBox<ItemType> getItemTypComboBox() {
        JComboBox<ItemType> comboBox = new JComboBox<>();
        comboBox.setModel(new DefaultComboBoxModel<>(ItemType.values()));
        return comboBox;
    }
}
