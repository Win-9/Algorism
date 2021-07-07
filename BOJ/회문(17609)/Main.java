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
		    System.out.println("==================");
	    }
	    
	}
	
	public static int Check(String str) {
		
		int right=str.length()-1;
		int left=0;
		int sum=0;
		
		while(left+1!=right) {
			if(sum>=2) return 2;
			
			
			if(str.charAt(left)==str.charAt(right)) {
				left++;
				right--;
				continue;
			}
			else {
				sum++;
				if(str.charAt(left+1)==str.charAt(right)) {
					left+=2;
					right--;
					continue;
				}
				else if(str.charAt(left)==str.charAt(right-1)){
					left++;
					right-=2;
					continue;
				}
				return 2;
			}
			
		}
		
		return sum;
	    
	}
	
}
