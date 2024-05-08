import java.lang.*;
import java.io.*;
import java.util.*;


class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> group = new ArrayList<>();
        List<Integer> unit = new ArrayList<>();
        String[] str = br.readLine().split(" ");
        int answer = 0;
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        for (int i = 0; i < M; i++) {
            str = br.readLine().split(" ");
            group.add(Integer.parseInt(str[0]));
            unit.add(Integer.parseInt(str[1]));
        }

        int groupMin = Collections.min(group);
        int unitMin = Collections.min(unit);

        if (groupMin < unitMin * 6) {
            int sum = N / 6;
            answer += groupMin * sum;
            N -= sum * 6;
        } else {
            int sum = N / 6;
            answer += unitMin * 6 * sum;
            N -= sum * 6;
        }

        if (unitMin * N < groupMin) {
            answer += unitMin * N;
        } else {
            answer += groupMin;
        }

        System.out.println(answer);

    }
}
