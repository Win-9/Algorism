import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        TreeSet<Integer> set = new TreeSet<>((o1, o2) -> o2 - o1);
        
        for(int i = 0; i < operations.length; i++) {
            String[] str= operations[i].split(" ");
            String command = str[0];
            int num = Integer.parseInt(str[1]);
            
            if (command.equals("I")) {
                set.add(num);
            } else {
              if (num == 1) {
                  set.pollFirst();
              } else {
                  set.pollLast();
              }
            }
        }
        
        if (set.isEmpty()) {
            return new int[]{0, 0};
        }
        
        return new int[]{set.first(), set.last()};    
    }
}
