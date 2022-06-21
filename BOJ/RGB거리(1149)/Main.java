import java.util.*;
import java.io.*;

class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][]map = new int[N][3];
		int[][]select = new int[N+1][3];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		select[0][0] = map[0][0];
		select[0][1] = map[0][1];
		select[0][2] = map[0][2];
		
		for(int i = 1; i < N; i++) {
			select[i][0] = Math.min(select[i-1][1], select[i-1][2]) + map[i][0];
			select[i][1] = Math.min(select[i-1][0], select[i-1][2]) + map[i][1];
			select[i][2] = Math.min(select[i-1][0], select[i-1][1]) + map[i][2];
		}
		
		for(int i = 0; i <= N; i++) {
			System.out.println(select[i][0]+" "+select[i][1]+" "+select[i][2]);
		}
		
		System.out.println(Math.min(Math.min(select[N-1][0], select[N-1][1]),
				select[N-1][2]));

	}
	

}
