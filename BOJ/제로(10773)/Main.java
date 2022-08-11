import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num != 0) {
				stack.push(num);
				continue;
			}
			stack.pop();
		}
		
		while(!stack.isEmpty()) {
			result += stack.pop();
		}
		
		System.out.println(result);
		
	}
}
