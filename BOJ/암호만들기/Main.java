import java.lang.*;
import java.io.*;
import java.util.*;


class Main {
    static int L;
    static int C;
    static String[] hints;
    static boolean[] visited;
    static List<String> vowel = Arrays.asList("a", "e", "i", "o", "u");
    static List<String> answer = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        L = Integer.parseInt(str[0]);
        C = Integer.parseInt(str[1]);
        hints = new String[C];
        visited = new boolean[C];
        String[] guessCode = new String[L];

        str = br.readLine().split(" ");
        for(int i = 0; i < C; i++) {
            hints[i] = str[i];
        }
        Arrays.sort(hints);
        combine(guessCode, 0, 0);

        StringBuilder sb = new StringBuilder();
        for(String s : answer) {
            sb.append(s + "\n");
        }

        System.out.println(sb);
    }

    static void combine(String[] guessCode, int depth, int start) {
        if (depth == L) {
            if (check(guessCode)) {
                answer.add(String.join("", guessCode));
            }
            return;
        }

        for(int i = start; i < C; i++) {
            if (!visited[i]) {
                guessCode[depth] = hints[i];
                visited[i] = true;
                combine(guessCode, depth + 1, i);
                visited[i] = false;
            }
        }
    }

    static boolean check(String[] guessCode) {
        List<String> list1 = new ArrayList<>(vowel);
        List<String> list2 = new ArrayList<>(Arrays.asList(guessCode));

        list1.retainAll(list2);
        return (list1.size() >= 1) && (L - 2 >=  list1.size());
    }
}
