package com.huanxi.birdgame.gameobject;

import com.huanxi.core.hxgame.HXGame;
import com.huanxi.core.hxgame.GameObject;
import com.huanxi.core.objectbox.animationbox.Animation;
import com.huanxi.core.others.OldTime;
import com.huanxi.core.util.ImageUtil;
import com.huanxi.core.util.RenderUtil;
import com.huanxi.core.util.TimeUtil;

import java.awt.*;

public class Bird extends GameObject {
    private Animation animation;
    private OldTime old_time = new OldTime();

    public Bird() {
        //初始化animation
        Image[] images = new Image[8];
        for (int i = 0; i < images.length; i++)
            images[i] = ImageUtil.getImage(i + ".png");
        width = images[0].getWidth(null);
        height = images[0].getWidth(null);
        this.x = HXGame.getHxGame().getGameFrame().getMAIN_FORM_WIDTH() / 2 - width-100;
        this.y = HXGame.getHxGame().getGameFrame().getMAIN_FORM_HEIGHT() / 2 - height;
        animation = new Animation(images);
    }


    public void doRender(Graphics g) {
        RenderUtil.renderAnimation(this, g, animation);
    }

    public void doController() {
        TimeUtil.delay(5,old_time,()->{
            animation.setIndex(animation.getIndex() + 1);
            if (animation.getIndex() >= animation.getImages().length) animation.setIndex(0);
        });
    }
}
