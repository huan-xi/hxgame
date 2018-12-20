package com.huanxi.core.filter.controllerfilter;


public interface ControllerFilter {
    void doController();
//        void addGameObject(? extends ControllerBox controllerBox);
    void addGameObject(ControllerBox controllerBox);
}
