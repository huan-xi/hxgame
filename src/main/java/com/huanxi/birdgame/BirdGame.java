package com.huanxi.birdgame;

import com.huanxi.birdgame.gameobject.*;
import com.huanxi.core.hxgame.HXGame;

import javax.swing.*;

public class BirdGame extends JFrame {
    HXGame hxGame;
    public static int level = 1;
    public static int grade=0;

    public static BirdGame start() {
        return new BirdGame();
    }

    private BirdGame() {
        hxGame = HXGame.getHxGame();
        hxGame.setTitle("笨鸟先飞游戏");
        hxGame.getGameFrame().setMAIN_FORM_WIDTH(432);
        hxGame.getGameFrame().setMAIN_FORM_HEIGHT(644);
        hxGame.init();
        //添加游戏物体
        hxGame.addGameObject(new BackGround());
        //添加两个柱子对
        Columns columns1 = new Columns(hxGame.getGameFrame().getMAIN_FORM_WIDTH());
        Columns columns2 = new Columns(hxGame.getGameFrame().getMAIN_FORM_WIDTH()*3/2+39);
        hxGame.addGameObject(columns1);
        hxGame.addGameObject(columns1.getColumnUp());
        hxGame.addGameObject(columns1.getColumnDown());
        hxGame.addGameObject(columns2);
        hxGame.addGameObject(columns2.getColumnUp());
        hxGame.addGameObject(columns2.getColumnDown());
        hxGame.addGameObject(Bird.getBird());
        hxGame.addGameObject(new Ground());
        hxGame.addGameObject(new Text());
        hxGame.addGameObject(new GameStatus());
        hxGame.start();
    }

    public static int getGameSpeed() {
        return level > 6 ? 0 : 6- level;
    }
}
