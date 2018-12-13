package com.huanxi.core.filter.renderfilter.boxfilter;

import com.huanxi.core.filter.renderfilter.RenderFilter;
import com.huanxi.core.hxgame.GameObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObjectRender implements RenderFilter {
    public static final String FLAG = "GameObjectRender";
    List<GameObject> gameObjects = new ArrayList<GameObject>();

    public void addGameObject(GameObject gameObject){
        gameObjects.add(gameObject);
    }
    @Override
    public void doRender(Graphics g) {
        for (GameObject gameObject : gameObjects) {
            gameObject.doRender(g);
        }
    }
}
