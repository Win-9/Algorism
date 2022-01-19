import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> setA = new HashSet<>();
		Set<Integer> tmpSet = new HashSet<>();
		Set<Integer> setB = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreElements()) {
			setA.add(Integer.parseInt(st.nextToken()));
		}
		
		tmpSet.addAll(setA);
		
		st = new StringTokenizer(br.readLine());

		while(st.hasMoreElements()) {
			setB.add(Integer.parseInt(st.nextToken()));
		}
		setA.removeAll(setB);
		setB.removeAll(tmpSet);
		
		System.out.println(setA.size() + setB.size());
		
		
		
	}

}
