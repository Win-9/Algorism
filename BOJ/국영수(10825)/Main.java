import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static Infomation[] buff;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Infomation[] info = new Infomation[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			info[i] = new Infomation(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}

		merge(info, N);

		for (int i = 0; i < N; i++) {
			sb.append(info[i].name + '\n');
		}
		System.out.println(sb);
	}

	static void merge(Infomation[] loc, int N) {
		buff = new Infomation[N];

		merge_sort(loc, 0, N - 1);
		buff = null;
	}

	static void merge_sort(Infomation[] loc, int left, int right) {
		if (left < right) {
			int p = 0;
			int j = 0;
			int i;
			int k = left;
			int center = (left + right) / 2;

			merge_sort(loc, left, center);
			merge_sort(loc, center + 1, right);

			for (i = left; i <= center; i++) {
				buff[p++] = loc[i];
			}

			while (i <= right && j < p) {
				loc[k++] = compare(buff[j], loc[i]) ? buff[j++] : loc[i++];
			}

			while (j < p) {
				loc[k++] = buff[j++];
			}

		}
	}

	static boolean compare(Infomation info1, Infomation info2) {
		if (info1.korean > info2.korean) {
			return true;
		}else if (info1.korean < info2.korean) return false;

		if (info1.eng > info2.eng) {
			return false;
		}else if (info1.eng < info2.eng) return true;

		if (info1.math > info2.math) {
			return true;
		}else if (info1.math < info2.math) return false;

		if ((info1.name).compareTo(info2.name) < 0) {
			return true;
		}

		return false;

	}

}

class Infomation {
	String name;
	int korean;
	int math;
	int eng;

	public Infomation(String name, int korean, int eng, int math) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.korean = korean;
		this.eng = eng;
		this.math = math;
	}
}
