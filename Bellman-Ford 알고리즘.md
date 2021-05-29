# Bellman-Ford 알고리즘
최단 경로 문제를 풀어주는 알고리즘이다.

![image](https://user-images.githubusercontent.com/80390524/120074414-be693680-c0d7-11eb-90fe-5d951b5fe2a5.png)

그림과 같이 노드 5개, 간선 10개가 있다.

* q에서 e까지 가는 최소값을 구한다고 한다

> 최단경로: dq(e)=q에서 e까지 총 경로
> 비용: c(q,w)=인접 노드간의 비용
> 갱신: dq(e)=min{c(q,w)+dw(e)+c(q,r)+dr(e),c(q,t)+dt(e)}

이떄 각 노드별 경로를 계산하면 dq(e)=min{4,8,5}이므로
최솟값은 4

이를 테이블로 나타내면

* 초기의 테이블


![image](https://user-images.githubusercontent.com/80390524/120074556-5bc46a80-c0d8-11eb-826e-afd12876ee38.png)


초기에 접근 할 수 없는 노드간에는 빈칸으로 표시한다.


* 중간의 테이블

![image](https://user-images.githubusercontent.com/80390524/120074577-7565b200-c0d8-11eb-8230-27981777d996.png)


각 노드별로 접근 할 수 있는 최단 경로를 채워놓고 그보다 더 적은 경로가 발견된다면 최신화 시켜준다.


* 최종테이블

![image](https://user-images.githubusercontent.com/80390524/120074625-a645e700-c0d8-11eb-8c11-24c90bd1fd9f.png)



이와 비슷하게 각라우터들의 최상의 경로를 계산하는 Dijkstra's 알고리즘이 존재한다.
