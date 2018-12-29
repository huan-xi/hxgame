package com.huanxi.birdgame.gameobject;

import com.huanxi.core.filter.controllerfilter.boxfilter.collisionbox.collisiont.Collision;
import com.huanxi.core.filter.controllerfilter.boxfilter.collisionbox.collisiont.CollisionBox;
import com.huanxi.core.filter.controllerfilter.boxfilter.movementbox.Movement;
import com.huanxi.core.filter.controllerfilter.boxfilter.movementbox.MovementBox;
import com.huanxi.core.hxgame.Animation;
import com.huanxi.core.hxgame.GameObject;
import com.huanxi.core.hxgame.HXGame;
import com.huanxi.core.others.OldTime;
import com.huanxi.core.rocker.MouseRocker;
import com.huanxi.core.util.ImageUtil;
import com.huanxi.core.util.RenderUtil;
import com.huanxi.core.util.TimeUtil;

import java.awt.*;

public class Player2 extends GameObject implements MovementBox, CollisionBox, MouseRocker {
    private Animation animation;
    private OldTime old_time = new OldTime();
    private Movement movement; //运动物理属性
    private Collision collision; //碰撞属性
    private static Player2 bird;
    double v0;// 初始速度
    double speed;// 是鸟当前的速度
    double g;// 重力加速度
    double t;// 两次位置之间的时间
    double s; // 经过时间t之后 的位移
    public static Player2 getBird() {
        if (bird == null) bird = new Player2();
        return bird;
    }
    private Player2() {
        //初始化animation
        Image[] running = new Image[6];
        for (int i = 0; i < running.length; i++)
            running[i] = ImageUtil.getImage("images/cw" + i + ".png");
        width = running[0].getWidth(null);
        height = running[0].getWidth(null);
        this.x = 100;
        this.y = 280;
        animation = new Animation(running);
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
                alive = false;
            }
        };
        g = 4;
        v0 = 20;
        t = 0.25;
        speed = v0;
        s = 0;
    }

    public void doRender(Graphics g) {
        RenderUtil.renderAnimation(this, g, animation);
    }

    OldTime oldTime_fly=new OldTime();
    public void doController() {
        TimeUtil.delayMillisecond(80, old_time, new Runnable() {
            @Override
            public void run() {
                animation.setIndex(animation.getIndex() + 1);
                if (animation.getIndex() >= animation.getImages().length) animation.setIndex(0);
            }
        });
        TimeUtil.delayMillisecond(10, oldTime_fly, new Runnable() {
            @Override
            public void run() {
                double v = speed;
                s = v * t + g * t * t / 2;
                if (y<=250||!HXGame.getHxGame().getGameController().hit(Player2.getBird()))
                y = y - (int) s;
                speed = v - g * t;
            }
        });
    }

    @Override
    public Movement getMovement() {
        return movement;
    }

    @Override
    public void doRocker() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                y-=10;
                speed = v0;
            }
        }).start();
    }

    @Override
    public Collision getCollision() {
        return collision;
    }
}
