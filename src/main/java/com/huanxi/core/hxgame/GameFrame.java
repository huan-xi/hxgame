package com.huanxi.core.hxgame;


import javax.swing.*;


public class GameFrame extends JFrame {
    private int MAIN_FORM_WIDTH = 500;
    private int MAIN_FORM_HEIGHT = 500;
    private String title="";
    public GameFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setAlwaysOnTop(true);
    }
    public void init(){
		this.setTitle(title);
		this.setSize(MAIN_FORM_WIDTH, MAIN_FORM_HEIGHT);
		this.setLocationRelativeTo(null);
	}
	public int getMAIN_FORM_WIDTH() {
		return MAIN_FORM_WIDTH;
	}
	public void setMAIN_FORM_WIDTH(int mAIN_FORM_WIDTH) {
		MAIN_FORM_WIDTH = mAIN_FORM_WIDTH;
	}
	public int getMAIN_FORM_HEIGHT() {
		return MAIN_FORM_HEIGHT;
	}
	public void setMAIN_FORM_HEIGHT(int mAIN_FORM_HEIGHT) {
		MAIN_FORM_HEIGHT = mAIN_FORM_HEIGHT;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public void setPanel(GamePanel panel) {
		this.getContentPane().add(panel);
		this.addKeyListener(panel);
		this.addMouseListener(panel);
	}

}
