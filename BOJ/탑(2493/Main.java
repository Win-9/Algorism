import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Info> stack = new Stack<>();
		String[]str = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(str[i]);

			Info info = new Info(num, i + 1);
			
			if (stack.isEmpty()) {
				stack.push(info);
				sb.append(0 + " ");
				continue;
			}
			
			if (stack.peek().val >= num) {
				sb.append(stack.peek().index + " ");
				stack.push(info);
			}
			else {
				stack.pop();
				i--;
			}
			
		}
		
		System.out.println(sb.toString());
		
	}
	static class Info{
		int val;
		int index;
		public Info(int val, int index) {
			this.val = val;
			this.index = index;
		}
		
		
	}
}
