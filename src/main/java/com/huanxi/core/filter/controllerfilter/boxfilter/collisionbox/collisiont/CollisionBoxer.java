package com.huanxi.core.filter.controllerfilter.boxfilter.collisionbox.collisiont;


import com.huanxi.core.hxgame.GameObject;

import java.awt.*;

/**
 * 运动体
 */
public class CollisionBoxer {
    GameObject r;
    Collision collision;

    public CollisionBoxer(CollisionBox collisionBox) {
        this.r = (GameObject) collisionBox;
        this.collision = collisionBox.getCollision();
    }

    public boolean ableCollision() {
        return collision.ableCollision;
    }

    public boolean collision() {
        return collision.collision;
    }

    public void doCollision() {
        collision.doCollision.run();
    }

    public GameObject getR() {
        return r;
    }
}
