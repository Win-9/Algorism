import java.util.*;
import java.lang.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < s.length(); i++) {
            sb.insert(sb.length(), sb.substring(0, 1));
            sb.deleteCharAt(0);
            if (Check(sb)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    static boolean Check(StringBuilder sb) {
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < sb.length(); i++) {
            String str = sb.substring(i, i + 1);
            if (str.equals("(") || str.equals("{") || str.equals("[")) {
                stack.push(str);
                continue;
            }
            
            if (stack.size() > 0 && str.equals(")")) {
                if (stack.peek().equals("(")) {
                    stack.pop();
                    continue;
                }
            } else if (stack.size() > 0 && str.equals("}")) {
                if (stack.peek().equals("{")) {
                    stack.pop();
                    continue;
                }
            } else if (stack.size() > 0 && str.equals("]")) {
                if (stack.peek().equals("[")) {
                    stack.pop();
                    continue;
                }
            }
            
            return false;
            
        }
        
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
