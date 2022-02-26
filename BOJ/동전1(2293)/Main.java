import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr1 = new int[N + 1];
		int[] arr2 = new int[K + 1];

		for (int i = 1; i <= N; i++) {
			arr1[i] = Integer.parseInt(br.readLine());
		}

		arr2[0] = 1;

		for (int i = 1; i <= N; i++) {
			for (int j = arr1[i]; j <= K; j++) {
				arr2[j] = arr2[j] + arr2[j - arr1[i]];
			}
		}

		System.out.println(arr2[K]);

	}

}
