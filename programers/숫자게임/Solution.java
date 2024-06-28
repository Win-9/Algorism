import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int AIndex = 0;
        int BIndex = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        
         while (AIndex < A.length && BIndex < B.length) {
            if (A[AIndex] > B[BIndex]) {
                BIndex++;
            } else if (A[AIndex] < B[BIndex]) {
                answer++;
                BIndex++;
                AIndex++;
            } else {
                BIndex++;
            }
        }
        
        return answer;
    }
}
