### 문제

햄버거 가게에서 일을 하는 상수는 햄버거를 포장하는 일을 합니다.   
함께 일을 하는 다른 직원들이 햄버거에 들어갈 재료를 조리해 주면 조리된 순서대로 상수의 앞에 아래서부터 위로 쌓이게 되고,    
상수는 순서에 맞게 쌓여서 완성된 햄버거를 따로 옮겨 포장을 하게 됩니다. 상수가 일하는 가게는 정해진 순서(아래서부터, 빵 – 야채 – 고기 - 빵)로 쌓인 햄버거만 포장을 합니다. 

상수는 손이 굉장히 빠르기 때문에 상수가 포장하는 동안 속 재료가 추가적으로 들어오는 일은 없으며, 재료의 높이는 무시하여 재료가 높이 쌓여서 일이 힘들어지는 경우는 없습니다.

예를 들어, 상수의 앞에 쌓이는 재료의 순서가 [야채, 빵, 빵, 야채, 고기, 빵, 야채, 고기, 빵]일 때, 상수는 여섯 번째 재료가 쌓였을 때,   
세 번째 재료부터 여섯 번째 재료를 이용하여 햄버거를 포장하고, 아홉 번째 재료가 쌓였을 때, 두 번째 재료와 일곱 번째 재료부터   
아홉 번째 재료를 이용하여 햄버거를 포장합니다. 즉, 2개의 햄버거를 포장하게 됩니다.

상수에게 전해지는 재료의 정보를 나타내는 정수 배열 ingredient가 주어졌을 때, 상수가 포장하는 햄버거의 개수를 return 하도록 solution 함수를 완성하시오.

제한사항   
1 ≤ ingredient의 길이 ≤ 1,000,000   
ingredient의 원소는 1, 2, 3 중 하나의 값이며, 순서대로 빵, 야채, 고기를 의미합니다.   

입출력 예   

|ingredient	|result|
|-|-|
|2, 1, 1, 2, 3, 1, 2, 3, 1|	2|
|1, 3, 2, 1, 2, 1, 3, 1, 2|0|



### 풀이

처음에 했던 풀이 이다.
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
인덱스를 잘라서 현재부터~ 4번째 범위의 일치여부를 확인했다.   
일치 한다면 그 즉시 범위를 삭제하고 처음부터 다시 탐색을 하는 방식이다.   
그러나 시간초과가 났다.   
인덱스와 조건이 일치를 했을때 처음부터 다시 탐색을 해야 하니 시간초과 오류가 생겼다.   

따라서 다시 생각해 본것이 탐색을 처음부터가 아니라 인덱스가 삭제된 이후부터 하는 것이다.   
이렇게 한다면 시간초과 오류를 해결할 수 있다.
