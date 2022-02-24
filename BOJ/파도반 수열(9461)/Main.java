import java.io.*;
import java.util.*;

public class Main {
	static long[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new long[101];
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		arr[4] = 2;
		arr[5] = 2;
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			func(num);
		}
	}
	
	static void func(int num) {
		for(int i = 6; i <= num; i++) {
			arr[i] = arr[i - 1] + arr[i - 5];
		}
		System.out.println(arr[num]);
	}

}
