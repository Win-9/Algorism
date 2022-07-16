import java.util.*;
import java.io.*;

class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Long> list = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine());
		if (N >= 1023) {
			System.out.println("-1");
			return;
		}
		
		for(int i = 0; i < 10; i++) {
			recursive(i,1,list);
		}
		
		Collections.sort(list);
		System.out.println(list.get(N));
		

	}
	
	static void recursive(long num, int depth, ArrayList<Long> list) {
		if (depth > 10) {
			return;
		}
		
		list.add(num);
		
		for(int i = 0; i < num % 10; i++) {
			recursive((num * 10) + i, depth + 1, list);
		}
	}
}
