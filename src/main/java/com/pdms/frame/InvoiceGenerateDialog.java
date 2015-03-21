/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.frame;

import com.pdms.display.CustomerDisplay;
import com.pdms.display.InvoiceDisplay;
import com.pdms.frame.utils.ImagePanel;
import com.pdms.frame.utils.MdlFunctions;
import com.pdms.frame.utils.WindowUtils;
import com.pdms.service.InvoiceService;
import com.pdms.utils.Utils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Suresh
 */
public class InvoiceGenerateDialog extends JDialog{
private WindowUtils windowUtils = new WindowUtils();
    private MdlFunctions mdlFunctions = new MdlFunctions();

    private Utils utils = new Utils();
    private InvoiceService invoiceService;

    private InvoiceGeneratePanel generatePanel;

    //JButton Variables
    JButton btnAddNew = new JButton("Generate Invoice", windowUtils.getImageIcon("images/add new.gif"));
    JButton btnExit = new JButton("Close", windowUtils.getImageIcon("images/cancel.gif"));

    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

    private CustomerDisplay customerDisplay ;
    public InvoiceGenerateDialog(JDialog dialog, CustomerDisplay customerDisplay,InvoiceService invoiceService) throws Exception {
        super(dialog, true);
        this.customerDisplay = customerDisplay;
        this.invoiceService = invoiceService;
        
        loadTitle();
        setIconImage(windowUtils.getImageIcon("images/price.gif").getImage());

        JPanel jpnlMain = new JPanel();
        JPanel northPanel = new ImagePanel(new FlowLayout(), windowUtils.getImageIcon("images/header.gif").getImage());
        JPanel southPanel = new JPanel(new FlowLayout());

        JLabel lblIcon = new JLabel(windowUtils.getImageIcon("images/price_list.gif"));

        JLabel lblCaption = new JLabel("NOTE: This form contains all information about the ItemPrices.");
        mdlFunctions.setCaptionLabel(lblCaption);

        generatePanel = new InvoiceGeneratePanel(customerDisplay.getName());
        generatePanel.setBackground(Color.WHITE);

        mdlFunctions.setJButton(btnAddNew, "add", "Generate Invoice");
        btnAddNew.setMnemonic(KeyEvent.VK_A);
        btnAddNew.addActionListener(actionListener);


        mdlFunctions.setJButton(btnExit, "exit", "Exit");
        btnExit.setMnemonic(KeyEvent.VK_F);
        btnExit.addActionListener(actionListener);

        //Add Label
        northPanel.add(lblIcon);
        northPanel.add(lblCaption);

        //centerPanel.add(demoPanel);

        southPanel.setBackground(Color.WHITE);
        southPanel.add(btnAddNew);
        southPanel.add(btnExit);

        jpnlMain.setLayout(new BorderLayout());
        jpnlMain.setBackground(Color.WHITE);
        jpnlMain.add(northPanel, BorderLayout.PAGE_START);
        jpnlMain.add(generatePanel, BorderLayout.CENTER);
        jpnlMain.add(southPanel, BorderLayout.SOUTH);

        getContentPane().add(jpnlMain);
        pack();
        setLocation((screen.width - 325) / 2, ((screen.height - 335) / 2));

        setResizable(false);
        setVisible(true);
    }


    ActionListener actionListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String command = ae.getActionCommand();
            switch (command) {
                case "add":
                    generateBill();
                    break;
                case "exit":
                     dispose();
                    break;
            }
        }
    };

    private void generateBill() {
        try {
            InvoiceDisplay invoiceDisplay  = generatePanel.getInvoiceDisplay();
            invoiceDisplay.setCustomerDisplay(customerDisplay);
            invoiceService.insert(invoiceDisplay);      
            dispose();
        } catch (Exception ex) {
            Logger.getLogger(ItemPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   

    private void loadTitle() throws Exception {
        setTitle("New Invoice: "+customerDisplay.getName());
    }
}
