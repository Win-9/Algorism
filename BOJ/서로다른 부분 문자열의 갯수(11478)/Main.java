import java.util.*;
import java.io.*;

class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TreeSet<String> set = new TreeSet<>();
		
		StringBuilder sb = new StringBuilder(br.readLine());

		
		for(int i = 0; i < sb.length(); i++) {
			for(int j = i + 1; j < sb.length() + 1; j++) {
				set.add(sb.substring(i,j));
			}
		}
		
		System.out.println(set.size());

	}
}
