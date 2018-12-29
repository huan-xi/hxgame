package com.huanxi.core.filter.controllerfilter.boxfilter.collisionbox;

import com.huanxi.core.filter.controllerfilter.ControllerBox;
import com.huanxi.core.filter.controllerfilter.ControllerFilter;
import com.huanxi.core.filter.controllerfilter.boxfilter.collisionbox.collisiont.CollisionBox;
import com.huanxi.core.filter.controllerfilter.boxfilter.collisionbox.collisiont.CollisionBoxer;
import com.huanxi.core.hxgame.GameObject;

import java.awt.*;
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

    public boolean hit(GameObject gameObject) {
        for (int i = 0; i < ableCollisionBoxes.size(); i++) {
            Rectangle rectangle=ableCollisionBoxes.get(i).getR();
//            Rectangle rectangle1=new Rectangle(rectangle.x,rectangle.y-10,rectangle.width,rectangle.y);
            if (rectangle.intersects(gameObject))
               return true;
        }
        return false;
    }
}
