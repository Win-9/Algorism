package com.backend.nutt.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ex {
    static String[] words = {"aya", "ye", "woo", "ma"};
    static String[] duplicatedWords = {"ayaaya", "yeye", "woowoo", "mama"};
    public static void main(String[] args) {
        String[] babbling = {"yayae"};
        int answer = 0;
        for(int i = 0; i < babbling.length; i++) {
            StringBuilder str = new StringBuilder(babbling[i]);
            if(duplicatedCheck(str)) {
                continue;
            }

            System.out.println("pass:" + str);

            if (check(str)) {
                answer++;
            }

        }
        System.out.println("answer = " + answer);
    }

    static boolean check(StringBuilder str) {
        for(int i = 0; i < 4; i++) {
            int index = str.indexOf(words[i]);
            if (index == -1) {
                continue;
            }
            System.out.println("delte:" + str);

            str.delete(index, index + words[i].length());
        }

        if (str.length() > 0) {
            return false;
        }

        return true;
    }

    static boolean duplicatedCheck(StringBuilder str) {
        for(int i = 0; i < 4; i++) {
            if ((str.toString()).contains(duplicatedWords[i])) {
                return true;
            }
        }

        return false;
    }
}
