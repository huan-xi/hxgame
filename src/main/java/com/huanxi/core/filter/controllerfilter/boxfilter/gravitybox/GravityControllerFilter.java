package com.huanxi.core.filter.controllerfilter.boxfilter.gravitybox;

import com.huanxi.core.filter.controllerfilter.ControllerFilter;
import com.huanxi.core.hxgame.GameObject;

import java.util.ArrayList;
import java.util.List;

public class GravityControllerFilter implements ControllerFilter {
    public static final String FLAG = "GravityControllerFilter";
    List<GameObject> gameObjects = new ArrayList<GameObject>();

    @Override
    public void doController() {
        gameObjects.forEach((gameObject -> {
            //重力控制
            gameObject.y++;
        }));
    }

    @Override
    public void addGameObject(GameObject gameObject) {
        gameObjects.add(gameObject);
    }
}
