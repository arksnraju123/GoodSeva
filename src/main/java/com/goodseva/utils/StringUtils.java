package com.goodseva.utils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class StringUtils {

    public static String getRandomNumber(){
        return String.valueOf(ThreadLocalRandom.current().nextInt(1, 100000));
    }

    public static String getRandomNumber(int min, int max){
        return String.valueOf(ThreadLocalRandom.current().nextInt(min, max));
    }

    public static String getRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }
}
