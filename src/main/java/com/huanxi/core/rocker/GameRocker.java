package com.huanxi.core.rocker;

import com.huanxi.core.hxgame.GameObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameRocker {
    public static final int MOUSE_CLICK = 1;
    private static GameRocker gameRocker;
    Map<Integer, List<Rocker>> rockerMap = new HashMap<Integer, List<Rocker>>();

    GameRocker() {
        rockerMap.put(MOUSE_CLICK, new ArrayList<Rocker>());
    }

    public static GameRocker getGameRocker() {
        if (gameRocker == null) gameRocker = new GameRocker();
        return gameRocker;
    }


    public void doRocker(int type) {
        rockerMap.get(type).forEach((rocker -> {
            rocker.doRocker();
        }));
    }

    public void addGameObject(GameObject gameObject) {
        if (gameObject instanceof MouseRocker)
            rockerMap.get(MOUSE_CLICK).add((Rocker) gameObject);

    }
}
