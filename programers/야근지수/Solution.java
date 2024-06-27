import java.util.*;
import java.lang.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        for(int num : works) {
            queue.add(num);
        }
        
        while (n != 0) {
            int num = queue.poll();
            if (num == 0) {
                break;
            }
            queue.add(--num);
            n--;
        }
        
        for(int num : queue) {
            answer += Math.pow(num, 2);
        }
        
        return answer;
    }
}
