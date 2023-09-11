import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        int length = (storey + "").length();
        int gap = 1;
        
        for(int i = 0; i < length; i++) {
            int num = storey % 10;
            storey /= 10;
            
            if (num > 5) {
                int plus = 10 - num;
                storey++;
                answer += plus;
            } else if (num < 5) {
                answer += num;
            } else {
                int tmp = storey % 10;

                if (tmp >= 5) {
                    storey++;
                }
                answer += 5;
            }
        }
        
        System.out.println(storey);
        answer += storey;
        
        
        return answer;
    }
}
