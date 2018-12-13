package com.huanxi.birdgame;

import com.huanxi.birdgame.gameobject.*;
import com.huanxi.core.hxgame.HXGame;

import javax.swing.*;
import java.util.logging.Level;

public class BirdGame extends JFrame {
    HXGame hxGame;
    public static int level = 1;

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
        Columns columns1 = new Columns();
//        Columns columns2=new Columns();
        hxGame.addGameObject(columns1);
        hxGame.addGameObject(columns1.getColumnUp());
        hxGame.addGameObject(columns1.getColumnDown());
        hxGame.addGameObject(new Bird());
        hxGame.addGameObject(new Ground());
        hxGame.start();
    }
}
