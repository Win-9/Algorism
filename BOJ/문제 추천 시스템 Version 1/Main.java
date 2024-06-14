import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Ploblem> set = new TreeSet<>((o1, o2) -> {
            if (o1.level == o2.level) {
                return o2.number - o1.number;
            }
            return o2.level - o1.level;
        });

        Map<Integer, Ploblem> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            set.add(new Ploblem(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
            map.put(Integer.parseInt(str[0]), new Ploblem(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
        }

        int P = Integer.parseInt(br.readLine());
        for (int i = 0; i < P; i++) {
            String[] str = br.readLine().split(" ");
            String command = str[0];
            switch(command) {
                case "add":
                    set.add(new Ploblem(Integer.parseInt(str[1]), Integer.parseInt(str[2])));
                    map.put(Integer.parseInt(str[1]), new Ploblem(Integer.parseInt(str[1]), Integer.parseInt(str[2])));
                    break;
                case "solved":
                    int number = Integer.parseInt(str[1]);
                    Ploblem ploblem = map.get(number);
                    set.remove(ploblem);
                    break;
                case "recommend":
                    if (str[1].equals("1")) {
                        System.out.println(set.first().number);
                    } else {
                        System.out.println(set.last().number);
                    }
                    break;
            }
        }
    }

    static class Ploblem {
        int number;
        int level;

        public Ploblem(int number, int level) {
            this.number = number;
            this.level = level;
        }
    }
}
