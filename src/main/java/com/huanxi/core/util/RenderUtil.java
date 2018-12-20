package com.huanxi.core.util;

import java.awt.*;

import com.huanxi.core.hxgame.Animation;

public class RenderUtil {

    public static void renderAnimation(Rectangle r, Graphics g, Animation animation) {
        g.drawImage(animation.getImages()[animation.getIndex()], r.x, r.y, null);
    }

    public static void renderImage(Rectangle r, Graphics g, Image images) {
        g.drawImage(images, r.x, r.y, null);
    }
}
