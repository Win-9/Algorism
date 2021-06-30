import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    PriorityQueue<Integer>result_queue=new PriorityQueue<Integer>();
	    int result=0;
	    int N=Integer.parseInt(br.readLine());
	    int[][]data=new int[N][2];
	    for(int i=0;i<N;i++) {
	    	String[]str=br.readLine().split(" ");
	    	data[i][0]=Integer.parseInt(str[0]);
	    	data[i][1]=Integer.parseInt(str[1]);
	    }
	    Arrays.sort(data, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0]>o2[0]?1:-1;
			} 
		});
	    result_queue.add(data[0][1]);
	    
	    for(int i=1;i<N;i++) {
	    	
	    	if(result_queue.peek()==data[i][0]) {
	    		result_queue.poll();
	    	}
	    	result_queue.add(data[1][1]);
	    }
	    
	    System.out.println(result_queue.size());
	    
	}
}
