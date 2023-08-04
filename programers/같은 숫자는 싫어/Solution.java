import java.util.*;
import java.lang.*;

public class Solution {
    public int[] solution(int []arr) {        
        Stack<Integer> stack = new Stack<>();
        
        for(int a : arr) {
            if (stack.isEmpty()) {
                stack.push(a);
            } else {
                int num = stack.peek();
                if (a != num) {
                    stack.push(a);
                }
            }
        }
        
        int[] answer = new int[stack.size()];
        int j = stack.size() - 1;
        while(!stack.isEmpty()) {
            answer[j--] = stack.pop();
        }
        

        return answer;
    }
}
