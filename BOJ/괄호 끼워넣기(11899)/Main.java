import java.util.*;
import java.io.*;

class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[]str = br.readLine().split("");
		
		Stack<String> stack = new Stack<>();
		
		for(int i = 0; i < str.length; i++) {
			if (stack.isEmpty()) {
				stack.push(str[i]);
				continue;
			}
			
			if (str[i].equals("(")) {
				stack.push(str[i]);
				continue;
			}
			
			if (str[i].equals(")") && stack.peek().equals("(")) {
				stack.pop();
				continue;
			}
			
			stack.push(str[i]);
		}
		
		
		System.out.println(stack.size());
		
	
	}
}
