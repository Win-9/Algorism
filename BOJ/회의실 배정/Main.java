import java.lang.*;
import java.util.*;
import java.io.*;

public class Main {
    static int K;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Info> list = new ArrayList<>();
        List<Info> rooms = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            list.add(new Info(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
        }

        Collections.sort(list, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if (o1.start == o2.start) {
                    return o1.end - o2.end;
                }
                return o1.start - o2.start;
            }
        });

        rooms.add(list.get(0));
        for (int i = 1; i < N; i++) {
            Info info = list.get(i);
            int size = rooms.size();
            Info prev = rooms.get(size - 1);

            if (prev.end <= info.start) {
                rooms.add(info);
            } else if (prev.end > info.end) {
                rooms.remove(size - 1);
                rooms.add(info);
            }
        }

        System.out.println(rooms.size());
    }

    static class Info {
        int start;
        int end;

        public Info(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
