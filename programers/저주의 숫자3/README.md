### 문제

3x 마을 사람들은 3을 저주의 숫자라고 생각하기 때문에 3의 배수와 숫자 3을 사용하지 않습니다. 3x 마을 사람들의 숫자는 다음과 같습니다.   

|10진법	|3x 마을에서 쓰는 숫자	|10진법	|3x 마을에서 쓰는 숫자
|-|-|-|-|
|1	|1	|6	|8|
|2	|2	|7	|10|
|3	|4	|8	|11|
|4	|5	|9	|14|
|5	|7	|10	|16|
정수 n이 매개변수로 주어질 때, n을 3x 마을에서 사용하는 숫자로 바꿔 return하도록 solution 함수를 완성해주세요.   


### 풀이


이전 숫자에서 + 1을 하여 현재 숫자를 더한다.   
이때 두가지 경우를 체크해야 한다.   

이전 숫자 + 1 숫자를 num이라고 하자.   
num이 3의 배수가 아닌지와 num이 3을 포함하는지 이 두가지를 체크한다.   
만일 이 경우에 들어간다면 이전숫자 + 1이 아닌 저 경우가 아닐때까지 1을 더하여 num을 구하도록 한다.    

꽤나 복잡한 함수를 만들었는데 간단히 `contians`를 사용하면 되었는데....
왜 풀때 생각이 안났을까 ㅜ
