import java.lang.*;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    static int index = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String commands = br.readLine();
            int N = Integer.parseInt(br.readLine());

            boolean flag = false;
            String numbers = br.readLine();
            if (N == 0 && commands.contains("D")) {
                System.out.println("error");
                continue;
            }
            ArrayDeque<Integer> deque;
            boolean isReverse = false;
            if (N != 0) {
                deque = Arrays.stream(numbers.replace("[", "").replace("]", "").split(","))
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .collect(Collectors.toCollection(ArrayDeque::new));
            } else {
                deque = new ArrayDeque<>();
            }

            for (String command : commands.split("")) {
                if (command.equals("R")) {
                    isReverse = !isReverse;
                    continue;
                }

                if (command.equals("D")) {
                    if ()
                    if (list.size() == 0) {
                        flag = true;
                        break;
                    }

                    if (index != 0) {
                        index = size;
                    }
                }
            }
            print(list, flag);
        }

    }

    static void print(List<Integer> list, boolean flag) {
        if (flag) {
            System.out.println("error");
            return;
        }

        if (list.size() == 0) {
            System.out.println("[]");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (index == 0) {
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i) + ",");
            }
        } else {
            for (int i = list.size() - 1; i >= 0; i--) {
                sb.append(list.get(i) + ",");
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        System.out.println(sb);
    }
}
