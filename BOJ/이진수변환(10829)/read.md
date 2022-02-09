# 문제
자연수 N이 주어진다. N을 이진수로 바꿔서 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 N이 주어진다. (1 ≤ N ≤ 100,000,000,000,000)

출력
N을 이진수로 바꿔서 출력한다. 이진수는 0으로 시작하면 안 된다.


# 풀이

2가지로 풀이했는데 반복문과 재귀를 이용해서 풀이하였다.
결과는 재귀가 더 빠른것으로 나왔다.

우선 동작은 N이 2로 나눌때마다, 나머지값을 sb에 append시킨다.
마짐막에 N이 나누어질때 N의값이 1이면 sb에 추가로 1을 append시키고, 0이면 그대로 종료시키고,
sb의 거꾸로된 값을 출력한다.
```java
static void binaryV1(long N) {
		while(true) {
			long num1 = N % 2;
			N /= 2;
			
			if (N == 1L) {
				sb.append(num1).append(N);
				break;
			}
			else if(N == 0L) {
				sb.append(num1);
				break;
			}
			
			sb.append(num1);
			
		}
		
		System.out.println(sb.reverse());
	}
  ```
```java
static void binaryV2(long N) {
		
		if (N == 0) {
			sb.append(0);
			return;
		}
		
		if (N == 1) {
			sb.append(1);
			return;
		}
		
		long num1 = N % 2;
		sb.append(num1);
		binaryV2(N/2);
	}
```
