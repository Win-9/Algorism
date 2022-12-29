import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	static String[][]map;
	static int N;
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new String[N][N];
		
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for(int j = 0; j < N; j++) {
				map[i][j] = str[j];
			}
		}
		
		//행 교환
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N - 1; j++) {
				String s = map[i][j];
				map[i][j] = map[i][j + 1];
				map[i][j + 1] = s;
				checkMax();
				
				s = map[i][j];
				map[i][j] = map[i][j + 1];
				map[i][j + 1] = s;
			}
		}
		

		
		//열 교환
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N - 1; j++) {
				String s = map[j][i];
				map[j][i] = map[j + 1][i];
				map[j + 1][i] = s;
				
				checkMax();
				
				s = map[j][i];
				map[j][i] = map[j + 1][i];
				map[j + 1][i] = s;
			}
			
		}
		
		System.out.println(max);
		
    }
	
	public static void checkMax() {
		//행검사
		for(int i = 0; i < N; i++) {
			int count = 1;
			for(int j = 0; j < N - 1; j++) {
				if (map[i][j].equals(map[i][j + 1])) {
					count++;
					continue;
				}
				max = Math.max(max, count);
				count = 1;
			}
			max = Math.max(max, count);
		}
		
		
		//열검사
		for(int i = 0; i < N; i++) {
			int count = 1;
			for(int j = 0; j < N - 1; j++) {
				if (map[j][i].equals(map[j + 1][i])) {
					count++;
					continue;
				}
				max = Math.max(max, count);
				count = 1;
			}
			max = Math.max(max, count);
		}
		
	}

}
