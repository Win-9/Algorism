import java.util.*;
import java.lang.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int leftIndex = 0;
        int rightIndex = 1;
        int minLength = 10000000;
        int leftAnswer = 0;
        int rightAnswer = 0;
        int sum = sequence[leftIndex];

        while (leftIndex != rightIndex) {
            if (sum < k) {
                if (rightIndex >= sequence.length) {
                    break;
                }
                sum += sequence[rightIndex++];
            } else if (sum > k) {
                sum -= sequence[leftIndex++];
            }

            int length = rightIndex - leftIndex + 1;

            if (sum == k) {
                if (minLength > length) {
                    minLength = length;
                    leftAnswer = leftIndex;
                    rightAnswer = rightIndex - 1;
                } else if (minLength == length && leftAnswer > leftIndex) {
                    leftAnswer = leftIndex;
                    rightAnswer = rightIndex - 1;
                }
                sum -= sequence[leftIndex++];
            }
        }
        
        return new int[]{leftAnswer, rightAnswer};
    }
}
