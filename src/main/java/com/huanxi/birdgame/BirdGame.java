package com.huanxi.birdgame;

import com.huanxi.birdgame.gameobject.BackGround;
import com.huanxi.birdgame.gameobject.Bird;
import com.huanxi.birdgame.gameobject.Ground;
import com.huanxi.core.hxgame.HXGame;

import javax.swing.*;

public class BirdGame extends JFrame {
    HXGame hxGame;

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
        hxGame.addGameObject(new Ground());
        hxGame.addGameObject(new Bird());
        hxGame.start();
    }
}
