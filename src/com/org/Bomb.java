package com.org;

import java.awt.Color;

import javax.swing.JButton;

class Bomb extends JButton{
	
	//Custom Methods
	public void setBomb(int power,boolean isCheck,char type) { //TODO bombayı ayarlama.
		setPower(power); setCheck(isCheck); setType(type);
	}
	
	public Bomb initalizeBomb() { //TODO ilklendirme yapıldı.
		setBomb(0, false, 'O');
		return this;
	}
	
	public void scanNeighbours(Bomb bomb[][],int u,int v,int col,int row) {
		Ses.cal("/home/nekinci/Masaüstü/can.wav");
		if(getScore()<=0) {
			SonucPaneli.paneliGoster().setVisible(true);
			ScorePanel.scorePanel().scoreText.setText(""+getScore());
			return;
		}
		if(getType()!='O'&&!isCheck()) {
			setBackground(Color.white);
			setBomb(getPower(),true,getType());
			updateScore();
			ScorePanel.scorePanel().scoreText.setText(""+getScore());
			setText(""+getType());
			System.out.println(getScore());
			return;
		}if(getType()=='O'&&!isCheck()) {
		for(int i=u-1;i<=u+1;i++) {
			if(i<0||i>row-1)
				continue;
			for(int j=v-1;j<=v+1;j++) {
				if(j<0||j>col-1)
					continue;
				if(bomb[i][j].getType()=='O'&&!bomb[i][j].isCheck()) {
					bomb[i][j].setBomb(bomb[i][j].getPower(), true, 'X');
					bomb[i][j].setBackground(new Color(253, 233, 16));
				}
			}
		}}
	}
	public void updateScore() {
		score=score-getPower();
	}
	
	//Getter and Setter methods//
	public int getPower() {
		return power;
	}
	public char getType() {
		return type;
	}
	public boolean isCheck() {
		return isCheck;
	}
	public void setCheck(boolean isCheck) {
		this.isCheck = isCheck;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public void setType(char type) {
		this.type = type;
	}
	public int getScore() {
		return score;
	}
	//Constructors
	public Bomb() {
		c=new Color(9,37,103);
		setBackground(c);
		setSize(50,50);
		setText("");
		setFont(Fonts.getFont(Fonts.OPENSANS, 24));
	}
	//Fields
	//TODO değişkenler yazıldı.
	Color c;
	private int power;
	private boolean isCheck;
	private char type;
	private static int score=100;
}
