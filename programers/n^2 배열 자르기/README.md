### 문제 설명
정수 n, left, right가 주어집니다. 다음 과정을 거쳐서 1차원 배열을 만들고자 합니다.   

n행 n열 크기의 비어있는 2차원 배열을 만듭니다.   
i = 1, 2, 3, ..., n에 대해서, 다음 과정을 반복합니다.   
1행 1열부터 i행 i열까지의 영역 내의 모든 빈 칸을 숫자 i로 채웁니다.   
1행, 2행, ..., n행을 잘라내어 모두 이어붙인 새로운 1차원 배열을 만듭니다.   
새로운 1차원 배열을 arr이라 할 때, arr[left], arr[left+1], ..., arr[right]만 남기고 나머지는 지웁니다.   
정수 n, left, right가 매개변수로 주어집니다. 주어진 과정대로 만들어진 1차원 배열을 return 하도록 solution 함수를 완성해주세요.   

제한사항   
1 ≤ n ≤ 107   
0 ≤ left ≤ right < n2   
right - left < 105   

입출력 예   
|n|	left|	right|	result|
|-|-|-|-|
|3|	2|	5|	[3,2,2,3]|
|4|	7|	14	|[4,3,3,3,4,4,4,4]|


### 풀이

문제에 친절하게 애니메이션을 제시했다.   
그래서 그거대로 구현했었는데...
따란~ 함정이었습니다.~~

힌트에 right - left < 10^5가 제시 되었을때 눈치 챘어야 했는데...   
애니메이션대로 구현하면 범위가 초과된다.   

따라서 다른 방법을 구해야 하는데 완성된 배열을 보자면    

![image](https://user-images.githubusercontent.com/80390524/219923255-45b62119-f716-4f54-b63b-4d9c96a8df14.png)   

|(1,1)|(1,2)|(1,3)|
|-|-|-|
|(2,1)|(2,2)|(2,3)|
|(3,1)|(3,2)|(3,3)|

저런식으로 행렬좌표로 나타내었을때, 행과 열중 더 큰 값이 그 value로 들어가게된다!   
즉 각 좌표에서 x,y를 비교하여 더 큰값을 그 value로 넣는다.  


```java
for(int i = 0; i < answer.length; i++) {
            int row = (int)((i + left) / n) + 1;
            int col = (int)((i + left) % n) + 1;
            answer[i] = Math.max(row, col);
        }
```

i / n과 i % n을 하는 이유는 각각 행과 열을 값을 구할 수 있기 때문이다.   
i가 증가할때 n을 나누면 행은 0, 1, 2가 천천히 증가하는 반면, n을 mod연산해주면 그에따른 행이 추출되기때문이다.   
(이해가 되지 않는다면 숫자를 넣어가면서 이해해보자)   
+1은 좌표 보정값이다.   

이중 더 큰 값을 구하려는 배열인 answer에 넣는다.
