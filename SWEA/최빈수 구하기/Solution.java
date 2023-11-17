import java.util.Scanner;
import java.io.FileInputStream;
import java.lang.*;
import java.util.*;

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
		T = Integer.parseInt(sc.nextLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
            Map<Integer, Integer> map = new HashMap<>();
            int N = Integer.parseInt(sc.nextLine());
            int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            
            for(int n : arr) {
            	map.put(n, map.getOrDefault(n, 0) + 1);
            }
            
            int max = 0;
            int maxKey = 0;
            for(int n : map.keySet()) {
            	if (max < map.get(n)) {
                	maxKey = n;
                    max = map.get(n);
                } else if (max == map.get(n)) {
                	if (maxKey < n) {
                    	maxKey = n;
                    	max = map.get(n);
                    }
                }
            }
            System.out.println("#" + test_case + " " + maxKey);
		}
	}
}
