import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
import java.lang.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T = Integer.parseInt(sc.nextLine());
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		for (int test_case = 1; test_case <= T; test_case++) {
			String[] str = sc.nextLine().split("");
			int xCount = 0;
			for(int i = 0; i < str.length; i++) {
				if (str[i].equals("x")) {
					xCount++;
				}
			}
            
			if (xCount > 7) {
				System.out.println("#" + test_case + " NO");
			} else {
				System.out.println("#" + test_case + " YES");
			}
			
		}
	}
}
