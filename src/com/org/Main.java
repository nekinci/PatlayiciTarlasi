package com.org;

import java.awt.Container;
import java.awt.DisplayMode;
import java.awt.GraphicsEnvironment;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
 	
public class Main extends JFrame implements java.awt.event.ComponentListener{
	
	private static final long serialVersionUID = 1L;

	private int width = 560 , height = 585;
	GamePanel g;
	Menu m;
	ScorePanel sc;
	SonucPaneli sp;
	public Main() {
		setVisible(true);
		setResizable(true);
		setBounds((WIDTH-width)/2,(HEIGHT-height)/2,width,height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con=getContentPane();
		con.setLayout(null);
		g=new GamePanel(8,8);
		g.setBounds(0,0,560,500);
		con.add(g);
		g.setVisible(false);
		
		m=new Menu(g);
		m.setBounds(0, 0, 560, 500);
		con.add(m);
		repaint();
		sc =ScorePanel.scorePanel();
		sc.setBounds(0, 500, 560, 84);
		con.add(sc);
		sp=SonucPaneli.paneliGoster();
		sp.setBounds(0, 215, 560, 50);
		con.add(sp);
		addComponentListener(this);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				new Main();
				
			}
		});
	}


	public void componentResized(ComponentEvent c) {
		width = c.getComponent().getWidth();
		height = c.getComponent().getHeight();
		
		g.setBounds(0,0,f(width,1.0),f(height,0.96));
	}

	
	public void componentShown(ComponentEvent arg0) {}
	public void componentHidden(ComponentEvent arg0) {}
	public void componentMoved(ComponentEvent arg0) {}
	
	private int f (int size,double oran) {
		return (int) (size*oran);
	}
	
	private static final int WIDTH = GraphicsEnvironment.getLocalGraphicsEnvironment()
			.getDefaultScreenDevice().getDisplayMode()
			.getWidth();
	private static final int HEIGHT = GraphicsEnvironment.getLocalGraphicsEnvironment()
			.getDefaultScreenDevice().getDisplayMode()
			.getHeight();
}