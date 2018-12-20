package com.huanxi.core.hxgame;

import com.huanxi.core.filter.controllerfilter.GameController;
import com.huanxi.core.filter.renderfilter.GameRender;
import com.huanxi.core.rocker.GameRocker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GamePanel extends JPanel implements Runnable, KeyListener, MouseListener {
    private Thread controllerThread;
    private static GamePanel gamePanel;

    private GameRender gameRender;
    private GameController gameController;

    private GamePanel(GameRender gameRender, GameController gameController) {
        this.gameRender = gameRender;
        this.gameController = gameController;
    }

    public static GamePanel createGamePanel(GameRender gameRender, GameController gameController) {
        gamePanel = new GamePanel(gameRender, gameController);
        return gamePanel;
    }

    public static GamePanel getGamePanel() {
        return gamePanel;
    }

    public Thread start() {
        if (gameRender == null || gameController == null) {
            System.err.println("请先设置游戏渲染链和游戏控制链，游戏异常终止");
            return null;
        }
        controllerThread = new Thread(gamePanel);
        controllerThread.start();
        return controllerThread;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        gameRender.render(g);
    }

    public void run() {
        while (true) {
            //重绘
            repaint();
            //控制
            gameController.doController();

            HXGame.times++;
            try {
                Thread.sleep(HXGame.sleep_time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("test");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("test");
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        GameRocker.getGameRocker().doRocker(GameRocker.MOUSE_CLICK);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
