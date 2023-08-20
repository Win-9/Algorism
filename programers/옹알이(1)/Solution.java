import java.lang.*;
import java.util.*;

class Solution {
    static String[] str ={"aya", "ye", "woo", "ma"};
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(String s : babbling) {
            for(int i = 0; i < 4; i++) {
                s = s.replaceAll(str[i], ",");
            }
            
            String[] resultStr = s.split(",");
            if (resultStr.length == 0) {
                answer++;
            }
            
        }
        
        
        return answer;
    }
}
