package com.huanxi.birdgame.gameobject;

import com.huanxi.birdgame.BirdGame;
import com.huanxi.core.hxgame.GameObject;
import com.huanxi.core.hxgame.HXGame;

import java.awt.*;

public class Text extends GameObject {
    Player bird = Player.getBird();

    @Override
    public void doRender(Graphics g) {
        g.setColor(Color.black);
        g.setFont(new Font("华文行楷", Font.BOLD, 20));
        g.drawString("当前分数:" + BirdGame.grade, 0, 160);
    }

    @Override
    public void doController() {

    }
}
