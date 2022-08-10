import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			String[]str = br.readLine().split(" ");
			
			switch (str[0]) {
			case "push":
				stack.push(str[1]);
				break;
			case "pop":
				if (stack.size() == 0) {
					System.out.println("-1");
				}
				else {
					System.out.println(stack.pop());
				}
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				if (stack.isEmpty()) {
					System.out.println("1");
				}
				else {
					System.out.println("0");
				}
				break;
			case "top":
				if (stack.size() == 0) {
					System.out.println("-1");
				}
				else {
					System.out.println(stack.peek());
				}
				break;
			default:
				break;
			}
		}
	}
}
