### 문제

길이가 같은 배열 A, B 두개가 있습니다. 각 배열은 자연수로 이루어져 있습니다.   
배열 A, B에서 각각 한 개의 숫자를 뽑아 두 수를 곱합니다. 이러한 과정을 배열의 길이만큼 반복하며, 두 수를 곱한 값을 누적하여 더합니다.    

이때 최종적으로 누적된 값이 최소가 되도록 만드는 것이 목표입니다. (단, 각 배열에서 k번째 숫자를 뽑았다면 다음에 k번째 숫자는 다시 뽑을 수 없습니다.)   

예를 들어 A = [1, 4, 2] , B = [5, 4, 4] 라면   

A에서 첫번째 숫자인 1, B에서 첫번째 숫자인 5를 뽑아 곱하여 더합니다. (누적된 값 : 0 + 5(1x5) = 5)   
A에서 두번째 숫자인 4, B에서 세번째 숫자인 4를 뽑아 곱하여 더합니다. (누적된 값 : 5 + 16(4x4) = 21)   
A에서 세번째 숫자인 2, B에서 두번째 숫자인 4를 뽑아 곱하여 더합니다. (누적된 값 : 21 + 8(2x4) = 29)   
즉, 이 경우가 최소가 되므로 29를 return 합니다.   
 
배열 A, B가 주어질 때 최종적으로 누적된 최솟값을 return 하는 solution 함수를 완성해 주세요.   


### 풀이

가장 작은 수를 만드는 방법은 뭐가 있을까??   
A의 가장 작은수와 B의 가장 큰수를 곱해서 만들면 자연스럽게 가장 작은 수가 만들어 진다.   
따라서 A는 오름차순정렬, B는 내림차순 정렬을 시도하면 되겠다.   

처음짠 코드는 이러하다.   
```java
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Integer[] bArray = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(A);
        Arrays.sort(bArray,Collections.reverseOrder());
        for(int i = 0; i < A.length; i++) {
            answer += A[i] * bArray[i]; 
        }

        return answer;
    }
}
```
정답은 맞추었지만 효율성테스트에서 나가리가 되었다.   
> 참고로 Collections.reverseOrder()를 사용하려면 sort에서 int배열이 아닌 Integer가 되어야 한다.
> 따라서 boxed로 이를 감싸주어야 한다.

Arrays.sort는 두개의 피벗을 사용한 퀵sort이기 때문에 O(nlogn)의 시간이 걸린다.   
반면 우선순위 큐를 사용해서 구현하면 O(logn)의 시간이 걸리기 때문에 우선순위 큐를 이용한 풀이를 진행했다.


