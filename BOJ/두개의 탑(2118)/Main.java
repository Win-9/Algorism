import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		int[]arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		int start = 0;
		int end = 0;
		
		int current = arr[start];
		
		int result = 0;
		
		while(end < N - 1 && start <= end) {
			System.out.println(start + " " + end);
			int min = Math.min(current, sum - current);
			result = Math.max(min, result);
			
			if (min == current) {
				current += arr[++end];
				continue;
			}
			current -= arr[start++];
		}
		
		System.out.println(result);
		
	}
}
