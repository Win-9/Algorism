### 문제
1부터 N까지의 수를 이어서 쓰면 다음과 같이 새로운 하나의 수를 얻을 수 있다.

1234567891011121314151617181920212223...

이렇게 만들어진 새로운 수는 몇 자리 수일까? 이 수의 자릿수를 구하는 프로그램을 작성하시오.

입력   
첫째 줄에 N(1 ≤ N ≤ 100,000,000)이 주어진다.

출력   
첫째 줄에 새로운 수의 자릿수를 출력한다.

---
### 풀이
처음에 생각했던것은 문자열을 모두 붙혀서 마지막에 그 길이만을 구하려고 했다.

```java
public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= Integer.parseInt(str); i++) {
			sb.append(i + "");
		}
		
		System.out.println(sb.length());
    }
```
그런데 메모리 초과 오류가 나기 때문에 이 방법말고 다른 방법을 구해야 했다.  

구하려고 하는 것은 숫자가 아니라 자릿수 이다.   
따라서 다른 것을 쓸필요 없이 자릿수를 계산해서 더하도록 하면 된다.

```java
public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		int count = 0;
		int len = 1;
		int tmp = 10;
		for(int i = 1; i <= number; i++) {
			if (i == tmp) {
				tmp *= 10;
				len++;
			}
			count += len;
		}
		
		System.out.println(count);
}
```


