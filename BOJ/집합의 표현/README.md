### 문제

초기에 
n+1개의 집합  
{0},{1},...,{n} 이 있다. 여기에 합집합 연산과, 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산을 수행하려고 한다.   

집합을 표현하는 프로그램을 작성하시오.   


### 풀이

집합이 어느 곳에 속하여 있는지 판별하여 그에따라 출력을 해야 한다.   
우선 유니온-파인드 알고리즘을 구현하였다.   


```java
static void union(int x, int y, int[] parent) {
        // 서로의 root노드를 찾음
        x = find(x, parent);
        y = find(y, parent);

        if (x <= y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }

    }

    static int find(int x, int[] parent) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x], parent);
    }
```

union함수는 x와 y의 부모가 적혀있는 parent 배열을 수정하는 함수이다.   
find함수는 x원소의 부모를 찾는 함수 이다.   
따라서 0일때는 union함수를 이용하여 집합을 합치고, 아닐 때에는 find로 부모를 비교하여 서로 같은 집합에 속하는 지 판별하면 된다.    

여기서 논해야 할 점은 성능이다.   

이전에 구현한 find는 다음과 같다.
```java
static int find(int x, int[] parent) {
        if (parent[x] == x) {
            return x;
        }
        return find(parent[x], parent);
    }

```

위 코드는 서브트리를 거쳐서 root까지 끝까지 올라간다.  
그러나 
```java
static int find(int x, int[] parent) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x], parent);
    }
```
이 코드는 서브트리를 한번만 거치면 가장 꼭대기의 parent를 바로 삽입하므로 경로 압축이 된다.   

예시를 들어보면
```bash
7 4
0 1 3
0 7 6
0 3 6
1 7 6
```

다음과 같은 입력이 주어진다고 하자.   

모든 입력이 끝난후에 최적화 전의 코드의 parent는 `0 1 2 1 4 5 1 6`이다.   
즉, 서브트리의 루트로만 갱신이 되므로 매 탐색마다 root까지 매번 올라가야 한다.   

최적화 후의 코드의 parent는 `0 1 2 1 4 5 1 1 `이다   
즉, 자신이 속한 루트로 바로 갱신이 되므로 경로압축이 되므로 성능이 좋아지는 모습을 볼 수 있다.


