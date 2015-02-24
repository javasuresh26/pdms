/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.frame;

import com.pdms.frame.utils.MdlFunctions;
import com.pdms.frame.utils.WindowUtils;
import com.pdms.service.CustomerService;
import com.pdms.service.CustomerServiceImpl;
import com.pdms.service.ItemService;
import com.pdms.service.ItemServiceImpl;
import com.sun.org.apache.xpath.internal.FoundIndex;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author Suresh
 */
//@Qualifier(value = "mainWindow")
public class MainWindow extends JFrame {

    private ApplicationContext applicationContext;
    private CustomerService customerService;
    private ItemService itemService;

    //Frame Components
    private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT, JTabbedPane.SCROLL_TAB_LAYOUT);
    private Container container;
    private JDesktopPane desktop = new JDesktopPane();
    private final WindowUtils windowUtils = new WindowUtils();
    private final Dimension dimension = windowUtils.getScreen();
    private MdlFunctions mdlFunctions = new MdlFunctions();

    public MainWindow(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        
        initiate();
        initComponents();

        setTitle("PDMS");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setMinimumSize(screen);
        //setMaximumSize(screen);
        //container = getContentPane();
        //container.add("Center", desktop);
        pack();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setBackground(Color.WHITE);
        setVisible(true);
    }

    private void initComponents() {

        mdlFunctions.setJTabbedPane(tabbedPane);
        //tabbedPane.addTab("Customer", windowUtils.getImageIcon("images/ListBarrowers.gif"), new CustomerPanel(this, customerService), "Customer");
        
        tabbedPane.addTab("Items", windowUtils.getImageIcon("images/sections.gif"), new ItemPanel(this, itemService), "Items");
        
        add(tabbedPane);

        //add(new CustomerPanel(this, customerService));
        //new NewJDialog(this, true);
    }

    private void initiate() {
        customerService = applicationContext.getBean(CustomerServiceImpl.class);
        itemService = applicationContext.getBean(ItemServiceImpl.class);
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

}
