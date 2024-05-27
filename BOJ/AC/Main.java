import java.lang.*;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    static boolean isReverse;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String commands = br.readLine();
            int N = Integer.parseInt(br.readLine());
            boolean flag = false;
            isReverse = false;

            String numbers = br.readLine();
            if (N == 0 && commands.contains("D")) {
                System.out.println("error");
                continue;
            }
            ArrayDeque<Integer> deque;
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
                    if (deque.size() == 0) {
                        flag = true;
                        break;
                    }
                    if (isReverse) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                }
            }
            print(deque, flag);
        }

    }

    static void print(ArrayDeque<Integer> deque, boolean flag) {
        if (flag) {
            System.out.println("error");
            return;
        }

        if (deque.size() == 0) {
            System.out.println("[]");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (isReverse) {
            while (!deque.isEmpty()) {
                sb.append(deque.pollLast() + ",");
            }
        } else {
            while (!deque.isEmpty()) {
                sb.append(deque.pollFirst() + ",");
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        System.out.println(sb);
    }
}

