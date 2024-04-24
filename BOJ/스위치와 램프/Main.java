import java.lang.*;
import java.io.*;
import java.util.*;


class Main {
    static int N;
    static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        int[] ramp = new int[M + 1];
        Switch[] switches = new Switch[N + 1];

        for (int i = 1; i <= N; i++) {
            str = br.readLine().split(" ");
            switches[i] = new Switch();
            int number = Integer.parseInt(str[0]);
            for (int j = 1; j <= number; j++) {
                ramp[Integer.parseInt(str[j])]++;
                switches[i].add(Integer.parseInt(str[j]));
            }
        }

        for (int i = 1; i <= N; i++) {
            List<Integer> rampList = switches[i].getRampList();
            for (Integer integer : rampList) {
                ramp[integer]--;
            }

            if (check(ramp)) {
                System.out.println(1);
                return;
            }

            for (Integer integer : rampList) {
                ramp[integer]++;
            }
        }

        System.out.println(0);
    }

    static boolean check(int[] ramp) {
        for (int i = 1; i <= M; i++) {
            if (ramp[i] <= 0) {
                return false;
            }
        }
        return true;
    }
    static class Switch {
        List<Integer> rampList = new ArrayList<>();

        public void add(int ramp) {
            rampList.add(ramp);
        }

        public List<Integer> getRampList() {
            return rampList;
        }
    }

}
