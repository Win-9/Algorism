# 문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

# 풀이
얕잡아 봤다고 큰코다친 문제이다.
기본 정렬문제와 같이 풀려고 하다가 계속 시간초과오류가 나서 시간이 많이 걸렸다.
우선 quickSort를 사용하려고 했는데 시간초과 오류가 나서 많이 당황했다.
pivot을 양끝 배열의 중앙에 고정을 시키기 때문에, O(N^2)의 오류가 발생하기 아주 쉽다는 이유이기때문이다.

따라서 heapSort를 이용하여 O(NlogN)을 하려고 했는데 이 역시도 오류가 발생하였다.
먼저 배열을 받고나서 -> 이진트리로 변환 -> heapSort 순서이기 때문에
이진트리로 변환하고 다시 heapSort를 하는 과정에서 벌써 O(N^2logN)이었다.
(모두 시간초과이유를 찾으려고하니 시간이 너무 많이걸렸다 ㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜ)

여기서 할수 있는 선택지는 quickSort에서 pivot을 random으로 설정을 하는것, 두번째는 mergeSort로 구현이 있다.
우선 Pivot을 랜덤으로 선택하도록 하고 실행했더니 마찬가지로 시간초과 오류가 발생하였다.
따라서 O(NlogN)을 보장하는 MergeSort을 구현하여 풀이하였다.
