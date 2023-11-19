import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int firstIndex = 0;
        
        for(int i = 0; i < arr.length; i++) {
            if (n < arr[i]) {
                firstIndex = i;
                break;
            }
        }
        
        if (firstIndex == 0) {
            sum += (arr[firstIndex] - n) * (n - 1) ;
        } else {
            sum += (arr[firstIndex] - n) * (n - arr[firstIndex - 1] - 1);
        }
        sum += (arr[firstIndex] - n) - 1;
        
        if (sum < 0) {
            System.out.println(0);
        } else {
            System.out.println(sum);
        }
    }
}
