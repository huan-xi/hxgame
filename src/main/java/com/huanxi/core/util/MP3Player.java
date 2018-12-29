package com.huanxi.core.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class MP3Player {
	private String filename;
	private Player player;
	public MP3Player(String filename) {
		this.filename =getClass().getClassLoader().getResource(filename).getPath();
	}

	public void play() {
		try {
			BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(filename));
			player = new Player(buffer);
			player.play();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
