import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int answer = 0;
        int H = Integer.parseInt(str[0]);
        int W = Integer.parseInt(str[1]);
        int[] heights = new int[W];
        str = br.readLine().split(" ");
        for(int i = 0; i < W; i++) {
            heights[i] = Integer.parseInt(str[i]);
        }
        int sum = 0;

        for(int i = 1; i < heights.length; i++) {
            int leftMax = 0;
            for(int j = 0; j <= i ; j++) {
                leftMax = Math.max(leftMax, heights[j]);
            }

            int rightMax = 0;
            for(int j = i; j < W ; j++) {
                rightMax = Math.max(rightMax, heights[j]);
            }

            sum += Math.min(leftMax, rightMax) - heights[i];

        }
        System.out.println(sum);
    }
    
}
