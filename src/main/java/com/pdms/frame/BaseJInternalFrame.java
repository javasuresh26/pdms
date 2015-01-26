/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.frame;

import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Suresh
 */
public class BaseJInternalFrame extends javax.swing.JInternalFrame {

    public BaseJInternalFrame() {
        super("Remove Student", false, true, false, true);
    }

    public boolean validateTextField(JTextField textField, Map<String, Object> constraints, String errorMsg) {
        return false;
    }

    public boolean validateTextArea(JTextArea textArea, Map<String, Object> constraints, String errorMsg) {
        return false;
    }

    public boolean validateCombowBox(JComboBox comboBox, Map<String, Object> constraints, String errorMsg) {
        return false;
    }

    public void refreshValidatations(JTextArea[] textAreas) {
        for (JTextArea textArea : textAreas) {
            
        }
    }

    public void refreshValidatations(JTextField[] textFields) {
        for (JTextField textField : textFields) {

        }
    }

    public void refreshValidatations(JComboBox[] comboBoxs) {
        for (JComboBox comboBox : comboBoxs) {

        }
    }
}
