/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.frame;

import com.pdms.frame.utils.WindowUtils;
import com.pdms.service.CustomerService;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

/**
 *
 * @author Suresh
 */
//@Qualifier(value = "mainWindow")
public class MainWindow extends JFrame {

    private Container container;
    private JDesktopPane desktop = new JDesktopPane();
    private final WindowUtils windowUtils = new WindowUtils();
    private final Dimension dimension = windowUtils.getScreen();

    public MainWindow(CustomerService customerService) {
        setTitle("PDMS");
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setMinimumSize(screen);
        //setMaximumSize(screen);
        container = getContentPane();
        container.add("Center", desktop);
        pack();
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        initComponents(customerService);
        setVisible(true);
    }

    private void initComponents(CustomerService customerService) {
        add(new CustomerPanel(this, customerService));
       //new NewJDialog(this, true);
    }

}
