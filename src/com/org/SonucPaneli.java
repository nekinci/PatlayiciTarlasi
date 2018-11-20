package com.org;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SonucPaneli extends JPanel {
	private static SonucPaneli panel=new SonucPaneli();
	private SonucPaneli() {
		setBackground(Color.orange);
		JLabel lbl=new JLabel("KAYBETTIN!");
		lbl.setHorizontalAlignment(SwingUtilities.CENTER);
		lbl.setVerticalAlignment(SwingUtilities.BOTTOM);
		lbl.setFont(Fonts.getFont(Fonts.CAPTUREIT, 32));
		add(lbl);
		setVisible(false);
		repaint();
	}
	
	public static SonucPaneli paneliGoster() {
		return panel;
	}
	
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		repaint();
	}
}
