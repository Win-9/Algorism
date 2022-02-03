# 문제
정사각형으로 이루어져 있는 섬과 바다 지도가 주어진다. 섬의 개수를 세는 프로그램을 작성하시오.

![image](https://user-images.githubusercontent.com/80390524/152316227-d8da222e-a430-4a52-ac05-c464570d9adb.png)


한 정사각형과 가로, 세로 또는 대각선으로 연결되어 있는 사각형은 걸어갈 수 있는 사각형이다. 

두 정사각형이 같은 섬에 있으려면, 한 정사각형에서 다른 정사각형으로 걸어서 갈 수 있는 경로가 있어야 한다. 지도는 바다로 둘러싸여 있으며, 지도 밖으로 나갈 수 없다.


입력
입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 높이 h가 주어진다. w와 h는 50보다 작거나 같은 양의 정수이다.

둘째 줄부터 h개 줄에는 지도가 주어진다. 1은 땅, 0은 바다이다.

입력의 마지막 줄에는 0이 두 개 주어진다.

출력
각 테스트 케이스에 대해서, 섬의 개수를 출력한다.


# 풀이

변수가 많다보니까, 사용하는데 있어서 헷갈려서 시간이 오래걸렸고, 배열이 갑자기 헷갈리는 부분이 있어서 헤매었다.
dfs나 bfs를 사용하면서 탐색을 해나가면 된다.
해당 좌표가 범위내에 있는 좌표이고, 값이 1이고, 방문을 하지않았다면 queue에 add를 하고 bfs를 진행한다.
```java
while (!queue.isEmpty()) {
			Location loc = queue.poll();
			for (int k = 0; k < 8; k++) {
				int x = loc.x + x_loc[k];
				int y = loc.y + y_loc[k];
				if (x >= 0 && y >=0 && x < h && y < w) {
					if (map[x][y] == 1 && !visited[x][y]) {
						visited[x][y] = true;
						queue.add(new Location(x,y));
					}
				}
				
			}
		}
```

이때 bfs가 진행을 할때마다 멀리떨어진 섬이 존재한다는 이야기 이므로 bfs를 수행마다 count를 더해준다.
```java
for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						bfs(i, j, visited);
						count++;
					}
				}
			}
```
