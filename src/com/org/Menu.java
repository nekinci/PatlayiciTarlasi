package com.org;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
public class Menu extends javax.swing.JPanel {
	
	private static final long serialVersionUID = 1L;

	public Menu(GamePanel g) {
		setLayout(null);
		this.g=g;
		setBackground(new Color(9,37,103));
		initParams();
		add(lblName);
		add(btnStart);
		add(btnInfo);
		add(btnPreferences);
	}
	
	//Methods

	private void initParams() {
		lblName=new JLabel("Patlayici Denizi");
		btnStart=new JButton("Başla",Icons.getIcon("res/play-button.png", 25, 3, 28, 28));
		btnPreferences=new JButton("Ayarlar",Icons.getIcon("res/settings-7.png", 25, 3, 28, 28));
		btnInfo=new JButton("Hakkında",Icons.getIcon("res/info.png", 25, 3, 28, 28));
		
		btnStart.setBackground(Color.white);
		btnPreferences.setBackground(Color.white);
		btnInfo.setBackground(Color.white);
		lblName.setForeground(Color.white);
		
		lblName.setFont(Fonts.getFont(Fonts.FRAKTURIKA, 48));
		btnStart.setFont(Fonts.getFont(Fonts.OPENSANS, 21));
		btnPreferences.setFont(Fonts.getFont(Fonts.OPENSANS, 21));
		btnInfo.setFont(Fonts.getFont(Fonts.OPENSANS, 21));
		
		lblName.setHorizontalAlignment(SwingUtilities.CENTER);

		btnStart.setBounds(155, 200, 250, 35);
		btnPreferences.setBounds(155, 250, 250, 35);
		btnInfo.setBounds(155, 300, 250, 35);
		lblName.setBounds(0, 0, 550, 150);
		
		btnInfo.addActionListener(Actions.menu_info);
		btnPreferences.addActionListener(Actions.menu_settings);
		btnStart.addActionListener((ActionEvent e)->{g.setVisible(true); removeAll();setVisible(false);});
	}
	
	
	//Fields
	private JButton btnStart;
	private JButton btnInfo;
	private JButton btnPreferences; 
	private JLabel 	lblName;
	private GamePanel g;
	
	//Painting
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D arg0=(Graphics2D) g;
		arg0.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		arg0.setColor(new Color(9, 47, 133));
		arg0.fillRoundRect(120, 127, 320, 300, 190, 260);
		try {
			arg0.drawImage(ImageIO.read(new File("res/pantsBlue13.png")),180,430,110,60,this);
			arg0.drawImage(ImageIO.read(new File("res/plantLeaves_1.png")),80,420,40,100,this);
			arg0.drawImage(ImageIO.read(new File("res/plantLeaves_1.png")),400,420,40,120,this);
			arg0.drawImage(ImageIO.read(new File("res/fluidBlue_top.png")),0,460,60,60,this);
			arg0.drawImage(ImageIO.read(new File("res/fluidBlue_top.png")),60,460,60,60,this);
			arg0.drawImage(ImageIO.read(new File("res/fluidBlue_top.png")),120,460,60,60,this);
			arg0.drawImage(ImageIO.read(new File("res/fluidBlue_top.png")),180,460,60,60,this);
			arg0.drawImage(ImageIO.read(new File("res/fluidBlue_top.png")),240,460,60,60,this);
			arg0.drawImage(ImageIO.read(new File("res/fluidBlue_top.png")),300,460,60,60,this);
			arg0.drawImage(ImageIO.read(new File("res/fluidBlue_top.png")),360,460,60,60,this);
			arg0.drawImage(ImageIO.read(new File("res/fluidBlue_top.png")),420,460,60,60,this);
			arg0.drawImage(ImageIO.read(new File("res/fluidBlue_top.png")),480,460,60,60,this);
			arg0.drawImage(ImageIO.read(new File("res/fluidBlue_top.png")),540,460,60,60,this);
			repaint();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
