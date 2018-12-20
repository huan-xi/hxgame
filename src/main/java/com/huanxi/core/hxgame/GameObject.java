package com.huanxi.core.hxgame;


import com.huanxi.core.filter.controllerfilter.ControllerBox;

import java.awt.*;

//游戏物体
public abstract class GameObject extends Rectangle implements ControllerBox {
    protected boolean alive=true; //是否有效
    protected String flag; //物体标识
    //渲染方法
    public abstract void doRender(Graphics g);
    //控制方法
    public abstract void doController();

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
