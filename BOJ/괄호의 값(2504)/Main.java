import java.util.*;
import java.io.*;

class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> stack = new Stack<>();
		String[] str = br.readLine().split("");

		int result = 0;
		int count = 1;
		for (int i = 0; i < str.length; i++) {
			if (str[i].equals("(")) {
				count *= 2;
				stack.push(str[i]);
			} else if (str[i].equals("[")) {
				count *= 3;
				stack.push(str[i]);
			} else if (str[i].equals(")")) {
				if (stack.isEmpty() || !stack.peek().equals("(")) {// 괄호가 꼬임
					result = 0;
					break;
				}

				if (i - 1 >= 0 && str[i - 1].equals("(")) {
					result += count;
				}

				stack.pop();
				count /= 2;

			} else {
				if (stack.isEmpty() || !stack.peek().equals("[")) {// 괄호가 꼬임
					result = 0;
					break;
				}

				if (i - 1 >= 0 && str[i - 1].equals("[")) {
					result += count;
				}

				stack.pop();
				count /= 3;
			}

		}

		if (!stack.isEmpty()) {
			System.out.println(0);
		} else {
			System.out.println(result);
		}

	}
}
