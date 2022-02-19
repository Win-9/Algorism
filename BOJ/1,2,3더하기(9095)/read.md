# 문제
정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
   
1+1+1+1   
1+1+2   
1+2+1   
2+1+1   
2+2   
1+3   
3+1   
정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 11보다 작다.

출력
각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 출력한다.

# 풀이
규칙을 찾느라 애먹었다.   
N을 5이상까지 쭉 써놓고나서, 유심히 관찰하고나서 얻은 결과인데, 구하려는 A(N)은 A(N-1)+A(N-2)+A(N-3)이다.   
이 규칙을 찾고나서는 그대로 구현을 하였다.
```java
if (num == 1) {
			System.out.println(1);
			return;
		}
		
		if (num == 2) {
			System.out.println(2);
			return;
		}
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;

		for(int i = 4; i <= num; i++) {
			arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
		}
		
		System.out.println(arr[num]);
```
num이 1, 2일때 indexBound오류가 나니까 범위를 조심하여야 한다.   
배열이 계속 초기화되므로, 다시 처음부터 계산을 하는 불필요함이 있어서 시간이 오래걸리는것 같다고 생각을 해서, 배열이 아닌 list로 개선을 하려고 했다.
```java
static void func(int num) {
		// TODO Auto-generated method stub
		
		if (list.size() >= num) {
			System.out.println(list.get(num - 1));
			return;
		}

		for (int i = list.size(); i <= num; i++) {
			list.add(list.get(i - 1) + list.get(i - 2) + list.get(i - 3));
		}

		System.out.println(list.get(num - 1));
	}
 ```
 개선을 했는데,,, 오히려 시간은 더 오래걸렸다.   
 아마도 생각보다 범위가 적었고, array접근이 더빠르기때문인듯,,,   
 N의범위가 20이상으로 갔으면 성능이 더 좋았을것이라고 생각한다.
