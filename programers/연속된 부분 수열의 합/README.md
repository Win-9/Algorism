### 문제

비내림차순으로 정렬된 수열이 주어질 때, 다음 조건을 만족하는 부분 수열을 찾으려고 합니다.

기존 수열에서 임의의 두 인덱스의 원소와 그 사이의 원소를 모두 포함하는 부분 수열이어야 합니다.

부분 수열의 합은 k입니다.

합이 k인 부분 수열이 여러 개인 경우 길이가 짧은 수열을 찾습니다.

길이가 짧은 수열이 여러 개인 경우 앞쪽(시작 인덱스가 작은)에 나오는 수열을 찾습니다.

수열을 나타내는 정수 배열 sequence와 부분 수열의 합을 나타내는 정수 k가 매개변수로 주어질 때, 위 조건을 만족하는 부분 수열의 시작 인덱스와 마지막 인덱스를 배열에 담아 return 하는 solution 함수를 완성해주세요. 

이때 수열의 인덱스는 0부터 시작합니다.

### 풀이

완전탐색을 해야 한다고 생각했다.   
따라서 처음에는 단순에 반복 두번을 돌려서 체크를 했지만,   
테스트가 8000ms가 넘어가는 경우도 있었고, 결국 시간초과가 발생하였다.   
따라서 반복을 돌리는 부분 시간을 단축시킬 방법을 생각하였다.   

수가 오름차순으로 되어 있었기 때문에 역순으로 탐색을 진행하고,   
sum과 length 길이를 비교하여 탐색을 진항하지 않고 break를 걸어버리는 방법을 사용했다.   
조금 개선은 되었지만 시간초과를 모두 해결하지는 못했다.
```java
for(int i = size; i >= 0; i--) {
            int sum = 0;
            for(int j = i; j >= 0; j--) {
                sum += sequence[j];
                int indexLength = i - j + 1;
                if (sum > k || length < indexLength) {
                    break;
                }
                
                if (sum == k) {
                    if (length > indexLength) {
                        startIndex = j;
                        lastIndex = i;
                        length = indexLength;
                    } else if(length == indexLength && startIndex > j) {
                        startIndex = j;
                        lastIndex = i;
                        length = indexLength;
                    }
                }
                
            }

        }
```

다른 방법으로 투포인터를 이용하였다.   
`12345`가 주어져 있다면 left: 0, right: 1이라고 하자.   
두 사이의 합을 구하면서 K의 값을 넘지 못한다면 right의 범위를 늘리면 되고, K의 값이 넘었다면 left를 줄여서 탐색을 진행한다.   
sum이 K와 같다면 조건을 만족하도록 답을 구한다.   
이러한 방식으로 한번의 반복만으로 문제를 해결할 수 있었다.


