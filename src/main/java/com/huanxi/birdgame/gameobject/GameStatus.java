package com.huanxi.birdgame.gameobject;

import com.huanxi.core.hxgame.GameObject;
import com.huanxi.core.rocker.MouseRocker;
import com.huanxi.core.util.ImageUtil;


import java.awt.*;

public class GameStatus extends GameObject implements MouseRocker {
    public static final int GAME_STATUS_READY=0;
    public static final int GAME_STATUS_RUN=1;
    public static final int GAME_STATUS_END=2;
    private static int gameStatus=GAME_STATUS_READY;
    Image start;
    Image end;

    public GameStatus() {
        start = ImageUtil.getImage("start.png");
        end = ImageUtil.getImage("end.png");
        x=0;
        y=0;
        width=start.getWidth(null);
        height=start.getHeight(null);
    }

    @Override
    public void doRender(Graphics g) {
        if (gameStatus==GAME_STATUS_READY)
        g.drawImage(start, 0, 0, null);
        if (gameStatus==GAME_STATUS_END)
        g.drawImage(end, 0, 0, null);
    }

    @Override
    public void doController() {

    }
    public static boolean  isRun(){
        return false;
    }
    @Override
    public void doRocker() {
        gameStatus=GAME_STATUS_RUN;
        Bird.getBird().setAlive(true);
    }

    public static int getGameStatus() {
        return gameStatus;
    }

    public static void setGameStatus(int gameStatus) {
        GameStatus.gameStatus = gameStatus;
    }
}
