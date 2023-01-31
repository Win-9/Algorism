



### 풀이

```java
import java.lang.*;
import java.util.*;

class Solution {
    static int[] result = {1, 2, 3, 1};
    public int solution(int[] ingredient) {
        int answer = 0;
        int count = 1;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < ingredient.length; i++) {
            list.add(ingredient[i]);
        }


        for(int i = 0; i < list.size() - 3; i++) {            
            if (list.get(i) == 1 && match(list, i)) {
                list.subList(i, i + 4).clear();
                answer++;
                i = -1;
            }
        }
        
        return answer;
    }
    
    static boolean match(List<Integer> list, int index) {
        for(int i = 0; i < 4; i++) {
            if (result[i] != list.get(index++)) {
                return false;
            }
        }
        
        return true;
    }
}
```
