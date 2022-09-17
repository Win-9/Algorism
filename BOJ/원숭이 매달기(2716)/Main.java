import java.util.*;
import java.io.*;

class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			int depth = 0;
			int size = 0;
			String[] str = br.readLine().split("");
			
			for(int j = 0; j < str.length; j++) {
				if (str[j].equals("[")) {
					size++;
					depth = Math.max(depth, size);
				}else {
					size--;
				}
			}
			
			sb.append((int)Math.pow(2, depth) + "\n");
			
		}
		
		System.out.println(sb);

	}
}
