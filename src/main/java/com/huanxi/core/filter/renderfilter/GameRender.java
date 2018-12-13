package com.huanxi.core.filter.renderfilter;

import com.huanxi.core.filter.renderfilter.boxfilter.GameObjectRender;
import com.huanxi.core.hxgame.GameObject;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 渲染执行者
 * 渲染表
 * 执行每一条渲染链
 */
public class GameRender {
    Map<String, RenderFilter> renderFilters = new HashMap<String, RenderFilter>();
    public void render(Graphics g) {
        renderFilters.forEach((String flag, RenderFilter renderFilter) -> {
            renderFilter.doRender(g);
        });
    }

    public GameRender() {
        renderFilters.put(GameObjectRender.FLAG, new GameObjectRender());
    }

    public void addGameObject(GameObject gameObject) {
        GameObjectRender gameObjectRender = (GameObjectRender) renderFilters.get(GameObjectRender.FLAG);
        gameObjectRender.addGameObject(gameObject);
    }
}
