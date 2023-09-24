import java.util.*;
import java.lang.*;
import java.io.*;

public class Main{
    static int N;
    static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(rd.readLine());
        int[] arr = new int[N];
        play(arr, 0);
        System.out.println(count);
    }
    
    static void play(int[] arr, int depth) {    // arr: 퀸의 위치
        
        if (depth == N) {
            count++;
            return;
        }
        
        for(int i = 0; i < N; i++) {
            arr[depth] = i;
            if (check(arr, depth)) {
                play(arr, depth + 1);
            }
        }
    }
    
    static boolean check(int[] arr, int depth) {    // depth: 컬럼
        for(int i = 0; i < depth; i++) {
            if (arr[i] == arr[depth] 
                || Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) {
                return false;
            } 
        }
        
        return true;
    }
}
