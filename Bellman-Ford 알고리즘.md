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



```java
class Graph{
    private int n;           //노드들의 수
    private int maps[][];    //노드들간의 가중치 저장할 변수
 
    public Graph(int n){
        this.n = n;
        maps = new int[n+1][n+1];
         
    }
    public void input(int i,int j,int w){
        maps[i][j] = w;
        maps[j][i] = w;
    }
 
    public void dijkstra(int v){
        int distance[] = new int[n+1];          //최단 거리를 저장할 변수
        boolean[] check = new boolean[n+1];     //해당 노드를 방문했는지 체크할 변수
         
        //distance값 초기화.
        for(int i=1;i<n+1;i++){
            distance[i] = Integer.MAX_VALUE;
        }
         
        //시작노드값 초기화.
        distance[v] =0;
        check[v] =true;
         
        //연결노드 distance갱신
        for(int i=1;i<n+1;i++){
            if(!check[i] && maps[v][i] !=0){
                distance[i] = maps[v][i];
            }
        }
         
         
        for(int a=0;a<n-1;a++){ 
            //원래는 모든 노드가 true될때까지 인데 
            //노드가 n개 있을 때 다익스트라를 위해서 반복수는 n-1번이면 된다.
            //원하지 않으면 각각의 노드가 모두 true인지 확인하는 식으로 구현해도 된다.
            int min=Integer.MAX_VALUE;
            int min_index=-1;
             
            //최소값 찾기
            for(int i=1;i<n+1;i++){
                if(!check[i] && distance[i]!=Integer.MAX_VALUE){
                    if(distance[i]<min ){
                        min=distance[i];
                        min_index = i;
                    }
                }
            }
             
            check[min_index] = true;
            for(int i=1;i<n+1;i++){
                if(!check[i] && maps[min_index][i]!=0){
                    if(distance[i]>distance[min_index]+maps[min_index][i]){
                        distance[i] = distance[min_index]+maps[min_index][i];
                    }
                }
            }
 
        }
         
        //결과값 출력
        for(int i=1;i<n+1;i++){
            System.out.print(distance[i]+" ");
        }
        System.out.println("");
         
    }
}

```
