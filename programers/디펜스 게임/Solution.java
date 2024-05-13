import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));

        for (int i = 0; i < enemy.length; i++) {
            n -= enemy[i];
            queue.add(enemy[i]);
            answer++;

            if (n < 0) {
                if (k == 0) {
                    answer--;
                    break;
                }
                k--;
                n += queue.poll();
            }
        }
        
        return answer;
    }
}
