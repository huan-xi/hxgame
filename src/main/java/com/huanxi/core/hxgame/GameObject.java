package com.huanxi.core.hxgame;


import java.awt.*;

//游戏物体
public abstract class GameObject extends Rectangle{
    //渲染方法
    public abstract void doRender(Graphics g);
    //控制方法
    public abstract void doController();
}
