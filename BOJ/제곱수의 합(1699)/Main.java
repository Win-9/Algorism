import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[]arr = new long[N + 1];
		
		if (N == 1) {
			System.out.println(1);
			return;
		}
		arr[1] = 1;
		
		
		for(int i = 2; i <= N; i++) {
			arr[i] = arr[i - 1] + 1;
			
			for(int j = 1; j * j <= i; j++) {
				if (arr[i] > arr[i - j * j] + 1) {
					System.out.println(i);
					System.out.println(arr[i]);
					System.out.println(arr[i - j * j] + 1);
					arr[i] = arr[i - j * j] + 1;
					System.out.println("===");
				}
			}
		}
		
		
		
				
		System.out.println(arr[N]);
	}

}
