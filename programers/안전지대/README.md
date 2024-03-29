### 문제

다음 그림과 같이 지뢰가 있는 지역과 지뢰에 인접한 위, 아래, 좌, 우 대각선 칸을 모두 위험지역으로 분류합니다.   

![image](https://github.com/Win-9/Algorism/assets/80390524/18dcdf50-0c8e-4390-bb4e-39eb09a19ba8)   


지뢰는 2차원 배열 board에 1로 표시되어 있고 board에는 지뢰가 매설 된 지역 1과, 지뢰가 없는 지역 0만 존재합니다.   
지뢰가 매설된 지역의 지도 board가 매개변수로 주어질 때, 안전한 지역의 칸 수를 return하도록 solution 함수를 완성해주세요.   


### 풀이

간단히 생각해서 모든 맵을 탐색해야 한다고 생각하였다.  
따라서 지뢰의 좌표 -> 주변 탐색 방식으로 풀이하였다.   
이때 주의할 점은 인접한 지역에 지뢰가 있을 경우 위험지역이 겹치므로 탐색시 visited처리를 해서 탐색하도록 한다.   
