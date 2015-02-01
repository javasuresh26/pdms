/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.frame;

import com.pdms.frame.utils.ImagePanel;
import com.pdms.frame.utils.MdlFunctions;
import com.pdms.frame.utils.WindowUtils;
import com.pdms.service.CustomerService;
import com.pdms.utils.Utils;
import com.pdms.view.CustomerDisplay;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Suresh
 */
public class CustomerDialog extends JDialog {

    private WindowUtils windowUtils = new WindowUtils();
    private MdlFunctions mdlFunctions = new MdlFunctions();

    private CustomerService customerService;
    private CustomerDisplay display;

    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

    JPanel jpnlMain = new JPanel();
    JPanel northPanel = new ImagePanel(new FlowLayout(), windowUtils.getImageIcon("images/header.gif").getImage());
    JPanel centerPanel = new JPanel();
    JPanel southPanel = new JPanel(new FlowLayout());

    JLabel lblIcon = new JLabel(windowUtils.getImageIcon("images/ListBarrowers.gif"));
    JLabel lblCaption = new JLabel("IMPORTANT: Text Fields must not empty.");

    JButton btnUpdate = new JButton("Update", windowUtils.getImageIcon("images/save.gif"));
    JButton btnReset = new JButton("Reset", windowUtils.getImageIcon("images/reset.gif"));
    JButton btnCancel = new JButton("Cancel", windowUtils.getImageIcon("images/cancel.gif"));

    JLabel lblName = new JLabel("Name:*");
    JLabel lblAddress = new JLabel("Address:*");
    JLabel lblPincode = new JLabel("Pincode:*");
    JLabel lblMobileNo = new JLabel("MobileNo:*");
    JLabel lblStdCode = new JLabel("StdCode:");
    JLabel lblLandline = new JLabel("Landline:");
    JLabel lblAmountBalance = new JLabel("AmountBalance:*");

    JTextField txtName = new JTextField();
    JTextField txtAddress = new JTextField();
    JTextField txtPincode = new JTextField();
    JTextField txtMobileNo = new JTextField();
    JTextField txtStdCode = new JTextField();
    JTextField txtLandline = new JTextField();
    JTextField txtAmountBalance = new JTextField();

    boolean isUpdate;

    public CustomerDialog(JFrame frame, boolean isUpdate, int customerId, CustomerService customerService) throws Exception {

        super(frame, true);
        setIconImage(windowUtils.getImageIcon("images/ListBarrowers.gif").getImage());

        this.customerService = customerService;
        this.isUpdate = isUpdate;

        display = new CustomerDisplay();
        display.setId(customerId);

        if (isUpdate == true) {
            btnUpdate.setText("Save");
            display = customerService.getCustomerDisplay(display);
            //btnReset.setEnabled(false);
            loadCustomer();
            setTitle("Edit Customer Deatils");
        } else {
            setTitle("New Customer Deatils");
            btnUpdate.setText("Add");

        }

        mdlFunctions.setCaptionLabel(lblCaption);
        northPanel.add(lblIcon);
        northPanel.add(lblCaption);

        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBackground(Color.WHITE);
        JPanel pnlLabel = new JPanel(new GridLayout(7, 1, 1, 1));
        JPanel pnlfield = new JPanel(new GridLayout(7, 1, 1, 1));
        pnlLabel.setBackground(Color.WHITE);
        pnlfield.setBackground(Color.WHITE);

        pnlLabel.add(mdlFunctions.setJLabel(lblName));
        pnlfield.add(mdlFunctions.setJTextField(txtName));

        pnlLabel.add(mdlFunctions.setJLabel(lblAddress));
        pnlfield.add(mdlFunctions.setJTextField(txtAddress));

        pnlLabel.add(mdlFunctions.setJLabel(lblPincode));
        pnlfield.add(mdlFunctions.setJTextField(txtPincode));

        pnlLabel.add(mdlFunctions.setJLabel(lblMobileNo));
        pnlfield.add(mdlFunctions.setJTextField(txtMobileNo));

        pnlLabel.add(mdlFunctions.setJLabel(lblStdCode));
        pnlfield.add(mdlFunctions.setJTextField(txtStdCode));

        pnlLabel.add(mdlFunctions.setJLabel(lblLandline));
        pnlfield.add(mdlFunctions.setJTextField(txtLandline));

        pnlLabel.add(mdlFunctions.setJLabel(lblAmountBalance));
        pnlfield.add(mdlFunctions.setJTextField(txtAmountBalance));

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

        GridBagConstraints bagConstraints = new GridBagConstraints();

        jpnlMain.setLayout(new BorderLayout());
        jpnlMain.setBackground(Color.WHITE);

        bagConstraints.fill = GridBagConstraints.PAGE_START;
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        jpnlMain.add(northPanel, BorderLayout.PAGE_START);

        bagConstraints.fill = GridBagConstraints.CENTER;
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        jpnlMain.add(centerPanel, BorderLayout.CENTER);

        jpnlMain.setBackground(Color.WHITE);

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

        display.setAddress(txtAddress.getText());
        display.setName(txtName.getText());
        display.setPincode(txtMobileNo.getText());
        display.setMobileNo(txtMobileNo.getText());
        display.setStdCode((txtStdCode.getText()));
        display.setLandline(txtLandline.getText());
        display.setAmountBalance(txtAmountBalance.getText());

    }

    private void reset() {
        if (isUpdate) {
            loadCustomer();
        } else {
            txtName.setText("");
            txtAddress.setText("");
            txtPincode.setText("");
            txtMobileNo.setText("");
            txtStdCode.setText("");
            txtLandline.setText("");
            txtAmountBalance.setText("");
        }
    }

    private void loadCustomer() {
        txtName.setText(display.getName());
        txtAddress.setText(display.getAddress());
        txtPincode.setText(display.getPincode());
        txtMobileNo.setText(display.getMobileNo());
        txtStdCode.setText(display.getStdCode());
        txtLandline.setText(display.getLandline());
        txtAmountBalance.setText(display.getAmountBalance());
        System.out.println(Double.parseDouble(display.getAmountBalance()));
    }
}
