import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		binaryV2(N);
		System.out.println(sb.reverse());
		
	}
	
	static void binaryV1(long N) {
		while(true) {
			long num1 = N % 2;
			N /= 2;
			
			if (N == 1L) {
				sb.append(num1).append(N);
				break;
			}
			else if(N == 0L) {
				sb.append(num1);
				break;
			}
			
			sb.append(num1);
			
		}
		
		System.out.println(sb.reverse());
	}
	
	static void binaryV2(long N) {
		
		if (N == 0) {
			sb.append(0);
			return;
		}
		
		if (N == 1) {
			sb.append(1);
			return;
		}
		
		long num1 = N % 2;
		sb.append(num1);
		binaryV2(N/2);
	}
}
