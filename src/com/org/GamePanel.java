package com.org;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.FormatStyle;
import java.util.Formatter;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

class GamePanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	//Custom Metho1ds
	public void initBombs() { //TODO patlayıcılar tek tek yerleştirildi.
		for(int i=0;i<col;i++)
			for(int j=0;j<row;j++) {
				bombs[i][j]=new Bomb();
				bombs[i][j]=bombs[i][j].initalizeBomb();
				add(bombs[i][j]);
				final int x=i,y=j;
				bombs[i][j].addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						bombs[x][y].scanNeighbours(bombs, x, y,col,row);
					}
				});
			}
	}

	public void setBombs() {
		initBombs();
		for(int i=0;i<col+1;i++) {
			int x,y;
			x=new Random().nextInt(col);
			y=new Random().nextInt(row);
			switch (i) {
			case 0:case 1:bombs[x][y].setBomb(2, false, 'M');break;
			case 2:case 3:bombs[x][y].setBomb(4, false, 'D');break;
			case 4:case 5:bombs[x][y].setBomb(6, false, 'R');break;
			case 6:case 7:bombs[x][y].setBomb(8, false, 'A');break;
			case 8:      bombs[x][y].setBomb(10, false, 'N');break;
			default : bombs[x][y].setBomb(2, false, 'M');
			}
			
		}
	}
	
	public void timeTunnel() {
		timer=new Timer();
		task=new TimerTask() {
			public void run() {
				counter++;
				ScorePanel.scorePanel().timeText.setText(""+counter);
				System.out.println(counter);
				if(counter==time)
					stopTime();
			}
		};
		startTime();
		stopTime();
	}
	
	public void stopTime() {
		timer.cancel();
	}
	
	public void startTime() {
		timer.schedule(task, 0,1000);
	}
	
	public static int getCounter() {
		return counter;
	}
	
	//Constructors
	public GamePanel(int i,int j) { //TODO patlayıcı sayısı belirlendi.
		bombs=new Bomb[i][j];
		setBackground(Color.DARK_GRAY);
		col=i;
		row=j;
		setLayout(new GridLayout(i, j,2,2));
		setBombs();
		timeTunnel();
	}

	//Fields
	//TODO değişkenler yazıldı.
	private Bomb [][] bombs;
	private int col,row;
	private int time=300;
	private Timer timer;
	private TimerTask task;
	private static int counter=0;
}