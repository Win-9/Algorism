# 문제
문제
2차원 평면 위의 점 N개가 주어진다.
좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. 
(-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.

# 풀이

정렬을 응용하여 풀이하는 문제이다.
많은 정렬중, quickSort와 mergeSort를 선택히야 하는데, quickSort는 최악의 경우 O(N^2)이기 때문에
속도를 보장해 줄 수 있는 mergeSort를 구현하여 구현을 한다.
좌표 class를 따로 두어서 mergerSort를 구현한다.
이때 ArrayList나 Array를 써서 Collection.sort를 이용하여 Comparator를 구현하면 간단히 정렬 되지만,
직접 구현하고자 사용하지 않고 문제를 푼다.

```java
class Location {
	int x;
	int y;

	public Location(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
}
```
좌표를 나타내는 class

```java
static boolean compare(Location loc1, Location loc2) {
		if (loc1.x < loc2.x) {
			return true;
		}

		if (loc1.x == loc2.x) {
			if (loc1.y < loc2.y) {
				return true;
			}
		}

		return false;
	}
```
문제에서 제시한 대로 x좌표의 비교와 y좌표의 비교순으로 정렬을 하도록 한다.

이후 mergeSort에서 compare메소드를 기준으로 병합을 하도록 한다.
