import java.lang.*;
import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        List<Long> list = new ArrayList<>();
        
        for(long i : numbers) {
            int count = 1;
            while(true) {
                if (check(i, i + count)) {
                    list.add(i + count);
                    break;
                }
                count++;
            }
        }
        
        return list.stream().mapToLong(i -> Long.valueOf(i)).toArray();
    }
    
    static boolean check(long first, long second) {

        long num = first ^ second;
        String str = Long.toBinaryString(num);
        str = str.replaceAll("0", "");
        if (str.length() > 2) {
            return false;
        }
        return true;
    }
}
