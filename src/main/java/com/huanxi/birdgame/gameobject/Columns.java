package com.huanxi.birdgame.gameobject;

import com.huanxi.core.hxgame.GameObject;
import com.huanxi.core.hxgame.HXGame;

import java.awt.*;

public class Columns extends GameObject {
    Column columnUp;
    Column columnDown;
    public static final int UpMaxY = -450;
    public static final int MaxGap = 0;

    public Columns(int x) {
        this.x = x;
        columnUp = new Column("column_up.png", x);
        columnUp.y = -450;

        columnDown = new Column("column_down.png", x);
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
        x--;
        columnDown.x = columnUp.x = x;
        if (columnDown.width + x == 0) {//判断柱子窗体左边出界面
            x = HXGame.getHxGame().getGameFrame().getMAIN_FORM_WIDTH();//柱子移到窗体最右边
//            int yMin = -(height/2-gap/2);//柱子y坐标最小值
//            int yMax = (BirdGame.HEIGHT-146)-(height/2+gap/2);//柱子y坐标最大值
//            y = (int)(Math.random()*(yMax-yMin+1)+yMin);//[a,b]之间的随机数
        }

    }
}
