import java.lang.*;
import java.util.*;

class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n >= a) {
            int num = (n / a) * a;  // 가져갈 빈병
            int sum = 0;
            n -= num;  // 나머지병
            sum += (num / a) * b; // 받은 콜라
            n += sum; // 추가된 빈병
            answer += sum;
        }
        return answer;
    }
}
