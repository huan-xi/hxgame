package com.huanxi.core.filter.controllerfilter;



public interface ControllerFilter<T extends ControllerBox> {
    void doController();

    void addGameObject(T controllerBox);
}
