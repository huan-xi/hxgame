package com.huanxi.birdgame.gameobject;

import com.huanxi.core.filter.controllerfilter.boxfilter.collisionbox.collisiont.Collision;
import com.huanxi.core.filter.controllerfilter.boxfilter.collisionbox.collisiont.CollisionBox;
import com.huanxi.core.filter.controllerfilter.boxfilter.movementbox.MovementBox;
import com.huanxi.core.filter.controllerfilter.boxfilter.movementbox.Movement;
import com.huanxi.core.hxgame.HXGame;
import com.huanxi.core.hxgame.GameObject;
import com.huanxi.core.hxgame.Animation;
import com.huanxi.core.others.OldTime;
import com.huanxi.core.rocker.MouseRocker;
import com.huanxi.core.util.ImageUtil;
import com.huanxi.core.util.RenderUtil;
import com.huanxi.core.util.TimeUtil;

import java.awt.*;

public class Bird extends GameObject implements MovementBox, CollisionBox, MouseRocker {
    private Animation animation;
    private OldTime old_time = new OldTime();
    private Movement movement; //运动物理属性
    private Collision collision; //碰撞属性
    private static Bird bird;

    public static Bird getBird() {
        if (bird == null) bird = new Bird();
        return bird;
    }

    private Bird() {
        //初始化animation
        Image[] images = new Image[8];
        for (int i = 0; i < images.length; i++)
            images[i] = ImageUtil.getImage(i + ".png");
        width = images[0].getWidth(null);
        height = images[0].getWidth(null);
        this.x = HXGame.getHxGame().getGameFrame().getMAIN_FORM_WIDTH() / 2 - width - 100;
        this.y = HXGame.getHxGame().getGameFrame().getMAIN_FORM_HEIGHT() / 2 - height ;
        animation = new Animation(images);
        //初始化物理属性
        //运动属性
        movement = new Movement();
        movement.setM(1); //设置质量
        movement.setDisplacement(y);
        //碰撞属性
        collision = new Collision();
        collision.collision = true;
        collision.doCollision = new Runnable() {
            @Override
            public void run() {
                //与物体发生碰撞
                GameStatus.setGameStatus(GameStatus.GAME_STATUS_END);
                alive=false;
            }
        };
        alive=false;
    }

    private double alpha;

    public void doRender(Graphics g) {
        float speed = movement.getSpeed();
        alpha = speed > 0 ? Math.atan(speed/ 2) :Math.atan(speed/ 10);
        Graphics2D g2 = (Graphics2D) g;//将画笔转化为2d的画笔
        g2.rotate(alpha, x + width / 2, y + height / 2);//将整个画笔按照中心点（x,y）旋转-alhpa角度
        RenderUtil.renderAnimation(this, g, animation);
        g2.rotate(-alpha, x + width / 2, y + height / 2);//将整个画笔按照中心点（x,y）旋转alhpa角度回来
    }

    public void doController() {
        TimeUtil.delayMillisecond(100, old_time, new Runnable() {
            @Override
            public void run() {
                animation.setIndex(animation.getIndex() + 1);
                if (animation.getIndex() >= animation.getImages().length) animation.setIndex(0);
            }
        });
    }

    @Override
    public Movement getMovement() {
        return movement;
    }

    @Override
    public void doRocker() {
        movement.addForce(-10, 300);
//        movement.addForce(-200, 150);
    }

    @Override
    public Collision getCollision() {
        return collision;
    }
}
