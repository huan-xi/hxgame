package com.huanxi.core.filter.renderfilter;

import com.huanxi.core.hxgame.GameObject;

import java.awt.*;

/**
 *渲染链
 */
public interface RenderFilter {
   //渲染
    public void doRender(Graphics g);
    void addGameObject(GameObject gameObject);
}
