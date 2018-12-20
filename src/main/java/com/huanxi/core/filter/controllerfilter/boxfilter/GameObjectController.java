package com.huanxi.core.filter.controllerfilter.boxfilter;

import com.huanxi.core.filter.controllerfilter.ControllerBox;
import com.huanxi.core.filter.controllerfilter.ControllerFilter;
import com.huanxi.core.hxgame.GameObject;

import java.util.ArrayList;
import java.util.List;

public class GameObjectController implements ControllerFilter {
    public static final String FLAG = "GameObjectController";
    List<GameObject> gameObjects = new ArrayList<GameObject>();

    @Override
    public void doController() {
        gameObjects.forEach((gameObject -> {
            gameObject.doController();
        }));
    }

    @Override
    public void addGameObject(ControllerBox gameObject) {
        gameObjects.add((GameObject) gameObject);
    }
}
