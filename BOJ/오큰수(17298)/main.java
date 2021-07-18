package por;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.Stream;

public class bj {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb=new StringBuilder();
	    int N=Integer.parseInt(br.readLine());
	    
	    
	    String[]str=br.readLine().split(" ");
	    
	    int[]arr =Stream.of(str).mapToInt(s->Integer.parseInt(s)).toArray();
	    
	    Stack<Integer>stack=new Stack<Integer>();
	    
	    for(int i=0;i<N;i++) {
	    	
	    	while(!stack.empty() && arr[stack.peek()]<arr[i]) {
	    		arr[stack.pop()]=arr[i];
	    	}
	    	stack.push(i);
	    	
	    }
	    
	    while(!stack.isEmpty()) {
			arr[stack.pop()]=-1;
		}
		for (int i = 0; i < N; i++) {
			sb.append(arr[i]+" ");
		}
		System.out.println(sb.toString());
		
	}
	
}
