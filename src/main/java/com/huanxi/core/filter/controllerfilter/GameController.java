package com.huanxi.core.filter.controllerfilter;


import com.huanxi.core.filter.controllerfilter.boxfilter.GameObjectController;
import com.huanxi.core.filter.controllerfilter.boxfilter.collisionbox.CollisionControllerFilter;
import com.huanxi.core.filter.controllerfilter.boxfilter.collisionbox.collisiont.CollisionBox;
import com.huanxi.core.filter.controllerfilter.boxfilter.movementbox.MovementBox;
import com.huanxi.core.filter.controllerfilter.boxfilter.movementbox.MovementControllerFilter;
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
        controllerFilters.put(MovementControllerFilter.FLAG, new MovementControllerFilter());
        //创建碰撞检测链
        controllerFilters.put(CollisionControllerFilter.FLAG, new CollisionControllerFilter());
    }

    public void addGameObject(GameObject gameObject) {
        controllerFilters.get(GameObjectController.FLAG).addGameObject(gameObject);
        if (gameObject instanceof MovementBox)
            controllerFilters.get(MovementControllerFilter.FLAG).addGameObject(gameObject);
        if (gameObject instanceof CollisionBox)
            controllerFilters.get(CollisionControllerFilter.FLAG).addGameObject(gameObject);
    }
}
