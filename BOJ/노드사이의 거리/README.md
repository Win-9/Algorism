### 문제

$N$개의 노드로 이루어진 트리가 주어지고 M개의 두 노드 쌍을 입력받을 때 두 노드 사이의 거리를 출력하라.

### 풀이

노드간의 거리를 구해야 하는 문제이다.   
우선 노드간의 비용을 이차원 배열을 이용하여 나타내주었다.   
이차원 배열에서 BFS 탐색을 진행하여 비용을 계산하였는데, 비용 계산하는 부분이 만만치 않았다.   

다른 자료를 참고한 결과
`int[] distance = new int[N + 1]`와 같은 배열을 BFS동작 초기 시 하나 선언하여   
탐색시의 비용을 누적해준다. 

```java
for (int i = 1; i <= N; i++) {
                if (!visited[i] && cost[w][i] < MAX_INT) {
                    distance[i] = cost[w][i] + distance[w];
                    visited[i] = true;
                    queue.add(i);
                }
            }
```
누적한 결과를 그대로 저장하고 다음 poll시 가져올 수 있으므로 거리를 누적해서 더할 수 있다.   

BFS말고도 플로이드 워셜을 이용하여 한번에 비용을 나타내는 것도 가능하다.
