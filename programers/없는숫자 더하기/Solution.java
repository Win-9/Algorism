import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[] numbersd) {
        int answer = 0;
        boolean[] visited = new boolean[10];
        for(int i = 0; i < numbers.length; i++) {
            visited[numbers[i]] = true;
        }
        
        for(int i = 1; i <= 9; i++) {
            if (!visited[i]) {
                answer += i;
            }
        }
        
        return answer;
    }
}
