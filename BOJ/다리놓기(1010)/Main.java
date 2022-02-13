import java.io.*;
import java.util.*;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int west = Integer.parseInt(st.nextToken());
			int east = Integer.parseInt(st.nextToken());
			System.out.println(func(west, east));
		}
				
	}
	
	static long func(int west, int east) {
		long E = 1;
		long W = 1;
		long sum = east;
		
		if (east - west < west) {
			west = east - west;
		}
		
		for(int i = 0; i < west; i++) {
			E *= sum--;
		}
				
		for(int j = 1; j <= west; j++) {
			W *= j;
		}
		
		System.out.println(E+"/"+W);
		
		return E/W;
	}

}
