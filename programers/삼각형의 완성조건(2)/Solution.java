import java.lang.*;
import java.util.*;

class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int maxIndex = sides[0] > sides[1] ? 0 : 1;
        int minIndex = maxIndex == 1 ? 0 : 1;

        //긴변이 배열에 존재
        for(int i = 1; i <= sides[maxIndex]; i++) {
            if (sides[minIndex] + i > sides[maxIndex]) {
                answer++;
            }
        }
        
        //존재하지 않을 때
        for(int i = sides[maxIndex] + 1; ; i++) {
            if (sides[minIndex] + sides[maxIndex] <= i) {
                break;
            }
            answer++;
        }
        
        
        
        return answer;
    }
}
