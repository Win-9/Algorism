import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb=new StringBuilder();
	    int N=Integer.parseInt(br.readLine());
	    String[]str=br.readLine().split(" ");
	    int top=0;
	    int idx=0;
	    while(idx!=(N-1)) {
	    	if(top>N-2) {
	    		sb.append("-1\n");
	    		++idx;
	    		top=idx;
	    		continue;
	    	}
	    	else if(Integer.parseInt(str[idx])<(Integer.parseInt(str[++top]))) {
	    		sb.append(str[top]+"\n");
	    		++idx;
	    		top=idx;
	    		continue;
	    	}
	    		    	
	    }
	    sb.append("-1");
	    System.out.println(sb);

		
	}
	
}
