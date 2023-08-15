import java.util.*;
import java.lang.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        s = s.toLowerCase();
        StringTokenizer st = new StringTokenizer(s, " ", true);
        
        while(st.hasMoreTokens()) {
            String str = st.nextToken();
            
            if (str.length() == 0) {
                answer.append(" ");
            } else {
                answer.append(str.substring(0, 1).toUpperCase() + str.substring(1));
            }
        }
        
        return answer.toString();
    }
}
