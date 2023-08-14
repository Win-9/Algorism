import java.lang.*;
import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        int maxA = 0;
        
        for(int i = 1; i <= arrayA[0]; i++) {
            if (checkDivide(arrayA, i)) {
                if (checkNotDivide(arrayB, i) && maxA < i) {
                    maxA = i;
                }
            }
        }
        
        for(int i = 1; i <= arrayB[0]; i++) {
            if (checkDivide(arrayB, i)) {
                if (checkNotDivide(arrayA, i) && maxA < i) {
                    maxA = i;
                }
            }
        }
        
        return maxA;
    }
    
    static boolean checkDivide(int[] arr, int num) {
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] % num != 0) {
                return false;
            }
        }
        
        return true;
    }
    
    static boolean checkNotDivide(int[] arr, int num) {
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] % num == 0) {
                return false;
            }
        }
        
        return true;
    }
}
