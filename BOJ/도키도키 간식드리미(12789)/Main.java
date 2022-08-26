import java.util.*;
import java.io.*;

class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		Queue<Integer> queue = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		Arrays.stream(br.readLine().split(" ")).mapToInt(a -> Integer.parseInt(a)).forEach(a -> queue.add(a));

		int count = 1;

		while (!queue.isEmpty()) {

			if (queue.peek() == count) {
				queue.poll();
				count++;
				continue;
			}

			if (!stack.isEmpty() && stack.peek() == count) {
				stack.pop();
				count++;
				continue;
			}
			
			stack.push(queue.poll());
		}

		while (!stack.isEmpty()) {

			if (stack.peek() == count) {
				stack.pop();
				count++;
				continue;
			}

			break;
		}


		System.out.println(stack.isEmpty() == true ? "Nice" : "Sad");

	}
}
