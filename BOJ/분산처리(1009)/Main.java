import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int[]arr = Arrays.stream(br.readLine().split(" "))
					.mapToInt(a -> Integer.parseInt(a)).toArray();
			
			int num = 1;
			for(int j = 0; j < arr[1]; j++) {
				num = (num*arr[0]) % 10;
			}
			
			if (num == 0) {
				System.out.println(10);
			}
			else {
				System.out.println(num);
			}
			
		}
		
		
	}
}
