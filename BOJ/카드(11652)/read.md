# 문제
준규는 숫자 카드 N장을 가지고 있다. 숫자 카드에는 정수가 하나 적혀있는데, 적혀있는 수는 -2&62보다 크거나 같고, 2^62보다 작거나 같다.

준규가 가지고 있는 카드가 주어졌을 때, 가장 많이 가지고 있는 정수를 구하는 프로그램을 작성하시오.
만약, 가장 많이 가지고 있는 정수가 여러 가지라면, 작은 것을 출력한다.

입력
첫째 줄에 준규가 가지고 있는 숫자 카드의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개 줄에는 숫자 카드에 적혀있는 정수가 주어진다.

# 풀이
전에 풀었던 문제와 비슷한 문제이다.
### [베스트셀러] https://github.com/Win-9/Algorism/tree/main/BOJ/%EB%B2%A0%EC%8A%A4%ED%8A%B8%EC%85%80%EB%9F%AC(1302)
이 문제와 거의 동일한 알고리즘을 사용하였다.
HashTable을 이용하여 나온 문자와 그 횟수를 담아두었다.
후에, 숫자를 비교할때는 우선 String으로 비교를 하려고 했는데 compareTo()메소드가 음수까지 String으로 비교하는것은
불가능 하였다. 따라서 타입을 Long으로 변경을하고, 정수를 비교하는 방법을 택했다.

```java
for (String s : map.keySet()) {

			if (map.get(s) == max && Long.parseLong(s) 
					< Long.parseLong(answer)) {
				answer = s;
				continue;
			}

			if (map.get(s) > max) {
				max = map.get(s);
				answer = s;
			}
		}
```
