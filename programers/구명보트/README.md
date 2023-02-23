### 문제

무인도에 갇힌 사람들을 구명보트를 이용하여 구출하려고 합니다. 구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한도 있습니다.   

예를 들어, 사람들의 몸무게가 [70kg, 50kg, 80kg, 50kg]이고 구명보트의 무게 제한이 100kg이라면 2번째 사람과 4번째 사람은 같이 탈 수 있지만    
1번째 사람과 3번째 사람의 무게의 합은 150kg이므로 구명보트의 무게 제한을 초과하여 같이 탈 수 없습니다.   

구명보트를 최대한 적게 사용하여 모든 사람을 구출하려고 합니다.   

사람들의 몸무게를 담은 배열 people과 구명보트의 무게 제한 limit가 매개변수로 주어질 때, 모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값을 return 하도록    
solution 함수를 작성해주세요.   

제한사항   
무인도에 갇힌 사람은 1명 이상 50,000명 이하입니다.   
각 사람의 몸무게는 40kg 이상 240kg 이하입니다.   
구명보트의 무게 제한은 40kg 이상 240kg 이하입니다.   
구명보트의 무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크게 주어지므로 사람들을 구출할 수 없는 경우는 없습니다.   

입출력 예   
|people	|limit|	return|
|-|-|-|
|[70, 50, 80, 50]	|100	|3|
|[70, 80, 50]	|100|	3|


### 풀이

제한사항에 맞추어 보트를 효율적으로 태울 수 있는 방법은 무엇이 있을까?   
바로 몸무게가 큰 사람부터 보트에 태우는 것이다.   

몸무게가 큰 사람부터 보트에 태우고, 그 뒤를 검증하여 같이 태울 수 있는 사람이 있다면 같이 태운다.   
따라서 리스트를 활용하여 리스트의 Max를 찾은다음, 같이 태울 수 있는 사람을 탐색하여 제거하는 방식으로 코드를 구성했다.    
테스트는 모두 성공했지만, 효율성테스트에서 나락...   

리스트는 첫 인덱스부터 차근차근 접근해야 한다.   
따라서 이를 정렬시키면 더 빠른 접근이 가능할 것이라고 생각했다.   
내림차순 정렬을 하여 다음과 같이 구성했다.   

```java
public int solution(int[] people, int limit) {
        int answer = 0;
        List<Integer> list = Arrays.stream(people).boxed().collect(Collectors.toList());
        Collections.sort(list, Comparator.reverseOrder());
        
        while(list.size() != 0) {
            int max = list.remove(0);
            if (list.size() > 0 && max + list.get(list.size() - 1) > limit) {
                answer++;
                continue;
            }
            for(int i = list.size() - 1; i >= 0; i--) {
                if ((max + list.get(i)) <= limit) {
                    list.remove(i);
                    break;
                }
            }
            answer++;
        }
        
        return answer;
    }
```
참고로 Max값을 찾은 후에 리스트의 맨 뒤를 탐색하는 이유는 맨 뒤는 가장 작은 몸무게인데, 가장 작은것과 같이 태울 수 없다면 어짜피 모든 경우를 같이 태울 수 없다.   
따라서 더 탐색할 필요가 없다.   

시간은 이전보다 훨씬 빨라졌으나, 이번에도 효율성테스트에서 나락...   

리스트에서 효율성이 안나오니 배열을 사용하여 투포인터로 접근 하도록 하는것이 인덱스 접근에서 더 빠른 효과를 낼 것 이라고 생각했다.

```java
public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int j = 0;
        
        for(int i = people.length - 1; i >= j; i--) {
            answer++;
            if (people[i] + people[j] > limit) {
                continue;
            }
            j++;
        }
        
        return answer;
    }
```
성공!   

collection이 배열보다 사용하기 더 편리했기 때문에 이것만 사용하자 했던 내 자신 반성...


