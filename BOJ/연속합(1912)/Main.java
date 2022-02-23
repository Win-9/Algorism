import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[]arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i < N; i++) {
			if (arr[i] < arr[i] + arr[i - 1]) {
				arr[i] = arr[i] + arr[i - 1];
			}
		}
		
		System.out.println(Arrays.stream(arr).max().getAsInt());
	}

}
