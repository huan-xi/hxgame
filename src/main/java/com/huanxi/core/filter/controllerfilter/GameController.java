package com.huanxi.core.filter.controllerfilter;


import com.huanxi.core.filter.controllerfilter.boxfilter.GameObjectControler;
import com.huanxi.core.hxgame.GameObject;

import java.util.HashMap;
import java.util.Map;

/**
 * 控制执行者
 */
public class GameController {
    Map<String, ControllerFilter> controllerFilters = new HashMap<String, ControllerFilter>();

    public void doController() {
        controllerFilters.forEach((key, controllerFilter) -> {
            controllerFilter.doController();
        });
    }

    public GameController() {
        //初始化控制链
        controllerFilters.put(GameObjectControler.FLAG,new GameObjectControler());
    }
    public void addGameObject(GameObject gameObject){
        controllerFilters.get(GameObjectControler.FLAG).addGameObject(gameObject);
    }
}
