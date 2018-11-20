package com.org;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

class ScorePanel extends JPanel{
	
	//Constructors
	private ScorePanel() {
		setSize(475,75);
		setBackground(Color.orange);
		initParams();
		setLayout(null);
		
		add(scoreLabel);
		add(scoreText);
		add(timeLabel);
		add(timeText);
		add(relaunchButton);
		add(homeButton);
	}
	
	//Fields
	private static ScorePanel score=new ScorePanel();
	JLabel scoreLabel;
	JLabel timeLabel;
	JLabel scoreText;
	JLabel timeText;
	Font font;
	JButton relaunchButton;
	JButton homeButton;
	//Methods
	
	private void initParams() {
		scoreLabel=new JLabel("Skor: ");
		timeLabel =new JLabel("Süre: ");
		scoreText =new JLabel("10");
		timeText = new JLabel("3:00");
		relaunchButton=new JButton("Yeni Oyun");
		homeButton=new JButton("Ana Menü");
		
		font=Fonts.getFont(Fonts.COMFORTAA, 24f);
		
		scoreLabel.setFont(font);
		timeLabel.setFont(font);
		scoreText.setFont(font);
		timeText.setFont(font);
		
		scoreLabel.setForeground(Color.white);
		timeLabel.setForeground(Color.white);
		scoreText.setForeground(Color.white);
		timeText.setForeground(Color.white);
		relaunchButton.setBackground(Color.white);
		homeButton.setBackground(Color.white);
		
		scoreLabel.setBounds(45, 12, 125, 50);
		scoreText.setBounds(115, 12, 125, 50);
		timeLabel.setBounds(165, 12, 125, 50);
		timeText.setBounds(235, 12, 125, 50);
		relaunchButton.setBounds(285, 20, 117, 35);
		homeButton.setBounds(407, 20, 117, 35);
		
		relaunchButton.addActionListener((ActionEvent e)->{
			new NotificationBar();
		});
	}
	
	public static ScorePanel scorePanel() {
		return score;
	}
	
}