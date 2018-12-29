package com.huanxi.birdgame;

import com.huanxi.birdgame.gameobject.*;
import com.huanxi.core.hxgame.HXGame;
import com.huanxi.core.util.MP3Player;

import javax.swing.*;

public class BirdGame extends JFrame {
    HXGame hxGame;
    public static int level = 1;
    public static int grade = 0;

    public static BirdGame start() {
        return new BirdGame();
    }

    private BirdGame() {
        hxGame = HXGame.getHxGame();
        hxGame.setTitle("笨鸟先飞游戏");
        hxGame.getGameFrame().setMAIN_FORM_WIDTH(960);
        hxGame.getGameFrame().setMAIN_FORM_HEIGHT(640);
        hxGame.init();
        //添加游戏物体
        hxGame.addGameObject(new BackGround());
        //添加两个柱子对
        Columns columns1 = new Columns(200, 3);
        Columns columns2 = new Columns(700, 6);
        hxGame.addColumns(columns1);
        hxGame.addColumns(columns2);
        hxGame.addGameObject(Player.getBird());
        hxGame.addGameObject(Player2.getBird());
        hxGame.addGameObject(new Za(0,500,44));
        hxGame.addGameObject(new Za(1,1500,52));
        hxGame.addGameObject(new Za(2,200,300));
        hxGame.addGameObject(new Za(3,200,20));
        hxGame.addGameObject(new Text());
        hxGame.addGameObject(new GameStatus());
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    new MP3Player("sound/bg.mp3").play();
                }
            }
        }).start();
        hxGame.start();
    }

    public static int getGameSpeed() {
        return level > 6 ? 0 : 6 - level;
    }
}
