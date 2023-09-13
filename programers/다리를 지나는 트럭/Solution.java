import java.lang.*;
import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        int nowWeight = 0;
        
        for(int i = 0; i < truck_weights.length; i++) {
            System.out.println("i: " + truck_weights[i] + " " + answer);
            if (queue.size() <=  bridge_length 
                && (nowWeight + truck_weights[i]) <= weight) {
                queue.add(truck_weights[i]);
                nowWeight += truck_weights[i];
                answer++;
            } else {
                System.out.println("농ㅋㅋ");
                while(!queue.isEmpty()) {
                    nowWeight -= queue.poll();
                    answer++;
                }
                
                i--;
            }
        }
        
        if (!queue.isEmpty()) {
            answer += bridge_length;
        }
        
        return answer;
    }
}
