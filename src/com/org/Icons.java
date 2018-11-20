package com.org;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.Icon;
/*
 * 
 * Singleton Design sadece icon alacak.
 * */
public class Icons implements Icon {
	private int height,width,x,y;
	private BufferedImage img;
	private Icons(String path,int x,int y,int height,int width) {
		try {
		img=ImageIO.read(new File(path));}catch(Exception e) {}
		this.x=x;this.y=y;this.height=height;this.width=width;
	}
	
	public static Icons getIcon(String path,int x,int y,int height,int width) {
		return new Icons(path, x, y, height, width);
	}
	//Override Methods
	
	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public void paintIcon(Component arg0, Graphics arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		Graphics2D g=(Graphics2D) arg1;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawImage(img, x, y,width,height, arg0);
	}

}
