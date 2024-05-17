### 문제

리코쳇 로봇이라는 보드게임이 있습니다.

이 보드게임은 격자모양 게임판 위에서 말을 움직이는 게임으로, 시작 위치에서 목표 위치까지 최소 몇 번만에 도달할 수 있는지 말하는 게임입니다.

이 게임에서 말의 움직임은 상, 하, 좌, 우 4방향 중 하나를 선택해서 게임판 위의 장애물이나 맨 끝에 부딪힐 때까지 미끄러져 이동하는 것을 한 번의 이동으로 칩니다.

다음은 보드게임판을 나타낸 예시입니다.

```
...D..R
.D.G...
....D.D
D....D.
..D....
```
여기서 "."은 빈 공간을, "R"은 로봇의 처음 위치를, "D"는 장애물의 위치를, "G"는 목표지점을 나타냅니다.
위 예시에서는 "R" 위치에서 아래, 왼쪽, 위, 왼쪽, 아래, 오른쪽, 위 순서로 움직이면 7번 만에 "G" 위치에 멈춰 설 수 있으며, 이것이 최소 움직임 중 하나입니다.

게임판의 상태를 나타내는 문자열 배열 board가 주어졌을 때, 말이 목표위치에 도달하는데 최소 몇 번 이동해야 하는지 return 하는 solution함수를 완성하세요. 만약 목표위치에 도달할 수 없다면 -1을 return 해주세요.

### 풀이

우선 기본은 BFS나 DFS를 이용하는 것이다.   
기존의 한칸씩 이동하는 탐색과는 다르게 한 방향으로 진행시 장애물을 마주치기 전까지 계속해서 그 방향으로 나아간다.   
이 부분을 구현하는 것이 관건이다.   

필자는 이 부분을 함수를 빼서 따로 구현했다.   
먼저 좌표를 이동할 배열을 먼저 선언해주었다.

```java
static int[] x_loc = {-1, 1, 0, 0};
static int[] y_loc = {0, 0, -1, 1};
```

탐색 부분에서 좌표에 따른 반복을 수행한다.
```java
for(int i = 0; i < 4; i++) {
                int x, y;
                if (i == 0 || i == 1) {
                    x = refeatX(x_loc[i], info.x, info.y);
                    y = info.y;
                } else {
                    x = info.x;
                    y = refeatY(y_loc[i], info.y, info.x);
                }

                if (!visited[x][y]) {
                    visited[x][y] = true;
                    queue.add(new Info(x, y, info.count + 1));
                }
            }
```



이후 X와 Y에 따라 반복을 해주는 함수를 만들었다.   

```java
static int refeatX(int num, int start, int y) {
        int mul = 1;
        int mulNum = 0;
        while(true) {
            mulNum = num * mul + start;
            if (mulNum < 0) {
                return 0;
            }

            if (mulNum > N - 1) {
                return N - 1;
            }

            if ((mulNum >= 0 && mulNum < N) && (map[mulNum][y].equals("D"))) {
                break;
            }
            mul++;
        }
        if (num == 1) {
            return mulNum - 1;
        }
        return mulNum + 1;
    }
```

이후 기존의 BFS를 이용하여 탐색을 진행해주었다.







