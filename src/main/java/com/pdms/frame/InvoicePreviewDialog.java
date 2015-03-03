/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.frame;

import com.pdms.display.InvoiceDisplay;
import com.pdms.display.ItemDisplay;
import com.pdms.frame.utils.CollectionResultTableModel;
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
public class InvoicePreviewDialog extends JDialog {

    private WindowUtils windowUtils = new WindowUtils();
    private MdlFunctions mdlFunctions = new MdlFunctions();

    private Utils utils = new Utils();
    private InvoiceService invoiceService;

    private InvoicePreviewDemoPanel demoPanel;

    //JButton Variables
   
    JButton btnClose = new JButton("Close", windowUtils.getImageIcon("images/cancel.gif"));

    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    private InvoiceDisplay invoiceDisplay;

    public InvoicePreviewDialog(JDialog dialog, InvoiceDisplay invoiceDisplay) throws Exception {
        super(dialog, true);
        this.invoiceDisplay = invoiceDisplay;

        
        loadTitle();
        setIconImage(windowUtils.getImageIcon("images/price.gif").getImage());

        JPanel jpnlMain = new JPanel();
        JPanel northPanel = new ImagePanel(new FlowLayout(), windowUtils.getImageIcon("images/header.gif").getImage());
        JPanel southPanel = new JPanel(new FlowLayout());

        JLabel lblIcon = new JLabel(windowUtils.getImageIcon("images/price_list.gif"));

        JLabel lblCaption = new JLabel("NOTE: This form contains all information about the ItemPrices.");
        mdlFunctions.setCaptionLabel(lblCaption);

        demoPanel = new InvoicePreviewDemoPanel(invoiceDisplay);
        demoPanel.setBackground(Color.WHITE);



        mdlFunctions.setJButton(btnClose, "exit", "Close");
        btnClose.setMnemonic(KeyEvent.VK_C);
        btnClose.addActionListener(actionListener);

        //Add Label
        northPanel.add(lblIcon);
        northPanel.add(lblCaption);

        //centerPanel.add(demoPanel);

        southPanel.setBackground(Color.WHITE);

        southPanel.add(btnClose);

        jpnlMain.setLayout(new BorderLayout());
        jpnlMain.setBackground(Color.WHITE);
        jpnlMain.add(northPanel, BorderLayout.PAGE_START);
        jpnlMain.add(demoPanel, BorderLayout.CENTER);
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
                case "exit":
                    dispose();
                    break;
            }
        }
    };

   
    private void loadTitle() throws Exception {       
        setTitle("Invoice Preview: "+invoiceDisplay.getCustomerDisplay().getName());
    }
}
