package com.i98labs.machineproblems.xyz.utils;

/**
 * Created by renz on 10/31/16.
 */
public class StringUtils {

    public static String padLeftAndRight(String input, int padNum, char padChar) {
        for(int i=0 ; i<padNum; i++) {
            input = padChar + input + padChar;
        }
        return input;
    }

    public static String padLeft(String input, int padNum, char padChar) {
        for(int i=0 ; i<padNum; i++) {
            input = padChar + input;
        }
        return input;
    }

    public static String padRight(String input, int padNum, char padChar) {
        for(int i=0 ; i<padNum; i++) {
            input = input + padChar;
        }
        return input;
    }
}
