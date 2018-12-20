package com.huanxi.core.util;

import com.huanxi.core.hxgame.HXGame;
import com.huanxi.core.others.OldTime;

/**
 * 单线程时间工具类
 */
public class TimeUtil {


    /**
     * 延迟time 后执行runnable
     *
     * @param time
     * @param runnable
     */
    public static void delayMillisecond(int time, OldTime old_time, Runnable runnable) {
        if (HXGame.time - old_time.getValue() > time) {
            runnable.run();
            old_time.setValue(HXGame.time);
        }
    }

    //计次延迟
    public static void delay(int time, OldTime old_time, Runnable runnable) {
        if (HXGame.times - old_time.getValue() > time) {
            runnable.run();
            old_time.setValue(HXGame.times);
        }
    }
}
