# 문제

N×N크기의 땅이 있고, 땅은 1×1개의 칸으로 나누어져 있다. 각각의 땅에는 나라가 하나씩 존재하며, r행 c열에 있는 나라에는 A[r][c]명이 살고 있다.
인접한 나라 사이에는 국경선이 존재한다. 모든 나라는 1×1 크기이기 때문에, 모든 국경선은 정사각형 형태이다.

오늘부터 인구 이동이 시작되는 날이다.

인구 이동은 하루 동안 다음과 같이 진행되고, 더 이상 아래 방법에 의해 인구 이동이 없을 때까지 지속된다.

국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루 동안 연다.
위의 조건에 의해 열어야하는 국경선이 모두 열렸다면, 인구 이동을 시작한다.
국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면, 그 나라를 오늘 하루 동안은 연합이라고 한다.
연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 편의상 소수점은 버린다.
연합을 해체하고, 모든 국경선을 닫는다.
각 나라의 인구수가 주어졌을 때, 인구 이동이 며칠 동안 발생하는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N, L, R이 주어진다. (1 ≤ N ≤ 50, 1 ≤ L ≤ R ≤ 100)

둘째 줄부터 N개의 줄에 각 나라의 인구수가 주어진다. r행 c열에 주어지는 정수는 A[r][c]의 값이다. (0 ≤ A[r][c] ≤ 100)

인구 이동이 발생하는 일수가 2,000번 보다 작거나 같은 입력만 주어진다.

출력
인구 이동이 며칠 동안 발생하는지 첫째 줄에 출력한다.



# 풀이
visited를 하지 않은 곳을 탐색하여 주위를 탐색하여 두 인구의 차가 L이상 && R이하가 되는 조건의 수와, 인구 합을 구한다.
이를 ArrayList에 좌표를 저장해 놓는다.
이후 이들의 평균을 방금 탐색한 진영에 반영을 시킨다.
```java
static void findBoundBfs(int i, int j) {
		// TODO Auto-generated method stub
		Queue<Location> queue = new LinkedList<>();
		queue.add(new Location(i, j));
		boolean flag2 = false;
		int count = 0;
		int sum = map[i][j];
		
		visited[i][j] = true;
		locList.add(new Location(i, j));
		while (!queue.isEmpty()) {
			Location loc = queue.poll();
			for (int k = 0; k < 4; k++) {
				int x = loc.x + x_loc[k];
				int y = loc.y + y_loc[k];

				if (x >= 0 && y >= 0 && x < N && y < N) {
					int gap = Math.abs(map[x][y] - map[loc.x][loc.y]);
					if (!visited[x][y] && gap >= L && gap <= R) {
						visited[x][y] = true;
						queue.add(new Location(x, y));
						locList.add(new Location(x, y));
						sum += map[x][y];
						flag = true;
						flag2 = true;
					}
				}
			}
			count++;
		}
		if (!flag2) {
			locList.clear();
			return;
		}
		
		move(count, sum);

	}
```
```javastatic void move(int count, int sum) {
		int avg = sum / count;
		for(Location l : locList) {
			map[l.x][l.y] = avg;
		}
		
	}
```
더이상 탐색할 지점이 없는지, 있는지 각각의 flag를 두어서 더이상 탐색을 
할 지점이 없으면 탐색을 그만두고, 결과를 출력한다.
