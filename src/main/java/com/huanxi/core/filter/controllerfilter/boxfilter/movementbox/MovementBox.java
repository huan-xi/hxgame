package com.huanxi.core.filter.controllerfilter.boxfilter.movementbox;

import com.huanxi.core.filter.controllerfilter.ControllerBox;
import com.sun.istack.internal.NotNull;

public interface MovementBox extends ControllerBox {
    @NotNull
    Movement getMovement();
}
