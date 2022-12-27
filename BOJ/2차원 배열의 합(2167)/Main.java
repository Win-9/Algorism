import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] mapNumbers = br.readLine().split(" ");
		int N = Integer.parseInt(mapNumbers[0]);
		int M = Integer.parseInt(mapNumbers[1]);
		int[][]map = new int[N + 1][M + 1];
		
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				map[i + 1][j + 1] = Integer.parseInt(str[j]);
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		
		for(int s = 0; s < K; s++) {
			int sum = 0;
			String[] str = br.readLine().split(" ");
			int i = Integer.parseInt(str[0]);
			int j = Integer.parseInt(str[1]);
			int x = Integer.parseInt(str[2]);
			int y = Integer.parseInt(str[3]);
			for(; i <= x; i++) {
				for(int v = j; v <= y; v++) {
					sum += map[i][v];
				}
			}
			System.out.println(sum);
		}
    }
	

}
