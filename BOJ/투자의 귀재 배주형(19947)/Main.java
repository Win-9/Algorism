import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		int[] year = new int[Y + 1];
		year[0] = H;

		for (int i = 1; i <= Y; i++) {
			year[i] = (int) (year[i - 1] * 1.05);

			if (i >= 3) {
				year[i] = Math.max((int)(year[i - 3] * 1.2), year[i]);
			}

			if (i >= 5) {
				year[i] = Math.max((int)(year[i - 5] * 1.35), year[i]);
			}

		}

		System.out.println(year[Y]);

	}

}
