import java.lang.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] str = s.split("");
        Arrays.sort(str, Collections.reverseOrder());
        
        for(String ss : str) {
            answer.append(ss);
        }
        
        return answer.toString();
    }
}
