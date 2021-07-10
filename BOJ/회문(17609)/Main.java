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
		
		while(left!=right || left+1!=right) {
			if(left==right || left+1==right) break;
			switch(str.length()/2) {
				case 0:
					if(str.charAt(left)==str.charAt(right)) {
						left++;
						right--;
					}
					else {
						return 2;
					}
					break;
					
				case 1:
					if(str.charAt(left)==str.charAt(right)) {
						System.out.println("left:"+left);
						System.out.println("right:"+right);
						left++;
						right--;
					}
					else if(str.charAt(left+1)==str.charAt(right)){
						left+=2;
						right--;
						sum++;
					}
					else if(str.charAt(left)==str.charAt(right+1)) {
						right-=2;
						left++;
						sum++;
					}
					else return 2;
					
					break;
					
			}
			if(sum>=2) return 2;
			
		}
		if(str.length()/2!=0)	sum++;
		
		return sum;
	    
	}
	
}
