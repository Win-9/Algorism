import java.io.*;
import java.util.*;

public class Main {
	static int[]arrA;
	static int[]arrB;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder("A");
		
		arrA = new int[N + 1];
		arrB = new int[N + 1];
		arrA[0] = 1;
		arrA[1] = 0;
		arrB[0] = 0;
		arrB[1] = 1;
		System.out.print(fibo(N, arrA)+" "+ fibo(N, arrB));

	}

	 static int fibo(int N, int[] arr) {
		 
		 if (N == 0) {
			 return arr[0];
		 }
		 
		 if (N == 1) {
			 return arr[1];
		 }
		 
		 if (arr[N] != 0) {
			 return arr[N];
		 }
		 
		 return arr[N] = fibo(N - 1, arr) + fibo(N - 2, arr);
		 
	}


}
