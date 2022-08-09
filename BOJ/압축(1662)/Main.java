import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(br.readLine());
		
		//10342(76)
		for(int i = 0; i < sb.length(); i++) {
			String str = new StringBuilder(sb.substring(i, i + 1)).toString();
			int j = i - 1;
			if (str.equals(")")) {
				StringBuilder sub = new StringBuilder();
				for(;j >= 0; j--) {
					String backWord = sb.substring(j, j + 1);
					if (backWord.equals("(")) {
						
						int num = Integer.parseInt(sb.substring(j - 1, j));
						
						String reveserWord = repeat(sub.reverse().toString(), num);
						
						sb.replace(j - 1, i + 1, reveserWord);
						
						break;
					}
					sub.append(backWord);
				}
				
				i = j - 2;
			}
			
		}
		System.out.println(sb.length());
		
	}
	
	static String repeat(String str, int num) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < num; i++) {
			sb.append(str);
		}
		
		return sb.toString();
	}
}
