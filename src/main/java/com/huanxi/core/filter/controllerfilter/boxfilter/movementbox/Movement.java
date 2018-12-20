package com.huanxi.core.filter.controllerfilter.boxfilter.movementbox;

import com.huanxi.core.others.OldTime;
import com.huanxi.core.util.TimeUtil;


/**
 * 运动物体属性
 */
public class Movement {
    private float a; //加速度
    private static final float g = 1f; //重力加速度
    private float speed = 0; //速度
    private float force = 0; //合外力
    private float m; //质量
    private double displacement;//初始位移
    private float time; //运动时间

    //施加外力 恒力
    public void addForce(float force) {
        this.force += force;
        this.a = this.force / m;
        this.time = 0;
    }

    //施加外力
    public void addForce(float aForce, int wTime) {
        addForce(aForce);
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(wTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                addForce(-aForce);
            }
        }.start();
    }

    /**
     * 设置质量
     *
     * @param m
     */
    public void setM(float m) {
        this.m = m;
        this.addForce(m * g);
    }

    OldTime oldTime = new OldTime();

    public float move() {
        //增加时间
        TimeUtil.delayMillisecond(100, oldTime, () -> time += 0.1);
        //改变位移
        displacement = computerDisplacement();
        //改变速度
        return speed = a * time;
    }

    /**
     * 计算位移
     *
     * @return
     */
    public double computerDisplacement() {
        return displacement + 0.5 * a * time * time;
    }

    public double getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public float getA() {
        return a;
    }

    public static float getG() {
        return g;
    }

    public float getForce() {
        return force;
    }

    public float getM() {
        return m;
    }

    public float getTime() {
        return time;
    }

    public float getSpeed() {
        return speed;
    }
}
