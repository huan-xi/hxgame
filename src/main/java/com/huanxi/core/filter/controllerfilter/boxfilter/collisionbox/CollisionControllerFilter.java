package com.huanxi.core.filter.controllerfilter.boxfilter.collisionbox;

import com.huanxi.core.filter.controllerfilter.ControllerBox;
import com.huanxi.core.filter.controllerfilter.ControllerFilter;
import com.huanxi.core.filter.controllerfilter.boxfilter.collisionbox.collisiont.CollisionBox;
import com.huanxi.core.filter.controllerfilter.boxfilter.collisionbox.collisiont.CollisionBoxer;

import java.util.ArrayList;
import java.util.List;

/**
 * 碰撞控制链
 */
public class CollisionControllerFilter implements ControllerFilter<ControllerBox> {
    public static final String FLAG = "CollisionControllerFilter";
    //可碰撞体
    List<CollisionBoxer> ableCollisionBoxes = new ArrayList<CollisionBoxer>();
    //碰撞体
    List<CollisionBoxer> collisionBoxers = new ArrayList<CollisionBoxer>();


    @Override
    public void doController() {
        //碰撞检测
        collisionBoxers.forEach((collisionBoxer -> {
            ableCollisionBoxes.forEach(collisionBoxer1 -> {
                if (collisionBoxer.getR().isAlive() && collisionBoxer1.getR().intersects(collisionBoxer.getR()))
                    collisionBoxer.doCollision();
            });
        }));
    }

    @Override
    public void addGameObject(ControllerBox gameObject) {
        CollisionBoxer collisionBoxer = new CollisionBoxer((CollisionBox) gameObject);
        if (collisionBoxer.ableCollision())
            ableCollisionBoxes.add(collisionBoxer);
        if (collisionBoxer.collision())
            collisionBoxers.add(collisionBoxer);
    }
}
