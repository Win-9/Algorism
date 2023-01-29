import java.lang.*;
import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        
        for(int i = score.length - 1; i >= 0; i -= m) {
            
            if (i < m - 1) {
                break;
            }
            
            int subNum = k;
            int countNum = i;
            for(int j = 0; j < m; j++) {
                if (score[countNum] < subNum) {
                    subNum = score[countNum];
                }
                countNum--;
            }
            
            answer += subNum * m;

        }
        
        return answer;
    }
}
