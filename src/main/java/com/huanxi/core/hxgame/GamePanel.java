package com.huanxi.core.hxgame;

import com.huanxi.core.filter.controllerfilter.GameController;
import com.huanxi.core.filter.renderfilter.GameRender;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    private Thread controllerThread;
    private static GamePanel gamePanel;

    private GameRender gameRender;
    private GameController gameController;

    private GamePanel(GameRender gameRender,GameController gameController) {
        this.gameRender=gameRender;
        this.gameController=gameController;
    }

    public static GamePanel createGamePanel(GameRender gameRender,GameController gameController){
        gamePanel=new GamePanel(gameRender,gameController);
        return gamePanel;
    }
    public static GamePanel getGamePanel() {
        return gamePanel;
    }

    public Thread start() {
        if (gameRender==null||gameController==null)
        {
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
}
