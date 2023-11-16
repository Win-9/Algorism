import java.util.Scanner;
import java.io.FileInputStream;
import java.lang.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=Integer.parseInt(sc.nextLine());

		for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(sc.nextLine());
            String str = sc.nextLine();
            if (N % 2 != 0) {
                System.out.println("#" + test_case + " No" );
                continue;
            }

            String firstHalf = str.substring(0, N/2);
            String secondHalf = str.substring(N/2, N);

            if (firstHalf.equals(secondHalf)) {
                System.out.println("#" + test_case + " Yes");
            } else {
                System.out.println("#" + test_case + " No");
            }
        }
	}
}
