import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] num = br.readLine().split(" ");
		int N = Integer.parseInt(num[0]);
		int M = Integer.parseInt(num[1]);

		String[] str1 = new String[N];
		ArrayList<String> result = new ArrayList<String>();

		for (int i = 0; i < N; i++) {
			str1[i] = br.readLine();
		}

		Arrays.sort(str1, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2) < 0 ? -1 : 1;
			}
		});

		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if (binarySearch(str1, str)) {
				result.add(str);
			}
		}

		Collections.sort(result, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2) < 0 ? -1 : 1;
			}
		});

		System.out.println(result.size());
		for (String s : result) {
			System.out.println(s);
		}
	}

	static boolean binarySearch(String[] str, String key) {
		int pl = 0;
		int pr = str.length - 1;

		while (pl <= pr) {
			int pc = (pl + pr) / 2;

			if (str[pc].contentEquals(key)) {
				return true;
			}

			if (str[pc].compareTo(key) < 0) {
				pl = pc + 1;
			} else if (str[pc].compareTo(key) > 0) {
				pr = pc - 1;
			}
		}
		return false;
	}

}
