package com.huanxi.birdgame.gameobject;

import com.huanxi.core.hxgame.GameObject;

import java.awt.*;

public class Columns extends GameObject {
    Column columnUp;
    Column columnDown;
    public static final int UpMaxY = -450;
    public static final int MaxGap = 0;

    public Columns() {
        x = 0;
        columnUp = new Column("column_up.png", x);
        columnUp.y = -450;

        columnDown = new Column("column_down.png", 300);
        //最大450
        columnDown.y = 450;
    }

    //随机
    public Column getColumnUp() {
        return columnUp;
    }

    public Column getColumnDown() {
        return columnDown;
    }

    @Override
    public void doRender(Graphics g) {

    }

    @Override
    public void doController() {

    }
}
