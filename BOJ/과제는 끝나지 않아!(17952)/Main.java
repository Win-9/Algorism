import java.util.*;
import java.io.*;

class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int minute = Integer.parseInt(br.readLine());
		Stack<Assignment> stack = new Stack<>();

		int result = 0;

		while (minute != 0) {

			String[] str = br.readLine().split(" ");
			if (str[0].equals("0")) {
				
				if (!stack.isEmpty()) {
					Assignment assign = stack.pop();
										
					if (assign.time == 1) {
						result += assign.score;
					} else {
						assign.time--;
						stack.push(assign);
					}

				}
				
			} else if(str[2].equals("1")){
				result += Integer.parseInt(str[1]);
			}
			else {
				stack.add(new Assignment(Integer.parseInt(str[1]), Integer.parseInt(str[2]) - 1));
			}
									
			minute--;

		}
		
		System.out.println(result);

	}

	static class Assignment {
		int score;
		int time;

		public Assignment(int score, int time) {
			this.score = score;
			this.time = time;
		}
	}
}
