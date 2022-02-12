import java.io.*;
import java.util.*;

public class Main {

	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int count = 0;
		
		while(N > 0) {
			if (N % 5 == 0) {
				int num = N/5;
				count += num;
				N -= num * 5;
				continue;
			}
			N -= 3;
			count++;
		}
		
		if (N == 0) System.out.println(count);
		else System.out.println(-1);
		
	}

}
