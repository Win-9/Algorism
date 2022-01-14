import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main2 {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int M = Integer.parseInt(br.readLine());
			int[] score = new int[M + 1];
			for (int j = 0; j < M; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				score[Integer.parseInt(st.nextToken())]
						= Integer.parseInt(st.nextToken());
			}
			sb.append(calcu(score) + "\n");
		}
		System.out.println(sb);

	}

	static int calcu(int[] score) {
		int sum = 0;
		int max = score[1];
		for (int i = 1; i < score.length; i++) {
			if (max >= score[i]) {
				max = score[i];
				sum++;
			}
		}

		return sum;
	}

}
