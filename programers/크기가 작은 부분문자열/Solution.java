import java.util.*;
import java.lang.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int pLength = p.length();
        long pNumber = Long.parseLong(p);
        

        for(int i = 0; i <= t.length() - pLength; i++) {
            long convertNum = Long.parseLong(t.substring(i, i + pLength));
            if (convertNum <= pNumber) {
                answer++;
            }
        }
        
        return answer;
    }
}
