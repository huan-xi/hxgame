package com.huanxi.core.filter.controllerfilter;

import com.huanxi.core.hxgame.GameObject;

public interface ControllerFilter {
    void doController();
    void addGameObject(GameObject gameObject);
}
