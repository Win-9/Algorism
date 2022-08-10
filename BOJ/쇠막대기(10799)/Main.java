import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> stack = new Stack<>();
		String[]str = br.readLine().split("");
		
		int result = 0;
		
		for(int i = 0; i < str.length; i++) {
			if (str[i].equals("(")) {//열림
				stack.push("(");
			}
			else {//닫힘
				stack.pop();
				if (str[i - 1].equals("(")) {//레이져
					result += stack.size();
					continue;
				}
				result++;//잘린 조각들
			}
		}
		System.out.println(result);
	}
}
