import java.lang.*;
import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> queue1List = new LinkedList<>();
        Queue<Integer> queue2List = new LinkedList<>();
        
        for(int i : queue1) {
            queue1List.add(i);
        }
        for(int i : queue2) {
            queue2List.add(i);
        }
        
        long queue1Sum = Arrays.stream(queue1).sum();
        long queue2Sum = Arrays.stream(queue2).sum();
        long sum = queue1Sum + queue2Sum;
        
        if (sum % 2 != 0) {
            return -1;
        }
        
        while(true) {
            
            if (queue1Sum == queue2Sum) {
                break;
            }
            
            if (answer > (queue1List.size() + queue2List.size()) * 2) {
                return -1;
            }
            
            if (queue1Sum > sum / 2) {
                queue1Sum -= queue1List.peek();
                queue2Sum += queue1List.peek();
                queue2List.add(queue1List.poll());
            } else {
                queue2Sum -= queue2List.peek();
                queue1Sum += queue2List.peek();
                queue1List.add(queue2List.poll());
            }
            
            answer++;
        }
        
        return answer;
    }

}
