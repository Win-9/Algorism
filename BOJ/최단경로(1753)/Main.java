package por;

import java.io.*;
import java.util.*;

public class Main {
	static int V;
	static int E;
	static final int INF = 100000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		int[][]ad = new int[V + 1][V + 1];
		int[]distance = new int[V + 1];
		
		Arrays.fill(distance, INF);
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			ad[v1][v2] = cost;
		}
		
		dijkstra(start, ad, distance);
		
		for(int i = 1; i <= V; i++) {
			if (distance[i] == INF) {
				sb.append("INF\n");
				continue;
			}
			sb.append(distance[i]+"\n");
			
		}
		System.out.println(sb);

	}
	
	static void dijkstra(int start,int[][]ad, int[]dist ) {
		PriorityQueue<Element>queue = new PriorityQueue<>();
		dist[start] = 0;
		queue.add(new Element(start, dist[start]));
		
		while(!queue.isEmpty()) {
			Element elem = queue.poll();
			int cost = elem.distance;
			int here = elem.index;
			
			if (cost > dist[here]) {
				continue;
			}
			
			for(int i = 1; i <= V; i++) {
				if (ad[here][i] != 0 && dist[i] > (dist[here] + ad[here][i])) {
					dist[i] = dist[here]+ad[here][i];
					queue.add(new Element(i, dist[i]));
				}
			}
		}
	}

}

class Element implements Comparable<Element> {
    int index;
    int distance;
 
    public Element(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }
 
    @Override
    public int compareTo(Element o) {
        return this.distance - o.distance;
    }
}
