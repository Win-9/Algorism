import java.util.*;
import java.io.*;

class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[][]str = new String[5][15];
		for(int i = 0; i < 5; i++) {
			String[] s = br.readLine().split("");
			for(int j = 0; j < s.length; j++) {
				str[i][j] = s[j];
			}
		}
		
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 5; j++) {
				if (str[j][i] != null) {
					System.out.print(str[j][i]);
				}
			}
		}
		
	}
}
