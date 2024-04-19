
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42
43
44
45
46
47
import java.util.*;
import java.lang.*;

class Solution {
    static int MIN = -1;
    static Integer[] sumScores;
    public int solution(int[][] scores) {
        int answer = 1;
        int length = scores.length;
        sumScores = new Integer[length];
        int[] target = scores[0];

        Arrays.sort(scores, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0]) {
                    return 1;
                }
                else if (o1[0] == o2[0]) {
                    if (o1[1] > o2[1]) {
                        return 1;
                    }
                    return -1;
                }
                return -1;
            }
        });

        int max = 0;
        for (int[] score : scores) {

            if (score[1] < max) {
                if (score[0] == target[0] && score[1] == target[1]) {
                    return -1;
                }
                continue;
            }

            max = Math.max(max, score[1]);
            if (target[0] + target[1] < score[0] + score[1]) {
                answer++;
            }
        }
        return answer;
    }
}
