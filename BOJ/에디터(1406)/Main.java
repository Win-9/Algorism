import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> list = Arrays.stream(br.readLine().split("")).collect(Collectors.toList());
		Stack<String> stack = new Stack<>();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			switch (str[0]) {
			case "L":
				if (list.size() == 0) {
					break;
				}
				stack.add(list.remove(list.size() - 1));
				break;
			case "D":
				if (stack.isEmpty()) {
					break;
				}
				list.add(stack.pop());
				break;
			case "B":
				if (list.size() == 0) {
					break;
				}
				list.remove(list.size() - 1);
				break;
			case "P":
				list.add(str[1]);
				break;
			default:
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (String str : list) {
			sb.append(str);
		}

		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		System.out.println(sb);
	}
}
