import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
import java.lang.*;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(sc.nextLine());
            long sum = 0;
            int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int max = arr[N-1];

            for(int i = N-2; i >= 0; i--) {
                if(arr[i] > max) {
                    max = arr[i];
                } else {
                    sum += (max - arr[i]);
                }
            }
            System.out.println("#" + test_case + " " + sum);
        }
    }
}
