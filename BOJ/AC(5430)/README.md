# 문제

선영이는 주말에 할 일이 없어서 새로운 언어 AC를 만들었다. AC는 정수 배열에 연산을 하기 위해 만든 언어이다. 이 언어에는 두 가지 함수 R(뒤집기)과 D(버리기)가 있다.

함수 R은 배열에 있는 숫자의 순서를 뒤집는 함수이고, D는 첫 번째 숫자를 버리는 함수이다. 배열이 비어있는데 D를 사용한 경우에는 에러가 발생한다.

함수는 조합해서 한 번에 사용할 수 있다. 예를 들어, "AB"는 A를 수행한 다음에 바로 이어서 B를 수행하는 함수이다. 예를 들어, "RDD"는 배열을 뒤집은 다음 처음 두 숫자를 버리는 함수이다.

배열의 초기값과 수행할 함수가 주어졌을 때, 최종 결과를 구하는 프로그램을 작성하시오.


# 전략

우선, StringBuilder를 이용하여 실행할 함수를 StringBuilder로 받게한다.
그리고 받을 문자열을 또다른 StringBuilder로 저장해 놓고, StringTokenizer로 []를제거해주고, " "를 ,로 변환시켜준다.
그렇게 하면 순수한 숫자가 남게되는데 이를 이용하여 각 함수를 실행해준다.

R을 단순 reverse를 수행하는 것이라서 sb.reverse()를 수행해주고,
D는 단순히 앞문자를 제거해주고, 빈문자열일때는 error를 출력하게 하였다.



```java
switch(str.charAt(i)) {
			case 'R':
				reverse=(!reverse);
				break;
			case 'D':
				if(queue.size()==0) {
					check=false;
					break Loop1;
				}
				
				if(reverse==true) {
					queue.removeLast();
				}
				else {
					queue.removeFirst();
				}
				break;
			}
 ```


---

계속 예외가 생겨서 오래걸렸다.
또한 R이 하나로 끝나게되면 계속 해서 역으로 출력을 해야하므로 reverse를 부어서 false를 두어서 R의 마지막을
구별할 수 있게한다.


```java
if(reverse==true) {
				result.append("[");
				while(queue.size()>=1) {
					if(queue.size()==1) {
						result.append(queue.removeLast());
						break;
					}
					result.append(queue.removeLast()+",");
				}
				result.append("]\n");
			}
			else {
				result.append("[");
				while(queue.size()>=1) {
					if(queue.size()==1) {
						result.append(queue.removeFirst());
						break;
					}
					result.append(queue.removeFirst()+",");
				}
				result.append("]\n");
			}
```


또한 이 func1에 들어오기전에 N이 0이고, 처음 이 D함수일때는 error를 출력해야하므로
따로 result에 append해주고 바로 continue해준다.

```java
if(N==0 && str.charAt(0)=='D') {
		    	result.append("error\n");
		    	continue;
		    }
```














