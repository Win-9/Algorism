import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static List<Node> list = new ArrayList<>();
    static long[] distance;
    static long MAX = Long.MAX_VALUE;
    static boolean flag = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        distance = new long[N + 1];
        Arrays.fill(distance, MAX);

        for (int i = 0; i < M; i++) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int cost = Integer.parseInt(str[2]);
            list.add(new Node(a, b, cost));
        }

        bellmanFord();

        if (flag) {
            System.out.println(-1);
            return;
        }

        for (int i = 2; i <= N; i++) {
            if (distance[i] == MAX) {
                System.out.println(-1);
                continue;
            }
            System.out.println(distance[i]);
        }

    }

    static void bellmanFord() {
        distance[1] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Node node = list.get(j);
                if (distance[node.start] == MAX) {
                    continue;
                }

                if (distance[node.end] > distance[node.start] + node.cost) {
                    distance[node.end] = distance[node.start] + node.cost;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Node node = list.get(j);
                if (distance[node.start] == MAX) {
                    continue;
                }

                if (distance[node.end] > distance[node.start] + node.cost) {
                    flag = true;
                    return;
                }
            }
        }
    }

    static class Node {
        int start;
        int end;
        int cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

}
