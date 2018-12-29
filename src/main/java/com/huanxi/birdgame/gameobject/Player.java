package com.huanxi.birdgame.gameobject;

import com.huanxi.birdgame.BirdGame;
import com.huanxi.core.filter.controllerfilter.boxfilter.collisionbox.collisiont.Collision;
import com.huanxi.core.filter.controllerfilter.boxfilter.collisionbox.collisiont.CollisionBox;
import com.huanxi.core.filter.controllerfilter.boxfilter.movementbox.MovementBox;
import com.huanxi.core.filter.controllerfilter.boxfilter.movementbox.Movement;
import com.huanxi.core.hxgame.GameObject;
import com.huanxi.core.hxgame.Animation;
import com.huanxi.core.hxgame.HXGame;
import com.huanxi.core.others.OldTime;
import com.huanxi.core.rocker.MouseRocker;
import com.huanxi.core.util.ImageUtil;
import com.huanxi.core.util.MP3Player;
import com.huanxi.core.util.RenderUtil;
import com.huanxi.core.util.TimeUtil;

import java.awt.*;

public class Player extends GameObject implements MouseRocker {
    private OldTime old_time = new OldTime();
    private Movement movement; //运动物理属性
    private Collision collision; //碰撞属性
    private static Player bird;
    double v0;// 初始速度
    double speed;// 是鸟当前的速度
    double g;// 重力加速度
    double t;// 两次位置之间的时间
    double s; // 经过时间t之后 的位移
    Image[] running;
    Image[] f;
    int index;
    private int status;
    public int times=0;
    public static Player getBird() {
        if (bird == null) bird = new Player();
        return bird;
    }

    private Player() {
        //初始化animation
        running = new Image[12];
        f = new Image[4];
        for (int i = 0; i < running.length; i++)
            running[i] = ImageUtil.getImage("images/" + i + ".png");
        for (int i = 0; i < f.length; i++)
            f[i] = ImageUtil.getImage("images/f" + i + ".png");
        width = running[0].getWidth(null);
        height = running[0].getWidth(null);
        this.x = 200;
        this.y = 220;
        g = 4;
        v0 = 20;
        t = 0.25;
        speed = v0;
        s = 0;
    }

    public void doRender(Graphics g) {
        if (status == 0)
            RenderUtil.renderImage(this, g, running[index]);
        if (status == 1)
            RenderUtil.renderImage(this, g, f[index]);
    }

    OldTime oldTime_fly = new OldTime();

    public void doController() {
        if (y>=600) GameStatus.setGameStatus(GameStatus.GAME_STATUS_END);
        TimeUtil.delayMillisecond(100, old_time, new Runnable() {
            @Override
            public void run() {
                index++;
                if (status == 0) {
                    if (index >= running.length) index = 0;
                } else if (status == 1) {
                    if (index >= f.length) index = 0;
                }
            }
        });
        TimeUtil.delayMillisecond(10, oldTime_fly, new Runnable() {
            @Override
            public void run() {
                double v = speed;
                s = v * t + g * t * t / 2;
                if (y <= 220 || !HXGame.getHxGame().getGameController().hit(Player.getBird()))
                    y = y - (int) s;
                speed = v - g * t;
                if (HXGame.getHxGame().getGameController().hit(Player.getBird()))
                {
                    times=0;
                    if (y>=300) GameStatus.setGameStatus(GameStatus.GAME_STATUS_END);
                }
            }
        });
    }

    @Override
    public void doRocker() {
        if (times<4){
            y -= 10;
            speed = v0;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    new MP3Player("sound/jelly.mp3").play();
                }
            }).start();
            index = 0;
            status = 1;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    status = 0;
                }
            }).start();
            times++;
        }
    }
}
