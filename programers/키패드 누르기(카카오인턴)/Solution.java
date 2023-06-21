import java.util.*;
import java.lang.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int[] leftKey = {1, 4, 7};
        int[] rightKey = {3, 6, 9};
        int leftHand = 10;
        int rightHand = 12;
        for(int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if (num == 0) {
                num = 11;
            }
            
            if (contains(leftKey, num)) {
                answer.append("L");
                leftHand = num;
            } else if (contains(rightKey, num)) {
                answer.append("R");
                rightHand = num;
            } else {
                int leftDistance = Math.abs((leftHand - num)) % 3 + Math.abs((leftHand - num)) / 3;
                int rightDistance = Math.abs((rightHand - num)) % 3 + Math.abs((rightHand - num)) / 3;
                
                if (leftDistance > rightDistance) {
                    answer.append("R");
                    rightHand = num;
                } else if(leftDistance < rightDistance) {
                    answer.append("L");
                    leftHand = num;
                } else {
                    if (hand.equals("left")) {
                        answer.append("L");
                        leftHand = num;
                    } else {
                        answer.append("R");
                        rightHand = num;
                    }
                }
            }
        }
        
        return answer.toString();
    }
    
    public boolean contains(int[] arr, int num) {
        for(int arrSub:arr) {
            if (arrSub == num) {
                return true;
            }
        }
        return false;
    }
}
