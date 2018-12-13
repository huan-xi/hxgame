package com.huanxi.birdgame.gameobject;

import com.huanxi.core.hxgame.GameObject;
import com.huanxi.core.util.ImageUtil;
import com.huanxi.core.util.RenderUtil;

import java.awt.*;

public class BackGround extends GameObject {
    Image images;

    public BackGround() {
        images = ImageUtil.getImage("bg.png");
        x = 0;
        y = 0;
    }

    @Override
    public void doRender(Graphics g) {
        RenderUtil.renderImage(this, g, images);
    }

    @Override
    public void doController() {

    }
}
