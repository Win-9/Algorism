import java.lang.*;
import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int count = 0;
        int zero = 0;
        StringBuilder sb = new StringBuilder(s);
        
        while(!sb.toString().equals("1")) {
            count++;
            for(int i = 0; i < sb.length(); i++) {
                if (sb.substring(i, i + 1).equals("0")) {
                    sb.deleteCharAt(i);
                    zero++;
                    i--;
                }
            }
            int num = sb.length();
            sb = new StringBuilder(Integer.toBinaryString(num));
        }
        
        return new int[]{count, zero};
    }
}
