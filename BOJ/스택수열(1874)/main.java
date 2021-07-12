import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    Stack<Integer>stack=new Stack<Integer>();
	 
	    boolean check=false;
	    int N=Integer.parseInt(br.readLine());
	    StringBuilder sb=new StringBuilder();
	    int sp=1;
	    for(int i=0;i<N;i++) {
	    	int count=Integer.parseInt(br.readLine());
	    	if(check) continue;
	    	if(!stack.empty() && stack.peek()==count) {
	    		stack.pop();
	    		sb.append("-\n");
	    	}
	    	else if(!stack.empty() && stack.peek()>count) {
	    		sb=new StringBuilder("NO");
	    		check=true;
	    	}
	    	else {
	    		for(;sp<=count;sp++) {
		    		stack.push(sp);
		    		sb.append("+\n");
		    	}
	    		stack.pop();
	    		sb.append("-\n");
	    	}
	    	
	    }
	    
	    System.out.println(sb);
	    
	}
	
}
