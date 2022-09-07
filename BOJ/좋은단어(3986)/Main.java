import java.util.*;
import java.io.*;

class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int result = 0;
		
		
		for(int i = 0; i < N; i++) {
			Stack<String> stack = new Stack<>();
			
			String[]str = br.readLine().split("");
			
			for(int j = 0; j < str.length; j++) {
				
				if (stack.isEmpty()) {
					stack.push(str[j]);
					continue;
				}
				
				if (str[j].equals(stack.peek())) {
					stack.pop();
				}
				else {
					stack.push(str[j]);
				}
				
				
			}
			
			if (stack.isEmpty()) {
				result++;
			}
		}
		
		System.out.println(result);

	}
}
