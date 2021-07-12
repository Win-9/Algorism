# 문제

스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다. 
스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.

1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다.
이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자. 
임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 이를 계산하는 프로그램을 작성하라.

https://www.acmicpc.net/problem/1874


# 전략

문제를 이해하는데 오래걸렸다.

문제를 설명하자면 주어진 수열 4,3,6,8,7,5,2,1가 있다고 가정하자.

스택에 오름차순 순으로 1,2...쌓아가며 -를 출력한다. 그리고 4까지 쌓았다면 pop()을 하게되고, +를 출력한다.
다시 3을 pop()을 하고 6까지 push를 하며 -를 출력, 6을 pop()하고 +를 출력하며 위의 주어진 수열이 만들어 질수 있는지 없는지 판별 하는 것이다.

문제의 흐름을 보면 알겠지만 당연히 스택을 사용하게 된다면 어렵지 않게 문제에 접근 할 수 있다.

```java
        if(!stack.empty() && stack.peek()==count) {
	    		stack.pop();
	    		sb.append("-\n");
	    	}
	    	else if(!stack.empty() && stack.peek()>count) {
	    		sb=new StringBuilder("NO");
	    		check=true;
	    	}
	    	else {
	    		for(;sp<=count;sp++) {
		    		stack.push(sp);
		    		sb.append("+\n");
		    	}
	    		stack.pop();
	    		sb.append("-\n");
	    	}
        
```
if 를 이용해 각 조건마다 StringBuilder에 어떤 문자열을 저장 할 것인지 정하고, 아예 불가능할 수열이라고 판단하면 check에 true를 주게됨으로서 
for을 돌때마다 continue를 하게되어 NO를 출력하게 하였다.

---
+ 굳이 Stack자체를 이용하기보다는 array에 index만 있어도 가능하다.
