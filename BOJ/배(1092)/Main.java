import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> cranes = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			cranes.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		ArrayList<Integer> boxes = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			boxes.add(Integer.parseInt(st.nextToken()));
		}
		
		cranes.sort(Collections.reverseOrder());
		boxes.sort(Collections.reverseOrder());
		
		if (cranes.get(0) < boxes.get(0)) {
			System.out.println("-1");
			return;
		}
		
		int result = 0;
		
		while(!boxes.isEmpty()) {
			int craneInx = 0;
			int boxIdx = 0;
			for(;craneInx < N && boxes.size() > 0; craneInx++) {
				if (boxIdx >= boxes.size()) {
					break;
				}
				
				int box = boxes.get(boxIdx);
				if (box <= cranes.get(craneInx)) {
					boxes.remove(boxIdx);
					continue;
				}
				craneInx--;
				boxIdx++;
			}
			result++;
		}
		
		System.out.println(result);
	}
}
