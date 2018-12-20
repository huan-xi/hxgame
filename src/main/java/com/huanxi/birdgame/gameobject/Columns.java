package com.huanxi.birdgame.gameobject;

import com.huanxi.birdgame.BirdGame;
import com.huanxi.core.hxgame.GameObject;
import com.huanxi.core.hxgame.HXGame;
import com.huanxi.core.others.OldTime;
import com.huanxi.core.util.TimeUtil;
import com.huanxi.core.util.Util;

import java.awt.*;
import java.util.Random;

public class Columns extends GameObject {
    Column columnUp;
    Column columnDown;
    public static final int UpMaxY = -450;
    public static final int MaxGap = 0;

    public Columns(int x) {
        this.x = x;
        columnUp = new Column("column_up.png", x);
        columnUp.y = -350;
        columnDown = new Column("column_down.png", x);
        //最大450
        columnDown.y = columnUp.y + 728;
    }

    public Column getColumnUp() {
        return columnUp;
    }

    public Column getColumnDown() {
        return columnDown;
    }

    @Override
    public void doRender(Graphics g) {

    }

    OldTime oldTime = new OldTime();

    @Override
    public void doController() {
        TimeUtil.delay(BirdGame.getGameSpeed(), oldTime, () -> {
            x--;
            columnDown.x = columnUp.x = x;
            if (Bird.getBird().isAlive() && columnDown.width + x == Bird.getBird().x)
                BirdGame.grade++;
            if (columnDown.width + x == 0) {
                x = HXGame.getHxGame().getGameFrame().getMAIN_FORM_WIDTH();
                columnUp.y = Util.getRand(-200, -550);
                int gap = Util.getRand(200, 150);
                columnDown.y = (528 + columnUp.y + gap);
            }
        });
    }

}
