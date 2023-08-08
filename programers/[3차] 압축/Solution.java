package com.backend.nutt.common;

import java.util.*;

public class ex {
    static int index = 1;
    static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        String msg = "KAKAO"; // n:21
        init();
        List<Integer> list = new ArrayList<>();
        int i = 0;

        for(; i < msg.length(); i++) {
            int j = i + 1;
            for(; j < msg.length(); j++) {
                String str = msg.substring(i, j);

                if (map.get(str) != null && j == msg.length() - 1) {
                    list.add(map.get(msg.substring(i, j + 1)));
                    break;
                }

                if (map.get(str) == null) {
                    System.out.println("i = " + i + " j: " + j + " str: " + str);
                    list.add(map.get(msg.substring(i, j - 1)));
                    map.put(str, index++);
                    i = j - 2;
                    System.out.println("i = " + i);
                    break;
                }

            }
        }

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }

    static void init() {
        for(int i = 65; i <= 90; i++) {
            map.put(String.valueOf((char)i), index);
            index++;
        }
        System.out.println("map = " + map);
    }

}
