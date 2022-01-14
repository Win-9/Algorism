import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static Score[] buff;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int M = Integer.parseInt(br.readLine());
			Score[] score = new Score[M];
			for (int j = 0; j < M; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				score[j] = new Score(Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
			}
			mergeSort(score, M);
			sb.append(calcu(score) + "\n");
		}
		System.out.println(sb);

	}

	static void mergeSort(Score[] arr, int N) {
		buff = new Score[N];
		mergeSorting(arr, 0, N - 1);
		buff = null;
	}

	static void mergeSorting(Score[] arr, int left, int right) {
		if (left < right) {
			int i = 0;
			int j = 0;
			int center = (left + right) / 2;
			int k = left;
			int p = 0;
			mergeSorting(arr, left, center);
			mergeSorting(arr, center + 1, right);

			for (i = left; i <= center; i++) {
				buff[p++] = arr[i];
			}

			while (i <= right && j < p) {
				arr[k++] = compare(buff[j], arr[i]) ? buff[j++] : arr[i++];
			}

			while (j < p) {
				arr[k++] = buff[j++];
			}

		}
	}

	static boolean compare(Score score1, Score score2) {
		return score1.xScore < score2.xScore;
	}

	static int calcu(Score[] score) {
		int sum = 1;
		int max = score[0].yScore;
		for (int i = 1; i < score.length; i++) {
			if (max > score[i].yScore) {
				max = score[i].yScore;
				sum++;
			}
		}

		return sum;
	}

}

class Score {
	int xScore;
	int yScore;

	public Score(int xScore, int yScore) {
		// TODO Auto-generated constructor stub
		this.xScore = xScore;
		this.yScore = yScore;
	}
}
