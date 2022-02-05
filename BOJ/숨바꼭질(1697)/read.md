# 문제

수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 
수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

입력
첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

출력
수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.



# 풀이

좌표를 탐색하며 이동할때는 보통 4가지 방향으로 탐색했는데 이와 비슷한 느낌으로 풀이했다.

n-1, n+1, nx2 이 3가지를 가지고 bfs를 한다고 생각을 하였다.
따라서 이 각각의 조건들이 주어진 범위에 포함되고, 방문의 여부에 따라서 bfs를 실행하였다.
```java
while (!queue.isEmpty()) {
			loc = queue.poll();

			if (loc.N == K)
				break;

			
			if (loc.N - 1 <= 100000 && loc.N - 1 >= 0 && !visited[loc.N - 1]) {
				visited[loc.N - 1] = true;
				queue.add(new Location(loc.N - 1, loc.count + 1));
			}
			
			if (loc.N + 1 <= 100000 && loc.N + 1 >= 0 && !visited[loc.N + 1]) {
				visited[loc.N + 1] = true;
				queue.add(new Location(loc.N + 1, loc.count + 1));
			}
			
			if (loc.N * 2 <= 100000 && loc.N * 2 >= 0 && !visited[loc.N * 2]) {
				visited[loc.N * 2] = true;
				queue.add(new Location(loc.N * 2, loc.count + 1));
			}
			

		}
```
