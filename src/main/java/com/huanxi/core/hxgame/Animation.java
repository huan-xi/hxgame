package com.huanxi.core.hxgame;

import java.awt.*;

/**
 * 游戏动画
 */
public class Animation {
    private Image[] images;
    private int index=0;

    public Animation(Image[] images) {
        this.images = images;
    }

    public Image[] getImages() {
        return images;
    }

    public void setImages(Image[] images) {
        this.images = images;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
