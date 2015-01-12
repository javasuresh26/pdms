/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.utils;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.KeyStroke;
import org.springframework.stereotype.Component;

/**
 *
 * @author Suresh
 */
@Component
public class Utils {

    String actionKey;
    String keyValue;
    Class entityClass;

    public <T> Object createInstance(Class<T> entityClass) {
        try {
            return entityClass.newInstance();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return new Object();
    }

    public Object createInstanceAs(String entity) {
        try {
            entityClass = Class.forName(entity);
            return entityClass.newInstance();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return new Object();
    }

    public KeyStroke getKeyStroke(String key) {
        String[] keys = key.split("+");
        if (keys.length == 1) {
            return KeyStroke.getKeyStroke(keys[0].toUpperCase());
        } else if (keys.length == 2) {
            actionKey = keys[0].toUpperCase();
            keyValue = keys[1].toUpperCase();
            if (actionKey.equals("CTRL")) {
                KeyStroke.getKeyStroke(getASCIIValue(keyValue), ActionEvent.CTRL_MASK);
            } else if (actionKey.equals("ALT")) {
                KeyStroke.getKeyStroke(getASCIIValue(keyValue), ActionEvent.ALT_MASK);
            } else if (actionKey.equals("SHIFT")) {
                KeyStroke.getKeyStroke(getASCIIValue(keyValue), ActionEvent.SHIFT_MASK);
            }
        }
        return null;
    }

    public int getASCIIValue(String str) {
        return (int) Character.toUpperCase(str.charAt(0));
    }
}
