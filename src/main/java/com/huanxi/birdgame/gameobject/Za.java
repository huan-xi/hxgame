package com.huanxi.birdgame.gameobject;

import com.huanxi.birdgame.BirdGame;
import com.huanxi.core.hxgame.GameObject;
import com.huanxi.core.util.ImageUtil;
import com.huanxi.core.util.MP3Player;

import java.awt.*;
import java.util.Random;

public class Za extends GameObject {
    private Image[] images = new Image[4];
    int type;
    boolean alive=true;
    public Za(int type, int x, int y) {
        for (int i = 0; i < images.length; i++)
            images[i] = ImageUtil.getImage("images/za" + i + ".png");
        width = images[0].getWidth(null);//获得柱子的图片宽度
        height = images[0].getHeight(null);//获得柱子的图片高度
        this.x = x;
        this.type=type;
    }


    @Override
    public void doRender(Graphics g) {
        if (alive)
        g.drawImage(images[type], x, y, 50, 50, null);
    }

    @Override
    public void doController() {
        x--;
        if (x <= -50) {
            x = new Random().nextInt(300) + 700;
            y = new Random().nextInt(200) + 80;
            alive=true;
        }
        if (this.intersects(Player.getBird())) {
         if (alive)BirdGame.grade++;
            alive=false;
            new Thread(new Runnable() {
                @Override
                public void run() {
//                    new MP3Player("sound/0.mp3").play();
                }
            }).start();
        }
    }
}
