import java.lang.*;
import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int box = 1;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < order.length; i++) {
            if (order[i] == box) {
                box++;
                answer++;
                continue;
            }


            if (!stack.isEmpty()) {
                if (stack.peek() > order[i]) {
                    break;
                }

                if (order[i] == stack.peek()) {
                    stack.pop();
                    answer++;
                    continue;
                }
            }


            for(; box <= order.length; box++) {
                if (box == order[i]) {
                    i--;
                    break;
                }

                stack.push(box);
            }

        }
        
        return answer;
    }
}
