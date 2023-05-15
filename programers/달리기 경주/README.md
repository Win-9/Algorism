### 달리기 경주
문제 설명   
얀에서는 매년 달리기 경주가 열립니다.     
해설진들은 선수들이 자기 바로 앞의 선수를 추월할 때 추월한 선수의 이름을 부릅니다.   
예를 들어 1등부터 3등까지 "mumu", "soe", "poe" 선수들이 순서대로 달리고 있을 때,    
해설진이 "soe"선수를 불렀다면 2등인 "soe" 선수가 1등인 "mumu" 선수를 추월했다는 것입니다.    
즉 "soe" 선수가 1등, "mumu" 선수가 2등으로 바뀝니다.   

선수들의 이름이 1등부터 현재 등수 순서대로 담긴 문자열 배열 players와 해설진이 부른 이름을 담은 문자열 배열 callings가 매개변수로 주어질 때,    
경주가 끝났을 때 선수들의 이름을 1등부터 등수 순서대로 배열에 담아 return 하는 solution 함수를 완성해주세요.   

제한사항   
5 ≤ players의 길이 ≤ 50,000   
players[i]는 i번째 선수의 이름을 의미합니다.   
players의 원소들은 알파벳 소문자로만 이루어져 있습니다.   
players에는 중복된 값이 들어가 있지 않습니다.   
3 ≤ players[i]의 길이 ≤ 10   
2 ≤ callings의 길이 ≤ 1,000,000   
callings는 players의 원소들로만 이루어져 있습니다.   
경주 진행중 1등인 선수의 이름은 불리지 않습니다.   

입출력 예

|players|callings|	result|
|-|-|-|
|"mumu", "soe", "poe", "kai", "mine"|	"kai", "kai", "mine", "mine"|	"mumu", "kai", "mine", "soe", "poe"|


### 풀이

문제만 읽고 쉽다고 생각했다가 큰 고뇌에 빠졌다.   
문제에서 하란식으로 풀이했다가 영 좋지못한 상황에 빠졌다.   
한개씩 값을 얻어온 다음에 이를 List에 접근하여 추월한 인원을 앞으로 당기고 다머지를 뒤로 밀어내는 방법으로 풀이했었다.   
리스트로 풀이했더니 이러한 시간초과가 났었나 생각했었고, 다시 배열을 이용해 같은 로직을 구성했다.   
시간이 조금 줄어들었지만 시간초과는 여전했다.   
따라서 O(1)에 접근이 가능한 방법을 찾아야 했다.   
바로 Map을 이용하는 것이다.   
Map은 O(1)에 접근이 가능하다.   

우선 이름으로 순위를 찾을 수 있는 Map과 순위로 이름을 찾을 수 있는 Map을 만들어   
이들을 주어진 값들을 이용하여 초기화 시킨다.   

```java
for(String s : callings) {
            int rank = nameMap.get(s);
            String beforeName = rankMap.get(rank - 1);
            nameMap.put(s, rank - 1);
            nameMap.put(beforeName, rank);
            rankMap.put(rank - 1, s);
            rankMap.put(rank, beforeName);
        }
```
callings의 값을 가져와서 순위를 가져온 다음 
순위를 이용하여 해당 순위의 앞에 있는 player를 저장한다.   
이후 순위를 조정해주는 값들을 Put 시켜주도록 한다.   
Map은 같은 Key가 들어가면 Key가 덮어써지므로 이런 풀이가 가능하다.   
이런 창의력이 샘솟는 문제는 아직 너무 부족하다.... 더 연습하자...!







