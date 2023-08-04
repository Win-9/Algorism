import java.lang.*;
import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        double numA = (double) a;
        double numB = (double) b;
        
        int answer = 1;
        while(true) {
            numA = Math.round(numA / 2);
            numB = Math.round(numB / 2);
            
            if (numA == numB) {
                break;
            }
            
            answer++;
        }

        return answer;
    }
}
