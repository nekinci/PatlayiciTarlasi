package com.org;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;

import sun.audio.*;

public class Ses {
	private Ses() {}
	
	public static void cal(String path) {
		try {
			InputStream stream = new FileInputStream(path);
			AudioStream str = new AudioStream(stream);
			AudioPlayer.player.start(str);
		}catch(Exception e) { e.printStackTrace();}
	}
}
