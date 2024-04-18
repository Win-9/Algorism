import java.lang.*;
import java.io.*;
import java.util.*;


class Main {
    static boolean[] visited;
    static int MAX_INT = 100000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int E = Integer.parseInt(str[1]);
        List<Node>[] list = new List[N + 1];
        int[] startDistance = new int[N + 1];
        int[] v1Distance = new int[N + 1];
        int[] v2Distance = new int[N + 1];
        visited = new boolean[N + 1];

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            startDistance[i] = MAX_INT;
            v1Distance[i] = MAX_INT;
            v2Distance[i] = MAX_INT;
        }

        for (int i = 0; i < E; i++) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int cost = Integer.parseInt(str[2]);
            list[a].add(new Node(cost, b));
            list[b].add(new Node(cost, a));
        }

        str = br.readLine().split(" ");
        int v1 = Integer.parseInt(str[0]);
        int v2 = Integer.parseInt(str[1]);

        // start Distance
        dijkstra(1, list, startDistance);

        // v1 Distance
        Arrays.fill(visited, false);
        dijkstra(v1, list, v1Distance);
        int v1EndIndex = findMinIndex(v1Distance, v1);

        // v2 Distance
        Arrays.fill(visited, false);
        dijkstra(v2, list, v2Distance);
        int v2EndIndex = findMinIndex(v2Distance, v2);

        int firstResult = startDistance[v1] + v1Distance[v2] + v2Distance[v2EndIndex];
        int secondResult = startDistance[v2] + v1Distance[v2] + v1Distance[v1EndIndex];

        if (firstResult > secondResult) {
            answer = secondResult;
        } else {
            answer = firstResult;
        }

        if (answer >= MAX_INT) {
            System.out.println(-1);
            return;
        }
        System.out.println(firstResult);
    }

    static int findMinIndex(int[] distance, int self) {
        int min = 1000000;
        int minIndex = 0;

        for (int i = 1; i < distance.length; i++) {
            if (distance[i] < min && i != self) {
                min = distance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    static void dijkstra(int startNode, List<Node>[] list, int[] distance) {
        PriorityQueue<Node> queue = new PriorityQueue<>(((o1, o2) -> o1.cost - o2.cost));
        queue.add(new Node(0, startNode));
        distance[startNode] = 0;

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (visited[currentNode.index]) {
                continue;
            }

            visited[currentNode.index] = true;
            for (Node node : list[currentNode.index]) {
                if (distance[node.index] > node.cost + distance[currentNode.index]) {
                    distance[node.index] = node.cost + distance[currentNode.index];
                    queue.add(new Node(distance[node.index], node.index));
                }
            }
        }
    }

    static class Node {
        int cost;
        int index;

        public Node(int cost, int index) {
            this.cost = cost;
            this.index = index;
        }
    }
}
