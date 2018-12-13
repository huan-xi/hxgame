package com.huanxi.core.util;

import com.huanxi.core.hxgame.HXGame;
import com.huanxi.core.others.OldTime;

public class TimeUtil {

    public static  void delay(int time, OldTime old_time, Runnable runnable) {
        if (HXGame.times - old_time.getValue() > time) {
            runnable.run();
            old_time.setValue( HXGame.times);
        }
    }
}
