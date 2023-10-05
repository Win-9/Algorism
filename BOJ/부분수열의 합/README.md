### 문제

N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.

### 풀이

우선 부분수열이란 걸 뭔지 정리하고 가자.   
수열을 집합으로 보자.   
이때의 부분집합을 부분수열이라고 한다.   
가령 {1,2,3,4} 수열이 있다면 {1}, {2}, {3}, {1,2}, {1, 3}... 이런 것들이   
모두 부분수열이라는 것이다.    
부분수열이라고 해서 연속될 필요는 없는 것이다.   
필자는 후자의 의미로 이해하여 다음과 같은 풀이를 했었다.   

```java
static void track(int N, int S, int[] arr, int start, int sum) {
        if (sum == S) {
            answer++;
        }

        if (start + 1 == N) {
            return;
        }

        track(N, S, arr, start + 1, sum + arr[start + 1]);
    }
```

연속된다고 가정 하였을때 그 합을 구하는 풀이다.   
그러나 이것은 우리가 원하는 부분 수열이 아니다.   
각설하고, 여기서 원하는 것은 즉 조합임을 알 수 있다.   
따라서 조합을 구할때와 비슷한 풀이를 응용해서 하였다.   

```java
static void track(int depth, int r, int[] arr, boolean[] visited, int start, int sum) {
        if (depth == r) {
            if (sum == S) {
                answer++;
            }
            return;
        }

        for(int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                track(depth + 1, r, arr, visited, i, sum + arr[i]);
                visited[i] = false;
            }
        }
    }
```

