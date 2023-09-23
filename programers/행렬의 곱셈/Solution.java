import java.util.*;
import java.lang.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for(int i = 0; i < arr1.length; i++) {
            int[] subArr = arr1[i];
            for(int j = 0; j < arr2[0].length; j++) {
                for(int k = 0; k < subArr.length; k++) {
                    answer[i][j] += subArr[k] * arr2[k][j];
                }
            }
        }
        
        return answer;
    }
}
