import java.util.*;
import java.io.*;

class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = N;
		int count = 1;
		
		while(true) {
			int a = N % 10;
			int b = (N / 10) + a;
			N = (a * 10) + (b % 10);
			
			if (N == result) {
				break;
			}
			
			count++;
		}
		
		System.out.println(count);
		
	}
}
