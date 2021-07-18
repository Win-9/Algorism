# 문제

크기가 N인 수열 A = A1, A2, ..., AN이 있다. 수열의 각 원소 Ai에 대해서 오큰수 NGE(i)를 구하려고 한다. 
Ai의 오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다. 그러한 수가 없는 경우에 오큰수는 -1이다.

예를 들어, A = [3, 5, 2, 7]인 경우 NGE(1) = 5, NGE(2) = 7, NGE(3) = 7, NGE(4) = -1이다. 
A = [9, 5, 4, 8]인 경우에는 NGE(1) = -1, NGE(2) = 8, NGE(3) = 8, NGE(4) = -1이다.

https://www.acmicpc.net/problem/17298

# 전략

처음드는 생각에는 stack 프레임워크를 사용해서 역순으로 push를 한다음에 자신보다 큰 수가 나오면 StringBuilder에 저장을 하고 다시 역순으로
pop한 숫자들을 push해서 반복하는것이었는데 for문을 최소한 2번은 돌려야하므로 매우 비효율적이다.

따라서 array를 이용하여 stack처럼 사용해서 pop하는 과정없이, top 포인터만 이용해서 왔다갔다 하는 방식으로 구성을 했다.
그리고 idx를 두어서 비교하려는 숫자 인덱스를 가리키고, 비교가 끝나거나 만족하지 못해서 -1을 해야하는 상황에 다음 인덱스로 넘어가도록 하였다.

```java
while(idx!=(N-1)) {
	    	if(top>N-2) {
	    		System.out.println("why?"+str[top]);
	    		System.out.println("========idx:"+idx+"/top:"+top+"===========");
	    		sb.append("-1\n");
	    		++idx;
	    		top=idx;
	    		continue;
	    	}
	    	else if(Integer.parseInt(str[idx])<(Integer.parseInt(str[++top]))) {
	    		sb.append(str[top]+"\n");
	    		System.out.println("++++++++++++idx:"+idx+"/top:"+top+"++++++++++++");
	    		++idx;
	    		top=idx;
	    		continue;
	    	}
	    		    	
	    }
```

이렇게 하면 O(N)으로 처음에 구성했던것것인 O(N^2)보다 효율적이다.

---
시간초과 오류가 난다. 아마 O(logN)까지 줄여야 할듯하다.


거꾸로 비교해서 넣어보기로 하였다.
```java
package por;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.ArrayList;

public class bj {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb=new StringBuilder();
	    int N=Integer.parseInt(br.readLine());
	    String[]str=br.readLine().split(" ");
	    int top=N-2;
	    int middle=Integer.parseInt(str[N-1]);
	    sb.append("-1");
	    while(top!=-1) {
	    	if(middle>Integer.parseInt(str[top--])) {
	    		sb.insert(0, middle+"\n");
	    	}
	    	else {
	    		middle=Integer.parseInt(str[top+1]);
	    		sb.insert(0, -1+"\n");
	    	}
	    }
	    
	    System.out.println(sb);

		
	}
	
}
```

---
위의 방법도 시간초과 오류, 그리고 예외가 발생한다. 도저히 생각이 안나서 도움을 좀 받았다.
결국에는 Stack자체를 이용하는게 방법이었다.
stack에 인덱스를 push한다는 발상으로 풀이하는 방법이다.

1. 첫 인덱스를 stack에 push를 한다.
2. 다음 인덱스와 비교하여 다음인덱스보다 pop()한값이 크다면 그대로 다음 인덱스도 push(), 그렇지 않다면 pop()을 한다음 ans에 비교한 인덱스를 저장한다.
3. 반복
```java
 	for(int i=n-1; i>=0; i--) {
            while(!s.isEmpty() && s.peek() <= a[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = s.peek();
            }
            s.push(a[i]);
        }

```
이 방식이 가능한 이유는

오큰수는 i번째 수의 오른쪽에서 첫 번째로 만난 i번째 수보다 큰 수이기 때문에

스택에서 배열[i]보다 작은 수들을 전부 지워줘도 지워진 수들이 오큰수가 될 확률이 없기 때문이다.

개인적으로 느끼기에는 매우 어려웠다. 아직 경험이 많이 없어서 그런건지... 우선 문제를 더 많이 풀어봐야 겠다....
