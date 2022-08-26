import java.util.*;
import java.io.*;

class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Flag> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			list.add(new Flag(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
		}
		
		Collections.sort(list, new Comparator<Flag>() {

			@Override
			public int compare(Flag o1, Flag o2) {
				// TODO Auto-generated method stub
				return o1.x - o2.x;
			}
		});
		
		int maxIndex = list.indexOf(Collections.max(list, new Comparator<Flag>() {

			@Override
			public int compare(Flag o1, Flag o2) {
				// TODO Auto-generated method stub
				return o1.value - o2.value;
			}
			
		}));
				
		
				
		int result = 0;
		
		Flag max = list.get(0);
		
		for(int i = 1; i <= maxIndex; i++) {
			Flag now = list.get(i);

			if (now.value >= max.value) {
				result += (now.x - max.x) * (max.value);
				max = now;
				
				continue;
			}
		}
		
		
		max = list.get(N - 1);

		for(int i = N - 2; i >= maxIndex; i--) {
			Flag now = list.get(i);
			
			if (now.value >= max.value) {
				result += (max.x - now.x) * (max.value);
				max = now;
				continue;
			}
		}
		
		System.out.println(result + list.get(maxIndex).value);

	}
	
	static class Flag{
		int x;
		int value;
		
		public Flag(int x, int value) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.value = value;
		}
		
	}
}
