import java.util.*;
import java.lang.*;
import java.util.stream.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        PriorityQueue<Integer> aQueue = new PriorityQueue<>();
        PriorityQueue<Integer> bQueue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < A.length; i++) {
            aQueue.add(A[i]);
            bQueue.add(B[i]);
        }
        
        for(int i = 0; i < A.length; i++) {
            answer += aQueue.poll() * bQueue.poll();
        }

        return answer;
    }
}
