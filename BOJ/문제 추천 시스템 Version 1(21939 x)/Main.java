import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		TreeSet<Problem> set = new TreeSet<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int level = Integer.parseInt(st.nextToken());
			map.put(num, level);
			set.add(new Problem(num, level));
		}
		
		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			switch(order) {
			case "add":
				int num = Integer.parseInt(st.nextToken());
				int level = Integer.parseInt(st.nextToken());
				set.add(new Problem(num, level));
				map.put(num, level);
				break;
			case "solved":
				int num2 = Integer.parseInt(st.nextToken());
				set.remove(new Problem(num2, map.get(num2)));
				map.remove(num2);
				break;
			case "recommend":
				int orderNum = Integer.parseInt(st.nextToken());
				if (orderNum == 1) {
					sb.append(set.first().num).append("\n");
					break;
				}
				sb.append(set.last().num).append("\n");
			}

		}
		
		System.out.println(sb);

	}
}

class Problem implements Comparable<Problem>{	
	int num;
	int level;
	public Problem(int num, int level) {
		this.num = num;
		this.level = level;
	}

	@Override
	public int compareTo(Problem o) {
		// TODO Auto-generated method stub
		if (level == o.level) {
			return num - o.num;
		}
		
		return o.level - level;
	}
}
