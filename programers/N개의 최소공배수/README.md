### 문제

두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다.   

예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다.    

n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.   


### 풀이

여러 숫자들의 최소 공배수를 구하여야 한다.   
초등학교 때였나... 최소 공배수 구하는 방법중에서 숫자를 곱한 후, 곱한 것의 약수들을 구하면 된다고 배웠던것 같았다.   
따라서 그대로 실행했더니 결과가 좋게 나왔다.   

그런데 생각해보니 제일 큰 수에서 1 부터 쭉 곱해나서 약수인지만 구하면 되지 않겠는가?   
역시 이 방법도 가능하였다.
