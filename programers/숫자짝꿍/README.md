### 문제

두 정수 X, Y의 임의의 자리에서 공통으로 나타나는 정수 k(0 ≤ k ≤ 9)들을 이용하여 만들 수 있는 가장 큰 정수를 두 수의 짝꿍이라 합니다(단, 공통으로 나타나는 정수 중 서로 짝지을 수 있는 숫자만 사용합니다).   

X, Y의 짝꿍이 존재하지 않으면, 짝꿍은 -1입니다. X, Y의 짝꿍이 0으로만 구성되어 있다면, 짝꿍은 0입니다.   

예를 들어, X = 3403이고 Y = 13203이라면, X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 3, 0, 3으로 만들 수 있는 가장 큰 정수인 330입니다.   

다른 예시로 X = 5525이고 Y = 1255이면 X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 2, 5, 5로 만들 수 있는 가장 큰 정수인 552입니다(X에는 5가 3개, Y에는 5가 2개 나타나므로 남는 5 한 개는 짝 지을 수 없습니다.)


두 정수 X, Y가 주어졌을 때, X, Y의 짝꿍을 return하는 solution 함수를 완성해주세요.


### 풀이

X와 Y의 공통 글자를 찾아서 이를 최대로 큰 정수를 만들어야 한다.   
X에서 문자 하나를 뽑아서 이를 Y에서 해당 인덱스를 찾아서 존재 한다면 이를 Y에서 삭제하고 다른 LIST에 저장하도록 구현을 했다.   

```java
class Solution {
    public String solution(String X, String Y) {
        String answer = new StringBuilder();
        StringBuilder yStr = new StringBuilder(Y);
        List<String> list = new ArrayList<>();
        
        for(int i = 0; i < X.length(); i++) {   // 짝 담기
            String str = X.substring(i, i + 1);
            int index = yStr.indexOf(str);
            
            if (index == -1) {
                continue;
            }
            
            yStr.deleteCharAt(index);
            list.add(str);
        }
        
        if (list.size() == 0) {
            return "-1";
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        if (list.get(0).equals("0")) {
                return "0";
        }
        
        for(String s : list) {
            answer.append(s);
        }
        
        return answer.toString();
    }
}
```

그러나 이 코드는 시간초과가 났다.    
Y가 매우 큰 수라면 indexOf를 사용하는것은 결국 전체순환을 하는것이기 때문에 O(N^2)이 되기 때문이다.   
따라서 Y를 전체 순회하지 않고 한번만 순회하면 이후에 O(1)접근 가능한 Map으로 정리하여 동일한 로직을 구현했다.   

```java
class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        List<String> list = new ArrayList<>();
        Map<String, Integer> yMap = new HashMap<>();
        for(int i = 0; i < Y.length(); i++) {
            String str = Y.substring(i, i + 1);
            yMap.put(str, yMap.getOrDefault(str, 0) + 1);
        }
        
        for(int i = 0; i < X.length(); i++) {   // 짝 담기
            String str = X.substring(i, i + 1);
            Integer index = yMap.get(str);
            
            if (index == null || index <= 0) {
                continue;
            }
            yMap.put(str, yMap.get(str) - 1);
            list.add(str);
        }
        
        if (list.size() == 0) {
            return "-1";
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        if (list.get(0).equals("0")) {
            return "0";
        }
        
        for(String s : list) {
            answer.append(s);
        }
        
        return answer.toString();
    }
}
```
Map을 하나 추출할 때 마다 -1씩 감소하는데 0에 도달하면 해당 key를 없애야 되는데 if문을 사용하면 너무 보기 좋지 않은 코드가 될 것 같아서   
key가 0이하일때의 조건식만 추가하여 이를 거르도록 하였다.   
