package com.huanxi.core.filter.controllerfilter.boxfilter.collisionbox.collisiont;

/**
 * 碰撞属性
 */
public class Collision {
    public boolean ableCollision;//可碰撞
    public boolean collision; //碰撞者 （为真检测碰撞）
    public Runnable doCollision; //碰撞执行函数
    public Collision(){}
    public Collision(boolean ableCollision){
        this.ableCollision=ableCollision;
    }
}
