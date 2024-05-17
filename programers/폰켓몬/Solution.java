import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int N = nums.length / 2;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        for(int key : map.keySet()) {
            if (N == 0) {
                break;
            }
            N--;
            count++;
        }
        
        return count;
    }
}
