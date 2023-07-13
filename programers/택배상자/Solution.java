package com.backend.nutt.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class ex {
    public static void main(String[] args) {
        int[] order = {4, 3, 1, 2, 5};
        int answer = 0;
        int box = 1;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < order.length; i++) {
            if (order[i] == box) {
                box++;
                answer++;
                continue;
            }


            if (!stack.isEmpty() && order[i] == stack.peek()) {
                stack.pop();
                answer++;
                continue;
            }
            

            for(; box <= order.length; box++) {
                if (box == order[i]) {
                    i--;
                    break;
                }

                stack.push(box);
            }

        }

    }
}
