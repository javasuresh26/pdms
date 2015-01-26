/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.frame.utils;

import com.pdms.frame.BaseJInternalFrame;
import com.pdms.utils.Utils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author Suresh
 */
public class MenuItemActionListener implements ActionListener {

    private JDesktopPane desktop;
    private final String className;
    private Utils utils = new Utils();

    public MenuItemActionListener(JDesktopPane desktop, String className) {
        this.desktop = desktop;
        this.className = className;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
            Thread runner;
            runner = new Thread() {
                public void run() {
                    //JInternalFrame frame = (JInternalFrame) utils.createInstanceAs(className);
                    JInternalFrame frame = new BaseJInternalFrame();
                    desktop.add(frame);
                    try {
                        System.out.println("hello");
                        frame.setSelected(true);
                    } catch (PropertyVetoException e) {
                        e.printStackTrace();
                    }
                }
            };
            runner.start();
        
    }
}
