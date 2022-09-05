package por;

import java.util.*;
import java.io.*;

class bj {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Queue<String> queue = new LinkedList<>();
		Stack<String> LStack = new Stack<>();
		Stack<String> SStack = new Stack<>();

		Arrays.stream(br.readLine().split("")).forEach(a -> queue.add(a));
		int result = 0;
		while (!queue.isEmpty()) {
			String str = queue.poll();

			if (str.equals("L")) {
				LStack.push(str);
			} else if (str.equals("S")) {
				SStack.push(str);
			} else if (str.equals("R")) {
				if (!LStack.isEmpty()) {
					LStack.pop();
					result++;
					continue;
				}
				System.out.println(result);
				return;
			} else if (str.equals("K")) {
				if (!SStack.isEmpty()) {
					SStack.pop();
					result++;
					continue;
				}
				System.out.println(result);
				return;
			} else {
				result++;
			}
			
		}

		System.out.println(result);
	}
}
