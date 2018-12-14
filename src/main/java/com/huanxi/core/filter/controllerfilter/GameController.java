package com.huanxi.core.filter.controllerfilter;


import com.huanxi.core.filter.controllerfilter.boxfilter.GameObjectController;
import com.huanxi.core.filter.controllerfilter.boxfilter.gravitybox.GravityBox;
import com.huanxi.core.filter.controllerfilter.boxfilter.gravitybox.GravityControllerFilter;
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
        controllerFilters.put(GameObjectController.FLAG, new GameObjectController());
        //创建重力控制链
        controllerFilters.put(GravityControllerFilter.FLAG, new GravityControllerFilter());
    }

    public void addGameObject(GameObject gameObject) {
        controllerFilters.get(GameObjectController.FLAG).addGameObject(gameObject);
        if (gameObject instanceof GravityBox)
            controllerFilters.get(GravityControllerFilter.FLAG).addGameObject(gameObject);
    }
}
