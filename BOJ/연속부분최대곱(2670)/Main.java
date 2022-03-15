import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double[] arr= new double[N + 1];
		
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Double.parseDouble(br.readLine());
		}
		
		
		for(int i = 2; i <= N; i++) {
			if (arr[i] < arr[i] * arr[i - 1]) {
				arr[i] = arr[i] * arr[i - 1];
			}
		}
		
		double result = Arrays.stream(arr).max().getAsDouble();
		
		System.out.println(String.format("%.3f", result));	
		
		
	}
}
