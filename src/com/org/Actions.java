package com.org;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Actions {
	//Singleton Design
	private Actions() {}

	
	
	
	final static ActionListener menu_info=new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showMessageDialog(null, "2018() Open Source Project	", "Hakkında",JOptionPane.PLAIN_MESSAGE);
		}
		
	};
	
	final static ActionListener menu_settings =new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) {
			
		}
	};
	
}
