### 문제

게임 캐릭터를 4가지 명령어를 통해 움직이려 합니다. 명령어는 다음과 같습니다.   

U: 위쪽으로 한 칸 가기   

D: 아래쪽으로 한 칸 가기   

R: 오른쪽으로 한 칸 가기   

L: 왼쪽으로 한 칸 가기   
  
캐릭터는 좌표평면의 (0, 0) 위치에서 시작합니다. 좌표평면의 경계는 왼쪽 위(-5, 5), 왼쪽 아래(-5, -5), 오른쪽 위(5, 5), 오른쪽 아래(5, -5)로 이루어져 있습니다.   

예를 들어, "ULURRDLLU"로 명령했다면

1번 명령어부터 7번 명령어까지 다음과 같이 움직입니다.   

![image](https://github.com/Win-9/Algorism/assets/80390524/3b98e697-f0c3-402e-8f54-7f7621ae8edb)    

8번 명령어부터 9번 명령어까지 다음과 같이 움직입니다.

![image](https://github.com/Win-9/Algorism/assets/80390524/7c70252b-bfac-4bdc-a44a-0739e42c5b73)    

이때, 우리는 게임 캐릭터가 지나간 길 중 캐릭터가 처음 걸어본 길의 길이를 구하려고 합니다.    

예를 들어 위의 예시에서 게임 캐릭터가 움직인 길이는 9이지만, 캐릭터가 처음 걸어본 길의 길이는 7이 됩니다. (8, 9번 명령어에서 움직인 길은 2, 3번 명령어에서 이미 거쳐 간 길입니다)   

단, 좌표평면의 경계를 넘어가는 명령어는 무시합니다.   

명령어가 매개변수 dirs로 주어질 때, 게임 캐릭터가 처음 걸어본 길의 길이를 구하여 return 하는 solution 함수를 완성해 주세요.   



### 풀이

걸어온 길을 기억해야 한다.   
중복되는 길을 배제해야 하므로 이를 담을 수 있는 HashSet을 이용하기로 생각했다.   
처음에는 가려는 장소만 담으려고 했지만 문제가 발생하였다.   

위치가 (1, 1)에 위치해 있다고 한다면 이후에 (1, 2)로 이동한다고 하자.   
이때는 중복이 없으므로 Set에 담을 수 있다.   
그러나 (0, 1)에서 (1, 1)로 이동한다고 하면 도착 좌표만 계산하기 때문에 처음 가는길임에도 불구하고 이는 중복으로 취급된다.   
따라서 시작좌표, 도착좌표 모두를 비교하여 Set에 담도록 해야 한다.   

좌표를 저장할 수 있는 Location 클래스를 만들어서 시작, 끝 좌표 모두를 저장할 수 있도록 하였다.   
Collection에 담을 때 주의해야 할 것은 좌표가 같아도 HashCode가 다르기 때문에 모두 다른 객체로 인식되어서 중복을 체크할 수 없다.   
따라서 hashCode와 equals를 오버라이드 하여야 한다.   

```java
@Override
        public int hashCode() {
            return Objects.hash(beforeX + afterX, beforeY + afterY);
        }
        
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Location)) {
                return false;
            }
            
            Location location = (Location) o;
            
            return ((location.beforeX == this.beforeX && location.beforeY == this.beforeY) &&
                (location.afterX == this.afterX && location.afterY == this.afterY)) ||
                ((location.beforeX == this.afterX && location.beforeY == this.afterY) &&
                (location.afterX == this.beforeX && location.afterY == this.beforeY)); 
        }
```
시작좌표 == 갈곳의 시작좌표 이거나 시작좌표 == 갈 곳의 도착좌표 이면 결국 같은 곳을 중복해서 간 곳이기 때문에 이를 equals처리 해야 한다.


