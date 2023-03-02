import java.util.*;
import java.lang.*;

class Solution {
    static Set<Integer> set = new HashSet<>();

    public int solution(int[] elements) {
        int[] elem = new int[elements.length * 2];
        
        System.arraycopy(elements, 0, elem, 0, elements.length);
        System.arraycopy(elements, 0, elem, elements.length, elements.length);
        
        int count = 0;
        int end = 1;
        while(count < elements.length) {
            int start = 0;

            for(int i = start; i < elements.length; i++) {
                add(elem, i, i + end);
            }
            end++;
            count++;
        }
        
        return set.size();
    }
    
    static void add(int[] elements, int start, int end) {
        int sum = 0;

        for(int i = start; i < end; i++) {
            sum += elements[i];
        }
        set.add(sum);
    }
}
