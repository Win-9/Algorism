import java.io.*;
import java.util.*;

public class Main {
	static long[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder("A");

		arr = new long[N + 1];
		if (N == 1) {
			System.out.println(4);
			return;
		}
		arr[1] = 1;
		arr[2] = 1;
		fibo(N);
		System.out.print(arr[N] * 4 + arr[N - 1] * 2);

	}

	static long fibo(int N) {

		if (N == 1) {
			return 1;
		}

		if (N == 2) {
			return 1;
		}

		if (arr[N] != 0) {
			return arr[N];
		}

		return arr[N] = fibo(N - 1) + fibo(N - 2);

	}

}
