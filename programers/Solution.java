import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxWidth = 0;
        int maxLength = 0;
        
        for(int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            } 
        }
        
        for(int i = 0; i < sizes.length; i++) {
            maxWidth = Math.max(maxWidth, sizes[i][0]);
            maxLength = Math.max(maxLength, sizes[i][1]);
        }
        
        return maxWidth * maxLength;
    }
}
