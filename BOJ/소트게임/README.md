### 문제

홍준이는 소트 게임을 하려고 한다. 소트 게임은 1부터 N까지 정수로 이루어진 N자리의 순열을 이용한다. 이 게임에선 K가 주어진다. 어떤 수를 뒤집으면, 

그 수부터 오른쪽으로 K개의 수를 뒤집어야 한다. 예를 들어, 순열이 5 4 3 2 1 이었고, 여기서 K가 3일 때, 4를 뒤집으면 5 2 3 4 1이 된다. 반드시 K개의 수를 뒤집어야하기 때문에, 처음 상태에서 2나 1을 선택하는 것은 불가능하다.

입력으로 들어온 순열을 오름차순으로 만들려고 한다. 게임을 최대한 빨리 끝내고 싶을 때, 수를 최소 몇 개 선택해야 하는지 구해보자.


### 풀이

숫자를 뒤집어서 정렬된 숫자를 만들어야한다.   

숫자를 뒤집는 방법규칙은???   
규칙은 없다. 즉, 모든 경우를 탐색해야 한다.   
따라서 BFS를 이용하여 탐색하는 것을 생각하였다.   

뒤집는 수의 우측 숫자의 갯수가 N보다 적으면 뒤집을 수가 없다.  
이를 이용하여 범위를 정하여 모든 범위를 탐색해준다.   

visited처리는??   
N은 최대 8자리 이므로 배열 범위가 초과가 나지 않기 때문에 배열을 이용하여 방문처리를 해도 되고,   
set을 이용한 방문처리도 괜찮다고 생각한다.
