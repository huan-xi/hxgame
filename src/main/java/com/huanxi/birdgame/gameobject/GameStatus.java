package com.huanxi.birdgame.gameobject;

import com.huanxi.core.hxgame.GameObject;
import com.huanxi.core.hxgame.HXGame;
import com.huanxi.core.rocker.MouseRocker;
import com.huanxi.core.util.ImageUtil;


import java.awt.*;

public class GameStatus extends GameObject implements MouseRocker {
    public static final int GAME_STATUS_READY = 0;
    public static final int GAME_STATUS_RUN = 1;
    public static final int GAME_STATUS_END = 2;
    private static int gameStatus = GAME_STATUS_READY;
    Image start;
    Image end;
    Image ready;

    public GameStatus() {
        ready = ImageUtil.getImage("images/ready.png");
        end = ImageUtil.getImage("images/end.jpg");
        x = 0;
        y = 0;
        width = ready.getWidth(null);
        height = ready.getHeight(null);
    }

    @Override
    public void doRender(Graphics g) {
        switch (gameStatus) {
            case GAME_STATUS_RUN:
                g.drawImage(start, 0, 0, null);
                break;
            case GAME_STATUS_END:
                g.drawImage(end, 0, 0, 960, 640,null);
                break;
            case GAME_STATUS_READY:
                g.drawImage(ready, 0, 0, null);
                break;
        }
    }

    @Override
    public void doController() {

    }

    public static boolean isRun() {
        return false;
    }

    @Override
    public void doRocker() {
        if (gameStatus==GAME_STATUS_READY)
            gameStatus=gameStatus = GAME_STATUS_RUN;
    }

    public static int getGameStatus() {
        return gameStatus;
    }

    public static void setGameStatus(int gameStatus) {
        GameStatus.gameStatus = gameStatus;
    }
}
