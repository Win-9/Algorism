import java.lang.*;
import java.util.*;

class Solution {
    public int solution(int[] arr) {
        Integer[] boxedArr = Arrays.stream(arr).boxed().toArray(Integer[]::new); 
        Arrays.sort(boxedArr, Collections.reverseOrder());
        int answer = 0;
        long mult = 1;
        for(int i = 0; i < boxedArr.length; i++) {
            mult *= boxedArr[i];
        }
        
        for(int i = 2; i <= mult; i++) {
            if (mult % i == 0) {
                int count = 0;
                int j = 0;
                for(; j < boxedArr.length; j++) {
                    if (i % boxedArr[j] != 0) {
                        break;
                    }
                    count++;
                }
                
                if (count == boxedArr.length && boxedArr[0] <= i) {
                    return i;
                }
            }
        }
        
        return 1;
    }
}
