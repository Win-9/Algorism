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
