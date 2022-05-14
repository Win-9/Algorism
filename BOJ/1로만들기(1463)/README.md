# 문제

정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다.
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.

입력
첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.

출력
첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.


# 풀이

주어진 3가지의 경우에따라 쭉쭉 가지치기를 하며 다음 연산을 이어나가야 한다.   
DP로 문제를 풀이할 수 있지만, 우선 BFS를 이용하여 문제를 풀이하였다.

주어진 조건인, 3,2로 나누어 떨어질때는 각각의 계산을 한 후, 이를 queue에 넣어주어 전형적인 bfs를 완성하여 풀이하였다.
```java
while (!queue.isEmpty()) {
			w = queue.poll();
			if (w.N == 1)
				break;

			int num = w.N % 3;
			if (num == 0 && !visited[w.N / 3]) {
				visited[w.N / 3] = true;
				queue.add(new Count(w.N / 3, w.count + 1));
			}

			num = w.N % 2;

			if (num == 0 && !visited[w.N / 2]) {
				visited[w.N / 2] = true;
				queue.add(new Count(w.N / 2, w.count + 1));
			}

			num = w.N - 1;

			if (num >= 0 && !visited[w.N - 1]) {
				visited[w.N - 1] = true;
				queue.add(new Count(w.N - 1, w.count + 1));
			}

		}
 ```
