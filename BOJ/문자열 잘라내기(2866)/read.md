# 문제
R개의 행과 C개의 열로 이루어진 테이블이 입력으로 주어진다. 이 테이블의 원소는 알파벳 소문자이다.

각 테이블의 열을 위에서 아래로 읽어서 하나의 문자열을 만들 수 있다. 예제 입력에서

dobarz
adatak
이 주어지는 경우 "da", "od", "ba", "at", "ra", "zk"와 같이 6개의 문자열들이 만들어지게 된다.

만약 가장 위의 행을 지워도 테이블의 열을 읽어서 문자열이 중복되지 않는다면, 가장 위의 행을 지워주고, count의 개수를 1 증가시키는, 이 과정을 반복한다.
만약 동일한 문자열이 발견되는 경우, 반복을 멈추고 count의 개수를 출력 후 프로그램을 종료한다.

테이블이 주어질 경우 count의 값을 구해보자.

입력
첫 번째 줄에는 테이블의 행의 개수와 열의 개수인 R과 C가 주어진다. (2 ≤ R, C ≤ 1000)

이후 R줄에 걸쳐서 C개의 알파벳 소문자가 주어진다. 가장 처음에 주어지는 테이블에는 열을 읽어서 문자열을 만들 때, 동일한 문자열이 존재하지 않는 입력만 주어진다.

출력
문제의 설명과 같이 count의 값을 출력한다.


# 풀이

어렵지 않았는데 시간을 줄여보려고 이상한 방법들을 생각하다가 오래걸렸다.
처음 생각 했던겄은 행에서 공통된 부분을 찾고 그 부분에서 열을 조사하려고 했는데
행에서 공통된 부분을 찾는것이 우선 이진 탐색을 해야 하니까, 정렬을 해야 되고 거기서 또 원래의 인덱스를 찾는 과정이
쉽지 않았다. 따라서 문제에서 하라는 순서대로 알고리즘을 짰다.

문자를 2차원array로 하나씩 받은다음, 열별로 문자를 받아 stringArray를 재구성 하였다.
```java
for (int i = 0; i < R; i++) {
			strArr[i] = br.readLine().toCharArray();
		}

		String[] Rstr = new String[C];
		for (int j = 0; j < C; j++) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < R; i++) {
				sb.append(strArr[i][j]);
			}
			Rstr[j] = sb.toString();
		}
```
이를 제일 위의 행부터 줄여나가서 각 문자열들을 Set으로 add를 한다음
공통된 문자를 찾으면 count를 출력하도록 하였다.
```java
for (int i = 0; i < R; i++) {
			HashSet<String> set = new HashSet<>();
			for (int j = 0; j < C; j++) {
				String ex = Rstr[j];
				if (set.contains(ex.substring(i))) {
					System.out.println(count - 1);
					return;
				}
				set.add(ex.substring(i));
			}
			count++;
		}
		
		System.out.println(count - 1);
 ```
