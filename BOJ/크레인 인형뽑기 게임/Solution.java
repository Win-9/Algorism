import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int N = moves.length;
        int top = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for(int move : moves) {
            if (!stack.isEmpty()) {
                top = stack.peek();
            }
            
            int doll = getCrane(move, board);
            
            if (doll != 0 && top == doll) {
                answer += 2;
                stack.pop();
                continue;
            }
            stack.push(doll);
        }
        
        return answer;
    }
    
    static int getCrane(int move, int[][] board) {
        for(int i = 0; i < board.length; i++) {
            int num = board[i][move - 1];
            if (num != 0) {
                board[i][move - 1] = 0;
                return num;
            }
        }
        return 0;
    }
}
