import java.util.*;
import java.io.*;

class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");

			System.out.println(Integer.parseInt(str[0]) - 1);
			int k = Integer.parseInt(str[1]);

			for (int j = 0; j < k; j++) {
				br.readLine();
			}
		}

	}

}
