### 문제

네 개의 명령어 D, S, L, R 을 이용하는 간단한 계산기가 있다. 이 계산기에는 레지스터가 하나 있는데, 이 레지스터에는 0 이상 10,000 미만의 십진수를 저장할 수 있다. 각 명령어는 이 레지스터에 저장된 n을 다음과 같이 변환한다. 

n의 네 자릿수를 d1, d2, d3, d4라고 하자(즉 n = ((d1 × 10 + d2) × 10 + d3) × 10 + d4라고 하자)

D: D 는 n을 두 배로 바꾼다. 결과 값이 9999 보다 큰 경우에는 10000 으로 나눈 나머지를 취한다. 그 결과 값(2n mod 10000)을 레지스터에 저장한다.

S: S 는 n에서 1 을 뺀 결과 n-1을 레지스터에 저장한다. n이 0 이라면 9999 가 대신 레지스터에 저장된다.


L: L 은 n의 각 자릿수를 왼편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d2, d3, d4, d1이 된다.

R: R 은 n의 각 자릿수를 오른편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d4, d1, d2, d3이 된다.

위에서 언급한 것처럼, L 과 R 명령어는 십진 자릿수를 가정하고 연산을 수행한다. 예를 들어서 n = 1234 라면 여기에 L 을 적용하면 2341 이 되고 R 을 적용하면 4123 이 된다.

여러분이 작성할 프로그램은 주어진 서로 다른 두 정수 A와 B(A ≠ B)에 대하여 A를 B로 바꾸는 최소한의 명령어를 생성하는 프로그램이다. 예를 들어서 A = 1234, B = 3412 라면 

다음과 같이 두 개의 명령어를 적용하면 A를 B로 변환할 수 있다.

1234 →L 2341 →L 3412   
1234 →R 4123 →R 3412   

따라서 여러분의 프로그램은 이 경우에 LL 이나 RR 을 출력해야 한다.   

n의 자릿수로 0 이 포함된 경우에 주의해야 한다. 예를 들어서 1000 에 L 을 적용하면 0001 이 되므로 결과는 1 이 된다. 그러나 R 을 적용하면 0100 이 되므로 결과는 100 이 된다.


### 풀이

모든 경우에서 가장 짧은 경우를 탐색해야 하는 문제이다.   
모든 경우를 탐색하는 부분에서 가장 먼저 마주치는 값이 가장 최단 경로이므로 DFS가 아닌 BFS를 이용해서 풀이하기로 생각하였다.   

처음에는 L R연산을 구현하는데 있어서 문자로 처리하려고 하였다.   
만약 값이 123 이면 L 연산시 1230이 되기 때문에 문자열을 통하여 이를 구현하였다.   
그러나 문제점은 Integer.parseInt를 이용한 방문처리였다.   

방문 처리를 포함하여 다른 정수 연산 필요시 해당 함수를 이용해야 했는데 해당 연산은 문자의 길이만큼 시간이 소요된다.
따라서 O(N)이므로 문자 길이가 늘어날 수록 좋지 않은 성능을 보였다.   

이를 해결할 방법으로 숫자를 통한 연산을 구현하였다.   
L일때와 R일떄의 구현 방식은 다음과 같다.

```
(num % 1000) * 10 + num / 1000
(num % 10) * 1000 + num / 10;
```

또한 방문처리가 중요하다.   
DSLR연산 후의 숫자를 또 똑같이 DSLR연산을 한다면 어짜피 탐색했었던 경우를   
재탐색하는 과정을 거치므로 비효율적이므로 visited를 통한 방문처리를 하면 시간을 단축시킬 수 있다.









