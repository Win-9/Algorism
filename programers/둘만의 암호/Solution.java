import java.util.*;
import java.lang.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        for(int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            for(int j = 0; j < index; j++) {
                a++;
                if (a > 'z') {
                    a -= 26;
                }
                
                if (skip.contains(String.valueOf(a))) {
                    j--;
                }
            }
            answer += String.valueOf(a);
        }
        
        return answer;
    }
}
