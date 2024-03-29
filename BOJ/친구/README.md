### 문제

지민이는 세계에서 가장 유명한 사람이 누구인지 궁금해졌다. 가장 유명한 사람을 구하는 방법은 각 사람의 2-친구를 구하면 된다.    

어떤 사람 A가 또다른 사람 B의 2-친구가 되기 위해선, 두 사람이 친구이거나, A와 친구이고, B와 친구인 C가 존재해야 된다.    

여기서 가장 유명한 사람은 2-친구의 수가 가장 많은 사람이다. 가장 유명한 사람의 2-친구의 수를 출력하는 프로그램을 작성하시오.

A와 B가 친구면, B와 A도 친구이고, A와 A는 친구가 아니다.


### 풀이

2-친구를 구하기 위해서 각 정보가 행렬로 주어져있다.   
나름대로 탐색을 해보려 했다가 잘 안되어서 플로이드 워셜을 사용하라는 팁을 보았다.   
그러나 해당 알고리즘을 잘 몰라 여러 레퍼런스를 참고하여 공부할 수 있었다.   

[플로이드 워셜](https://velog.io/@suk13574/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98Java-%ED%94%8C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%99%80%EC%83%ACFloyd-Warshall-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98)   

행렬로 각 노드별로의 Value를 구해준다.   
이때 2-친구의 조건으로 거리가 2 이하이면 해당 조건을 만족하므로 갯수를 세주어 최댓값을 구한다.   

플로이드 워셜을 알아갈 수 있는 재미있는 문제였다.   
