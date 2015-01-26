/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.frame;
import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;

public class StatusBar extends JPanel {	
	private JLabel statusBar = new JLabel("  ");
	
	public StatusBar() {
		statusBar.setFont(new Font("Tahoma", Font.BOLD, 9));
		this.add(statusBar);
		this.setBorder(new SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
	}
}