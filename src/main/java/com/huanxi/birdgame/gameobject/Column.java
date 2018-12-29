package com.huanxi.birdgame.gameobject;

import com.huanxi.core.filter.controllerfilter.boxfilter.collisionbox.collisiont.Collision;
import com.huanxi.core.filter.controllerfilter.boxfilter.collisionbox.collisiont.CollisionBox;
import com.huanxi.core.hxgame.GameObject;
import com.huanxi.core.util.ImageUtil;
import com.huanxi.core.util.RenderUtil;

import java.awt.*;

public class Column extends GameObject implements CollisionBox {
    private Image image;

    public Column(String imagePath, int x) {
        image = ImageUtil.getImage(imagePath);
        width = image.getWidth(null);//获得柱子的图片宽度
        height = image.getHeight(null);//获得柱子的图片高度
        this.x = x;
        y=300;
    }

    @Override
    public void doRender(Graphics g) {
        RenderUtil.renderImage(this, g, image);
    }

    @Override
    public void doController() {

    }

    @Override
    public Collision getCollision() {
        return new Collision(true);
    }
}
