import java.util.*;
import java.lang.*;
import java.util.stream.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Integer[] bArray = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(A);
        Arrays.sort(bArray,Collections.reverseOrder());
        for(int i = 0; i < A.length; i++) {
            answer += A[i] * bArray[i]; 
        }

        return answer;
    }
}
