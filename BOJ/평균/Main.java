import java.lang.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[] arr = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        double max = Arrays.stream(arr).max().getAsDouble();

        double sum = 0;
        for (double v : arr) {
            sum += v / max * 100;
        }

        System.out.println(sum / arr.length);
    }
}
