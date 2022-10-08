import java.util.*;
import java.io.*;

class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] str = br.readLine().split("");
			
			if (str[0].equals("0")) {
				break;
			}
			
			int left = 0;
			int right = str.length - 1;
			boolean flag = true;
			while(left < right) {
				if (str[left].equals(str[right])) {
					left++;
					right--;
				}else {
					flag = false;
					break;
				}
			}
			
			if (flag) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
		
	}
}
