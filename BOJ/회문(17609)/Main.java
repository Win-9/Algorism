package por;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
	    
	    
	    
	}
	public static void Check(String str) {
	    Stack<Character>stack=new Stack<Character>();
	    for(int i=0;i<str.length();i++) {
	    	stack.push(str.charAt(i));
	    	
	    }
	}
}
