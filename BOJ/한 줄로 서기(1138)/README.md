### 문제
N명의 사람들은 매일 아침 한 줄로 선다.   
이 사람들은 자리를 마음대로 서지 못하고 오민식의 지시대로 선다.   

어느 날 사람들은 오민식이 사람들이 줄 서는 위치를 기록해 놓는다는 것을 알았다.    
그리고 아침에 자기가 기록해 놓은 것과 사람들이 줄을 선 위치가 맞는지 확인한다.   

사람들은 자기보다 큰 사람이 왼쪽에 몇 명 있었는지만을 기억한다.   
N명의 사람이 있고, 사람들의 키는 1부터 N까지 모두 다르다.

각 사람들이 기억하는 정보가 주어질 때, 줄을 어떻게 서야 하는지 출력하는 프로그램을 작성하시오.

입력   
첫째 줄에 사람의 수 N이 주어진다. N은 10보다 작거나 같은 자연수이다.    
둘째 줄에는 키가 1인 사람부터 차례대로 자기보다 키가 큰 사람이 왼쪽에 몇 명이 있었는지 주어진다.   
i번째 수는 0보다 크거나 같고, N-i보다 작거나 같다. i는 0부터 시작한다.

출력   
첫째 줄에 줄을 선 순서대로 키를 출력한다.

---
### 풀이

솔직히 조금 어려웠다.   
문제 이해 부터 하자면 **입력의 숫자는 키 순서대로 이다.**
가령, 2 1 1 0 라고 한다면 키가 1인사람의 왼쪽에 있는 키큰 사람은 2명이고 키가 2인사람의 왼쪽에 있는 키큰 사람은 1명이고...   
이런 식이다.

처음에 구성한 코드이다.
```java
public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[]result = new int[N + 1];
		
		int i = 1;
		while(st.hasMoreElements()) {
			int height = Integer.parseInt(st.nextToken());
			
			for(int j = height; j <= N; j++) {
				if (j + 1 <= N && result[j + 1] == 0) {
					result[j + 1] = i;
					break;
				}
			}
			i++;
		}
		
		for(int j = 1; j <= N; j++) {
			System.out.print(result[j] + " ");
		}
	}
```
자신이 기록하는 키 큰사람보다는 오른쪽에 있어야 하므로    
그 숫자보다는 더 오른쪽에 위치하도록 구성한 코드이다.   

하지만 이는 큰 오류가 있다.   
**키가 가장 큰 사람이 오른쪽으로 가야 하는 경우도 있는데 이 경우를 보장하지 못한다는 것이다.**

큰 사람들을 먼저 위치시키면서   
자신이 기억하는 왼쪽의 키큰사람이 있는 위치로 자신을 위치 시키고,   
이후 똑같이 기억하는 사람이 있을 경우 이전의 사람은 오른쪽으로 밀려나도록 구성을 한다.   
후에 들어오는 사람은 자신 보다 키가 작은 사람 이므로 조건들을 만족 시킬 수 있다.

**키가 가장 큰 사람이 오른쪽으로 가야 하는 경우도 있는데 이 경우를 보장할 수 있다.*


