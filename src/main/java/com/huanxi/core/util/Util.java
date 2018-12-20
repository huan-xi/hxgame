package com.huanxi.core.util;

import java.util.Random;

public class Util {
    public static int getRand(int max, int min) {
        return new Random().nextInt(max - min + 1) + min;
    }
}
