package com.huanxi.birdgame.gameobject;

import com.huanxi.birdgame.BirdGame;
import com.huanxi.core.hxgame.GameObject;
import com.huanxi.core.hxgame.HXGame;

import java.awt.*;

public class Text extends GameObject {
    Bird bird = Bird.getBird();

    @Override
    public void doRender(Graphics g) {
        g.setColor(Color.black);
        g.setFont(new Font("华文行楷", Font.BOLD, 20));
        g.drawString("物体合外力:" + bird.getMovement().getForce(), 0, 20);
        g.drawString("物体速度:" + String.format("%.2f", bird.getMovement().getSpeed()*10)+ "px/s", 0, 40);
        g.drawString("物体加速度:" + bird.getMovement().getA() + "px/s^2", 0, 60);
        g.drawString("物体当前位移:" + String.format("%.2f", bird.getMovement().getDisplacement()) + "px", 0, 80);
        g.drawString("物体匀变速运动时间:" + String.format("%.2f", bird.getMovement().getTime()) + "s", 0, 100);
        g.drawString("物体质量:" + bird.getMovement().getM(), 0, 120);
        g.drawString("FPS:" + HXGame.FPS, 0, 140);
        g.drawString("当前分数:" + BirdGame.grade, 0, 160);
    }

    @Override
    public void doController() {

    }
}
