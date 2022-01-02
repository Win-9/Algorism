# 소트 인사이드
배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.

# 풀이

단순히 정렬을 하면 되는 문제이다. 시간과 메모리가 충분히 주어지고 있기 때문에 버블정렬과 같이 O(N^2)이 되는 선택, 삽입 등등을 제외하고
다른 정렬을 사용한다면 충분히 쉬운 문제였다. 
컬렉션 프레임 워크말고 손수 구현해서 복습하는겸 quickSort를 구현하였다.
```java
public static void quickSorting(int[] arr, int left, int right) {
		int pl = left;
		int pr = right;
		int x = arr[(pl + pr) / 2];

		while (pl <= pr) {
			while (arr[pl] > x)
				pl++;
			while (arr[pr] < x)
				pr--;

			if (pl <= pr) {
				swap(arr, pl++, pr--);
			}
		}

		if (left < pl)
			quickSorting(arr, left, pr);
		if (right > pr)
			quickSorting(arr, pl, right);
	}
```
