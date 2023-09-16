import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] arr = new int[n + 1];
        arr[1] = 1;
        for(int i = 2; i <= n; i++) {
            if ((arr[i - 1] + 1) % 3 == 0 || check(arr[i - 1] + 1)) {
                arr[i] = getNum(arr[i - 1] + 1);
            } else {
                arr[i] = arr[i - 1] + 1;
            }
            
        }
        
        
        return arr[n];
    }
    
    static boolean check(int n) {
        int[] arr = Arrays.stream((n + "").split("")).mapToInt(Integer::parseInt).toArray();
        for(int a : arr) {
            if (a == 3) {
                return true;
            }
        }
        
        return false;
    }
    
    static int getNum(int n) {
        boolean flag = true;
        while(flag) {
            n++;
            int[] arr = Arrays.stream((n + "").split("")).mapToInt(Integer::parseInt).toArray();
            flag = false;
            for(int a : arr) {
                if (a == 3 || n % 3 == 0) {
                    flag = true;
                }
            }
            
        }
        
        
        return n;
    }
}
