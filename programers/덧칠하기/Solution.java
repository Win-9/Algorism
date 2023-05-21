import java.lang.*;
import java.util.*;

class Solution {
    static int num;
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        num = section[0];
        
        for(int i = 0; i < section.length; i++) {
            if (num + m <= section[i]) {
                answer++;
                num = section[i];
            }
            
        }
        
        return answer;
    }
}
