### 문제

JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다. 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. (첫 번째 입출력 예 참고)   
문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.   

#### 제한 조건   
s는 길이 1 이상 200 이하인 문자열입니다.   
s는 알파벳과 숫자, 공백문자(" ")로 이루어져 있습니다.   
숫자는 단어의 첫 문자로만 나옵니다.   
숫자로만 이루어진 단어는 없습니다.   
공백문자가 연속해서 나올 수 있습니다.   



### 풀이

주어진 문자열을 모두 소문자로 변경하고 빈칸을 기준으로 나눈뒤에 맨 첫글자를 대문자로 변경하면 된다.   

처음에는 split을 이용해서 빈칸을 나누었다.   
그러나 주어진 문자는 빈칸이 여러개 나올 수 있다.   
따라서 split을 이용하면 빈칸이 여러개 나오는 경우를 구분하기 어렵기 때문에 tokenizer를 이용하였다.
tokenizer 옵션중 true 옵션을 줄 수 있는데, 이는 나누는 문자열을 token으로 추출할 수 있다.   
`Hello World`라는 문자열이 있으면 `Hello`, ` `, `World`로 나눌 수 있는 것이다.   
따라서 중첩된빈칸 구분이 가능해진다.   
문자열을 다루는 메소드들을 다시 복습할 수 있었다.
