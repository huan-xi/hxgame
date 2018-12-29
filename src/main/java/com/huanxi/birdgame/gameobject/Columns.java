package com.huanxi.birdgame.gameobject;

import com.huanxi.core.hxgame.GameObject;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Columns extends GameObject {

    List<Column> columnList = new ArrayList<Column>();
    Column start;
    Column end;
    public Columns(int x,int len) {
        this.x = x;
        start = new Column("images/g_start.png", x);
        columnList.add(new Column("images/ground.png", start.x + 76));
        for (int i=0;i<len;i++){
            columnList.add(new Column("images/ground.png", columnList.get(columnList.size() - 1).x + 77));
        }
        end=new Column("images/g_end.png",columnList.get(columnList.size() - 1).x + 77);
    }

    @Override
    public void doRender(Graphics g) {

    }

    @Override
    public void doController() {
        x--;
        start.x=x;
        columnList.get(0).x=start.x+=77;
        for (int i=1;i<columnList.size();i++){
            columnList.get(i).x=columnList.get(i - 1).x + 77;
        }
        end.x=columnList.get(columnList.size() - 1).x + 77;
        if (end.x<=-60)
            this.x=1000;
    }

    public List<Column> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<Column> columnList) {
        this.columnList = columnList;
    }

    public Column getStart() {
        return start;
    }

    public void setStart(Column start) {
        this.start = start;
    }

    public Column getEnd() {
        return end;
    }

    public void setEnd(Column end) {
        this.end = end;
    }
}
