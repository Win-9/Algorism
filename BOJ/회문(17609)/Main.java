package por;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class bj {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int N=Integer.parseInt(br.readLine());
	    String[]all_str=new String[N];
	    for(int i=0;i<N;i++) {
	    	all_str[i]=br.readLine();
	    }
	    
	    for(int i=0;i<N;i++) {
		    System.out.println(Check(all_str[i]));
	    }
	    
	}
	
	public static int Check(String str) {
	    Stack<Character>stack=new Stack<Character>();
	    ArrayList<Character>list=new ArrayList<Character>();
	    int i=0;
	    for(;i<str.length();i++) {
	    	if(stack.size()!=0 && str.charAt(i)==(stack.peek())) {
	    		break;
	    	}
	    	stack.push(str.charAt(i));
	    }
	    
	    for(;i<str.length();i++) {
	    	if(stack.size()!=0 && str.charAt(i)==stack.peek()) {
	    		stack.pop();
	    		continue;
	    	}
	    	list.add(str.charAt(i));
	    }
	    
	    return list.size()==0 && stack.size()==0 ? 0: (list.size()==1 && stack.size()==0 ) || (list.size()==0 && stack.size()==1 )?1:2;
	    
	    
	}
	
}
