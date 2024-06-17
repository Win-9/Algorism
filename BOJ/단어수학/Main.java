import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] alphabet = new Integer[26];
        Arrays.fill(alphabet, 0);
        for (int i = 0; i < N; i++) {
            int pos = 1;
            char[] charArray = br.readLine().toCharArray();
            for (int j = charArray.length - 1; j >= 0; j--) {
                alphabet[charArray[j] - 'A'] += pos;
                pos *= 10;
            }
        }
        int max = 9;
        int answer = 0;
        Arrays.sort(alphabet, Collections.reverseOrder());
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == 0) {
                break;
            }
            answer += alphabet[i] * max--;
        }
        System.out.println(answer);
    }
}
