package com.huanxi.core.filter.controllerfilter.boxfilter.movementbox;

import com.huanxi.core.filter.controllerfilter.ControllerBox;
import com.huanxi.core.filter.controllerfilter.ControllerFilter;

import java.util.ArrayList;
import java.util.List;

public class MovementControllerFilter implements ControllerFilter {
    public static final String FLAG = "MovementControllerFilter";
    List<MovementBoxer> gravityBoxers = new ArrayList<MovementBoxer>();

    @Override
    public void doController() {
        gravityBoxers.forEach((gravityBoxer -> {
            //重力控制
            gravityBoxer.doMovement();
        }));
    }

    @Override
    public void addGameObject(ControllerBox gameObject) {
        gravityBoxers.add(new MovementBoxer((MovementBox) gameObject));
    }

}
