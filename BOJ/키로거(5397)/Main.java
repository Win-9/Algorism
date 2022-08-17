import java.util.*;
import java.io.*;

class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			Stack<String> stack = new Stack<>();
			List<String> list = new LinkedList<>();

			String[] str = br.readLine().split("");
			for (int j = 0; j < str.length; j++) {
				
				switch (str[j]) {
					case ">":
						if (!list.isEmpty()) {
							stack.add(list.remove(list.size() - 1));
						}
						break;
					case "<":
						if (!stack.isEmpty()) {
							list.add(stack.pop());
						}
						break;
					case "-":
						if (!stack.isEmpty()) {
							stack.pop();
						}
						break;
	
					default:
						stack.push(str[j]);
				}
				
			}
			StringBuilder sb = new StringBuilder();

			Collections.reverse(list);
			for(String a : list) {
				stack.push(a);
			}
			
			while (!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			
			System.out.println(sb.reverse());
		}

	}
}
