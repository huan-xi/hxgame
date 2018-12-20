package com.huanxi.birdgame.gameobject;

import com.huanxi.birdgame.BirdGame;
import com.huanxi.core.filter.controllerfilter.boxfilter.collisionbox.collisiont.Collision;
import com.huanxi.core.filter.controllerfilter.boxfilter.collisionbox.collisiont.CollisionBox;
import com.huanxi.core.hxgame.GameObject;
import com.huanxi.core.hxgame.HXGame;
import com.huanxi.core.others.OldTime;
import com.huanxi.core.util.ImageUtil;
import com.huanxi.core.util.RenderUtil;
import com.huanxi.core.util.TimeUtil;

import java.awt.*;

public class Ground extends GameObject implements CollisionBox {
    Image image;

    public Ground() {
        image = ImageUtil.getImage("ground.png");
        x = 0;
        width = image.getWidth(null);
        height = image.getHeight(null);
        y = HXGame.getHxGame().getGameFrame().getMAIN_FORM_HEIGHT() - height;
    }

    @Override
    public void doRender(Graphics g) {
        RenderUtil.renderImage(this, g, image);
    }

    OldTime oldTime = new OldTime();

    @Override
    public void doController() {
        //移动速度
        TimeUtil.delay(BirdGame.getGameSpeed(), oldTime, new Runnable() {
            @Override
            public void run() {
                x--;
                if (width == HXGame.getHxGame().getGameFrame().getMAIN_FORM_WIDTH() - x) x = 0;
            }
        });

    }

    @Override
    public Collision getCollision() {
        return new Collision(true);
    }
}
