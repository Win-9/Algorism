# 문제

회문(回文) 또는 팰린드롬(palindrome)은 앞 뒤 방향으로 볼 때 같은 순서의 문자로 구성된 문자열을 말한다. 예를 들어 ‘abba’ ‘kayak’, ‘reviver’, ‘madam’은 모두 회문이다. 만일 그 자체는 회문이 아니지만 한 문자를 삭제하여 회문으로 만들 수 있는 문자열이라면 우리는 이런 문자열을 “유사회문”(pseudo palindrome)이라고 부른다. 예를 들어 ‘summuus’는 5번째나 혹은 6번째 문자 ‘u’를 제거하여 ‘summus’인 회문이 되므로 유사회문이다.

여러분은 제시된 문자열을 분석하여 그것이 그 자체로 회문인지, 또는 한 문자를 삭제하면 회문이 되는 “유사회문”인지, 아니면 회문이나 유사회문도 아닌 일반 문자열인지를 판단해야 한다. 만일 문자열 그 자체로 회문이면 0, 유사회문이면 1, 그 외는 2를 출력해야 한다. 

https://www.acmicpc.net/problem/17609


# 전략


순서대로 stack에 push를 진행하다가 같은 문자열이 나오면 push를 그만하고 pop()을 하는 단계로 넘어간다.

```java
for(;i<str.length();i++) {
	    	if(stack.size()!=0 && str.charAt(i)==(stack.peek())) {
	    		break;
	    	}
	    	stack.push(str.charAt(i));
	    }
	    
	    for(;i<str.length();i++) {
	    	if(stack.size()!=0 && str.charAt(i)==stack.peek()) {
	    		stack.pop();
	    		continue;
	    	}
	    	list.add(str.charAt(i));
	    }
```

pop()을 할때에는 스택이 empty 상태일때 남은 문자열이 있는것을 방지하기 위해 스택의 사이즈가 0이 아니어야하고, 문자가 일치해야 한다는 조건을 넣어주었다. 또한 이 조건에 부합하지 않으면 list에 add를 하여 stack과 list의 size에 따라서 return의 값을 나누게 하였다. 

abca와같은 문자열에 대한 반례가 생긴다. 상황에따라 str.charAt(i)를 add해야할 상황과 pop()자체를 add해야 할 상황이 생기는데 이 case를 나누기에는 index초과 에러가 나버린다. 케이스를 잘 나누던지 알고리즘을 다시짜는지 다른 방법을 강구해야 할 것 같다.
