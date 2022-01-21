import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int count = 0;
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		TreeSet<Integer> set = new TreeSet<>();
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			if (set.contains(num)) {
				set.remove(num);
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list);
		if (set.size()==0) {
			System.out.println(0);
		}
		else {
			System.out.println(list.size());
			for(int a: list) {
				sb.append(a).append(" ");
			}
		}
		System.out.println(sb);
		
	}

}
