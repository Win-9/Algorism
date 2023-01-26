import java.util.*;
import java.lang.*;

class Solution {
    List<Integer> list = new ArrayList<>();
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i = 1; i <= number; i++) {
            int count = getCount(i);
            if (count <= limit) {
                answer+=count;
                continue;
            } 
            answer+=power;
        }
        
        return answer;
    }
    
    static private int getCount(int num) {
        int count = 0;
        int sqrtNum = (int) Math.sqrt(num);
        for(int i = 1; i <= sqrtNum; i++) {
            if (num % i == 0) {
                count++;
                if (i * i != num) {
                    count++;
                }
            }
            
            
        }
        
        return count;
    }
    
    
}
