# 문제
방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오. 단, 모든 간선의 가중치는 10 이하의 자연수이다.

입력
첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다. 
(1 ≤ V ≤ 20,000, 1 ≤ E ≤ 300,000) 모든 정점에는 1부터 V까지 번호가 매겨져 있다고 가정한다. 
둘째 줄에는 시작 정점의 번호 K(1 ≤ K ≤ V)가 주어진다. 셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다.
이는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다. u와 v는 서로 다르며 w는 10 이하의 자연수이다. 서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음에 유의한다.

출력
첫째 줄부터 V개의 줄에 걸쳐, i번째 줄에 i번 정점으로의 최단 경로의 경로값을 출력한다. 시작점 자신은 0으로 출력하고, 경로가 존재하지 않는 경우에는 INF를 출력하면 된다.


# 풀이
전형적인 다익스트라문제.   
다익스트라를 이해하려고 시간이 많이 걸렸다.   
먼저 행렬을 이용하여 풀이를 하려고 했는데, 행렬로 하니 메모리 초과오류가 나버려서 list를 이용하여 priorityQueue를 사용하도록 하였다.   
```java
for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list[v1].add(new Element(v2, cost));
		}
```
또한, 그래프의 간선이 양방향이 아닌 단방향이다. 따라서 이를 대입할때 주의해야 한다.   


```java
PriorityQueue<Element>queue = new PriorityQueue<>();
		dist[start] = 0;
		queue.add(new Element(start, dist[start]));
		boolean[] visited = new boolean[V + 1];
		while(!queue.isEmpty()) {
			Element elem = queue.poll();
			int node = elem.node;
			
			if (visited[node]) {
				continue;
			}
			
			visited[node] = true;
			
			for(Element em : list[node]) {
				if (dist[em.node] > dist[node] + em.weight) {
					dist[em.node] = dist[node] + em.weight;
					queue.add(new Element(em.node, dist[em.node]));
				}
			}
			
			
		}
 ```
 현재의 가중치와, 다른 vertext로 갈때의 가중치를 비교하여, distance의 값이 갱신이 되면 그대 queue를 에 값을 대입해준다.
