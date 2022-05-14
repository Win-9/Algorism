package third;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Fouth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 47, -63, 89, 12, -30, 23, 10};
		int startIndex = 0;
		int[] dp = new int[arr.length];
		dp[0] = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (dp[i - 1] + arr[i] > arr[i]) {
				dp[i] = dp[i - 1] + arr[i];
				continue;
			}
			dp[i] = arr[i];
			startIndex = i;
		}
		
		int max = Arrays.stream(dp).max().getAsInt();
		
		int endIndex = IntStream.range(0, dp.length)
				.filter(i->max == dp[i])
				.findFirst()
				.orElse(-1);
		
		System.out.println(startIndex + " " + endIndex);
	}

}
