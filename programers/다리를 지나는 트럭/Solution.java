import java.lang.*;
import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        for(int i = 0; i < truck_weights.length; i++) {
            int truck = truck_weights[i];
            if (queue.isEmpty() || sum + truck <= weight) { //다리가 비고 무게 충당 가능할 때
                answer++;
                sum += truck;
                queue.add(truck);
                continue;
            }
            
            while(true) {
                if (queue.size() == bridge_length) { // 다리 다찼을때
                    sum -= queue.poll();
                    break;
                }
                
                if (sum + truck > weight) { // 무게 초과시
                    queue.add(0);
                    answer++;
                }
            }
        }
        return answer;
    }
}
