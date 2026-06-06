package com.goodseva.utils;

import java.util.concurrent.ThreadLocalRandom;

public class StringUtils {

    public static String getRandomNumber(){
        return String.valueOf(ThreadLocalRandom.current().nextInt(1, 100000));
    }
}
