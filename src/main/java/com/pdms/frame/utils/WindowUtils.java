/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.frame.utils;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.springframework.stereotype.Component;

/**
 *
 * @author Suresh
 */
@Component
public class WindowUtils {

    private final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

    public Dimension getScreen() {
        return screen;
    }

    public ImageIcon getImageIcon(String image) {
        return new ImageIcon(ClassLoader.getSystemResource(image));
    }
//    public static void main(String[] args) {
//        WindowUtils utils=new WindowUtils();
//        URL icon =WindowUtils.class.getResource("images/add new.gif");
//        System.out.println(ClassLoader.getSystemResource("images/add new.gif").getPath());
//    }
}
