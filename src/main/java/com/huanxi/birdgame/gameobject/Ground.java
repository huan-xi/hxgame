package com.huanxi.birdgame.gameobject;

import com.huanxi.core.hxgame.GameObject;
import com.huanxi.core.hxgame.HXGame;
import com.huanxi.core.util.ImageUtil;
import com.huanxi.core.util.RenderUtil;

import java.awt.*;

public class Ground extends GameObject {
    Image image;

    public Ground() {
        ImageUtil.getImage("ground.png");
        x = 0;
        width = image.getWidth(null);
        height = image.getHeight(null);
        y = HXGame.getHxGame().getGameFrame().getMAIN_FORM_HEIGHT() - height;
    }

    @Override
    public void doRender(Graphics g) {
        RenderUtil.renderImage(this, g, image);
    }

    @Override
    public void doController() {
        System.out.println("test");
        x--;
    }
}
