package com.huanxi.core.objectbox.animationbox;


import java.awt.*;

public class AnimationBox {
    private Animation animation;
    private Rectangle rectangle;

    public AnimationBox(IAnimationBox animationBox) {
        this.animation = animationBox.getAnimation();
        this.rectangle = animationBox.getRectangle();
    }
}
