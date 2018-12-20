package com.huanxi.core.filter.controllerfilter.boxfilter.movementbox;

import com.huanxi.core.filter.controllerfilter.ControllerBox;
import com.huanxi.core.hxgame.GameObject;

import java.awt.*;

/**
 * 运动体
 */
public class MovementBoxer implements ControllerBox {
    GameObject r;
    Movement movement;

    public MovementBoxer(MovementBox gravityBox) {
        this.r = (GameObject) gravityBox;
        this.movement = gravityBox.getMovement();
    }

    public void doMovement() {
        if (r.isAlive()){
            movement.move();
            r.y = (int) movement.computerDisplacement();
        }
    }
}
