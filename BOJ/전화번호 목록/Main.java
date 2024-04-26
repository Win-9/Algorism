import java.lang.*;
import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            List<String> list = new ArrayList<>();
            Set<String> set = new HashSet<>();
            for (int j = 0; j < N; j++) {
                String str = br.readLine();
                list.add(str);
                set.add(str);
            }

            if (check(list, set)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

    static boolean check(List<String> list, Set<String> set) {
        for (String str : list) {
            for (int i = 1; i < str.length(); i++) {
                if (set.contains(str.substring(0, i))) {
                    return false;
                }
            }
        }
        return true;
    }

}
