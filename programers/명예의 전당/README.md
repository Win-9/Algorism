### 문제
"명예의 전당"이라는 TV 프로그램에서는 매일 1명의 가수가 노래를 부르고,   
시청자들의 문자 투표수로 가수에게 점수를 부여합니다.   
매일 출연한 가수의 점수가 지금까지 출연 가수들의 점수 중 상위 k번째 이내이면 해당 가수의 점수를 명예의 전당이라는 목록에 올려 기념합니다.   
즉 프로그램 시작 이후 초기에 k일까지는 모든 출연 가수의 점수가 명예의 전당에 오르게 됩니다.   
k일 다음부터는 출연 가수의 점수가 기존의 명예의 전당 목록의 k번째 순위의 가수 점수보다 더 높으면,   
출연 가수의 점수가 명예의 전당에 오르게 되고 기존의 k번째 순위의 점수는 명예의 전당에서 내려오게 됩니다.

이 프로그램에서는 매일 "명예의 전당"의 최하위 점수를 발표합니다.    
예를 들어, k = 3이고, 7일 동안 진행된 가수의 점수가 10, 100, 20, 150, 1, 100, 200 이라면,     
명예의 전당에서 발표된 점수는 아래의 그림과 같이 10, 10, 10, 20, 20, 100, 100입니다.   

![image](https://user-images.githubusercontent.com/80390524/216221108-82791070-a87c-43e6-9ee5-a8d46144e84e.png)



명예의 전당 목록의 점수의 개수 k, 1일부터 마지막 날까지 출연한 가수들의 점수인 score가 주어졌을 때,    
매일 발표된 명예의 전당의 최하위 점수를 return하는 solution 함수를 완성해주세요.   

제한사항   
3 ≤ k ≤ 100   
7 ≤ score의 길이 ≤ 1,000   
0 ≤ score[i] ≤ 2,000   

입출력 예   
|k|score|result|
|-|-|-|
|3|10, 100, 20, 150, 1, 100, 200|	10, 10, 10, 20, 20, 100, 100|
|4|0, 300, 40, 300, 20, 70, 150, 50, 500, 1000|0, 0, 0, 0, 20, 40, 70, 70, 150, 300|


### 풀이

문제를 살펴보자면,   
K일 까지는 탈락을 고려하지 않고 순위를 누적 시킨 후에,   
K일이 넘어가면 탈락 후에 순위를 정한 후 최저점을 기록한다.   

즉, 정렬 후 탈락 이후 최저점 기록이라는 순서가 생긴다.   
이 순서대로 알고리즘을 구성하였다.   

```java
scoreList.add(score[i]);
Collections.sort(scoreList);
            
if (scoreList.size() > k){
  scoreList.remove(0);
}
            
answerList.add(scoreList.get(0));
```

순위를 기록후에 정렬을 시킨후, K일자가 넘었으면   
오름차순으로 정렬된 리스트에서 가장 앞에온 수는 가장 낮은 점수이니 이를 제거시켜준다.   
이후 최저점을 기록하는 answerList에 가장 낮은 점수인 제일 앞의 숫자를 기록해주도록 한다.



