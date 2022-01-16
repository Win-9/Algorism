# 문제
연종이는 엄청난 기억력을 가지고 있다. 그래서 하루 동안 본 정수들을 모두 기억 할 수 있다.
하지만 이를 믿을 수 없는 동규는 그의 기억력을 시험해 보기로 한다. 동규는 연종을 따라 다니며, 연종이 하루 동안 본 정수들을 모두 ‘수첩1’에 적어 놓았다.
그것을 바탕으로 그가 진짜 암기왕인지 알아보기 위해, 동규는 연종에게 M개의 질문을 던졌다.
질문의 내용은 “X라는 정수를 오늘 본 적이 있는가?” 이다. 
연종은 막힘없이 모두 대답을 했고, 동규는 연종이 봤다고 주장하는 수 들을 ‘수첩2’에 적어 두었다.
집에 돌아온 동규는 답이 맞는지 확인하려 하지만, 연종을 따라다니느라 너무 힘들어서 여러분에게 도움을 요청했다. 
동규를 도와주기 위해 ‘수첩2’에 적혀있는 순서대로, 각각의 수에 대하여, ‘수첩1’에 있으면 1을, 없으면 0을 출력하는 프로그램을 작성해보자.

입력
첫째 줄에 테스트케이스의 개수 T가 들어온다. 다음 줄에는 ‘수첩 1’에 적어 놓은 정수의 개수 N(1 ≤ N ≤ 1,000,000)이 입력으로 들어온다.
그 다음 줄에  ‘수첩 1’에 적혀 있는 정수들이 N개 들어온다. 
그 다음 줄에는 ‘수첩 2’에 적어 놓은 정수의 개수 M(1 ≤ M ≤ 1,000,000) 이 주어지고, 
다음 줄에 ‘수첩 2’에 적어 놓은 정수들이 입력으로 M개 들어온다. 모든 정수들의 범위는 int 로 한다.

# 풀이
문제를 푸는 도중 3가지의 방법이 떠올랐고, 모든 방법을 사용해 보았다.

### array의 인덱스 이용
static으로 최대 크기의 boolean배열을 먼저 선언해 놓는다.
이후 수첩 1에 적혀있는 내용에 해당하는 인덱스에 true를 저장한다.
수첩 2에 해당하는 인덱스가 true가 아니면 0출력을 한다.

```java
static void receive() throws IOException {
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		while(st1.hasMoreTokens()) {
			arr1[Integer.parseInt(st1.nextToken())] = true;
		}
	}
	
	static void check() throws IOException {
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		while(st1.hasMoreTokens()) {
			if (arr1[Integer.parseInt(st1.nextToken())]) {
				System.out.println(1);
				continue;
			}
			System.out.println(0);
		}
	}
```
가장 큰 문제가 있었는데 우선 정수가 들어올때 어떤 정수가 들어올 지 모른다. 즉, 정수로 10억, 100억이 들어올때
그에 해당하는 인덱스에 매치가 불가능 하단 것이다. 따라서 이 방법은 실패이다.

---

### binarySearch
수첩1에 해당하는 정수를 받은후 배열에 저장을 한다.
이후 sort를 한다음 binarySearch로 해당 요소가 존재하는지 여부를 파악한다.
이때 가장 마지막 인덱스보다 key가 더 크면 바로 0을 출력시킨다.
```java
static void receive(int[] arr1) throws IOException {
		int j = 0;
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		while(st1.hasMoreTokens()) {
			arr1[j++] = Integer.parseInt(st1.nextToken());
		}
	}
	
	static void check(int[] arr1, int key){
		if (arr1[arr1.length-1] < key) {
			System.out.println(0);
			return;
		}
		
		int pl = 0;
		int pr = arr1.length-1;
		
		while(pl <= pr) {
			int pc = arr1[(pr + pl) / 2];
			if (pc == key) {
				System.out.println(1);
				return;
			}
			
			if (key < pc) {
				pr = pc - 1;
			}
			else if(key > pc) {
				pl = pc + 1;
			}
		}
	}
```
우선 오류가 발생했는데
원인을 찾지 못했다,,,
왜 오류가 났는지 아직 찾고 있는 중이다....
ArrayBounds오류 인데 좀두 탐구가 필요하다,,,

---
### Set

Set를 이용하여 수첩 1에 해당하는 요소를 저장한다.
이때 수첩2 의 요소들이 set에 존재여부에 따라 출력을 다르게 한다.
```java
public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			Set<Integer> set = new HashSet<Integer>();
			StringBuilder sb = new StringBuilder();
			int M = Integer.parseInt(br.readLine());

			receive(set);
			int K = Integer.parseInt(br.readLine());

			StringTokenizer st1 = new StringTokenizer(br.readLine());
			while (st1.hasMoreTokens()) {
				sb.append((set.contains(Integer.parseInt(st1.nextToken())) 
						? 1 : 0) + "\n");
			}
			System.out.println(sb.substring(0, sb.length()-1));

		}

	}

	static void receive(Set<Integer> set) throws IOException {
		int j = 0;
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		while (st1.hasMoreTokens()) {
			set.add(Integer.parseInt(st1.nextToken()));
		}
	}
```
생각한대로 해결이 되었다.
아직 문제에서 요구하는 핵심요소를 추출하는데 어려움이 있는데
좀더 공부하면서 이 능력을 늘려야 겠다.
