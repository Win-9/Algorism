import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	static int N;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ArrayList<Integer> result = new ArrayList<>();
		String[] memo = br.readLine().split(" ");
		
		for(int i = N; i >= 1; i--) {
			result.add(Integer.parseInt(memo[i - 1]), i);
		}
		
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

}
