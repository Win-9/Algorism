import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}
		int answer = 0;
		Arrays.sort(arr);
		for(int i=1; i<=n; i++){
			answer = Math.max(answer, arr[n-i]*i);
		}
		System.out.println(answer);
	}

}
