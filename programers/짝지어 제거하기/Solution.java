import java.util.*;
import java.lang.*;

class Solution
{
    public int solution(String s)
    {
        Stack<String> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.substring(i, i + 1));
            } else {
                String str = stack.peek();
                if (str.equals(s.substring(i, i + 1))) {
                    stack.pop();
                } else {
                    stack.push(s.substring(i, i + 1));
                }
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
