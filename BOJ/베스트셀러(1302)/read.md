# 문제
김형택은 탑문고의 직원이다. 김형택은 계산대에서 계산을 하는 직원이다.
김형택은 그날 근무가 끝난 후에, 오늘 판매한 책의 제목을 보면서 가장 많이 팔린 책의 제목을 칠판에 써놓는 일도 같이 하고 있다.

오늘 하루 동안 팔린 책의 제목이 입력으로 들어왔을 때, 가장 많이 팔린 책의 제목을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 오늘 하루 동안 팔린 책의 개수 N이 주어진다. 이 값은 1,000보다 작거나 같은 자연수이다. 
둘째부터 N개의 줄에 책의 제목이 입력으로 들어온다. 책의 제목의 길이는 50보다 작거나 같고, 알파벳 소문자로만 이루어져 있다.

# 풀이

입력되는 String과 그 횟수인 Integer를 서로 매핑해야 되는 생각이 들었다.
따라서 HashMap을 사용하여서 이를 매핑하였다.

이미 존재하는 Key면 현재의 Value에서 1을 더해주고, 새로운 Key이면 Value에 1을 put을 하였다.
```java
for (int i = 0; i < N; i++) {
			String key = br.readLine();
			if (map.containsKey(key)) {
				int num = map.get(key);
				map.put(key, ++num);
				continue;
			}
			map.put(key, 1);
		}
 ```
 출력을 할때 가장 큰 value의 key를 찾으면 되는데, 이때 출력된 횟수가 같은 key는
 사전순에서 더 빠른 key가 출력이 되어야 한다. 따라서 이를 필터링 해주어야 한다.
 ```java
 for (String s: map.keySet()) {

			if (map.get(s) == max && answer.compareTo(s) > 0) {
				answer = s;
				continue;
			}
			
			if (map.get(s) > max) {
				max = map.get(s);
				answer = s;
			}
		}
 ```
