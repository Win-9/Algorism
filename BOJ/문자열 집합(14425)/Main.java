import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		TreeSet<String> set = new TreeSet<>();
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			if (set.contains(str)) {
				count++;
				continue;
			}
		}
		
		System.out.println(count);
    }
}
