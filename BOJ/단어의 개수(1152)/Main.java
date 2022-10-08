import java.util.*;
import java.io.*;

class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[]str = br.readLine().split(" ");
		if (str.length == 0) {
			System.out.println(0);
		}else if (str[0].equals("")){
			System.out.println(str.length - 1);
		}else {
			System.out.println(str.length);
		}
		
	}
}
