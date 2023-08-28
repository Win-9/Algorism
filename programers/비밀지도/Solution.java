import java.util.*;
import java.lang.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i = 0; i < arr1.length; i++) {
            int[] binaryArr1 = convertToBinary(arr1[i], n);
            int[] binaryArr2 = convertToBinary(arr2[i], n);
            StringBuilder sb = new StringBuilder();
            
            for(int j = n - 1; j >= 0; j--) {
                if ((binaryArr1[j] | binaryArr2[j]) == 1) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            
            answer[i] = sb.toString();
        }
        
        return answer;
    }
    
    static int[] convertToBinary(int num, int size) {
        int[] arr = new int[size];
        int i = 0;
        while(i != size) {
            arr[i++] = num % 2;
            num /= 2;
        }
        
        return arr;
    }
}
