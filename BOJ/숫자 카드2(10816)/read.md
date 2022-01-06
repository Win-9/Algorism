# 문제
숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다
. 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다.
둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다. 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.

셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다. 넷째 줄에는 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수가 주어지며, 
이 수는 공백으로 구분되어져 있다. 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.

# 풀이
간단하게 생각했다가 오래걸린문제.

처음 생각한 풀이법은 M개의 숫자카드가 나올때 정렬된 nArr배열에서 bianrySearch로 인덱스를 찾은다음,
이 인덱스를 기준으로 key가 같으면서 가장 왼쪽에 위치한 원소의 인덱스를 구하고
key가 같으면서 가장 오른쪽에 위치한 원소의 인덱스를 구해서 이 두개의 인덱스를 빼는 방식이었다.

```java
static int findSameIndex(int[]arr, int key, int index) {
		int sum = 0;
		int pr = index;
		int pl = index;
		
		while(pl > -1 && arr[pl--] == key) {
			sum++;
		}
		
		while( pr < arr.length && arr[pr++] == key) {
			sum++;
		}
		
		return sum-1;
	}
```
이부분에서 만약 배열 전체가 같은 key라고 가정한다면 결국 O(N)이므로 시간초과가 나게 되었다.


따라서 bianrySearch를 조금 변형시켜서 아랫쪽, 윗쪽을 탐색하도록 하였다.

```java
static int lowerBound(int[] arr, int key) {
		int lo = 0; 
		int hi = arr.length; 
	 
		while (lo < hi) {
	 
			int mid = (lo + hi) / 2;
			if (key <= arr[mid]) {
				hi = mid;
				continue;
			}
			lo = mid + 1;
	 
		}
		return lo;
	}
```
lowerBound는 같은 원소의 가장 왼쪽의 요소에 lo,hi가 위치하여 return 하는 방식이고,
upperBounder는 같은 원소의 가장 오른쪽의 요소에 lo,hi가 위치하여 return 하는 방식이다.

return된 이 인덱스들의 차를 구하여 갯수를 구한다.
