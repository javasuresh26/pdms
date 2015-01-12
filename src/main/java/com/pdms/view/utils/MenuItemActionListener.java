/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.view.utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;

/**
 *
 * @author Suresh
 */
public class MenuItemActionListener<T> implements ActionListener {

    private JDesktopPane desktop;
    private T frame;

    public MenuItemActionListener(JDesktopPane desktop, T frame) {
        this.desktop = desktop;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (frame instanceof JInternalFrame) {
            final JInternalFrame internalFrame = (JInternalFrame) frame;

            Thread runner;
            runner = new Thread() {
                public void run() {
                    desktop.add((JInternalFrame) internalFrame);
                    try {
                        internalFrame.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            };
            runner.start();
        }
    }
}
