package por;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class bj {
	static int N;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N=Integer.parseInt(br.readLine());
	    StringBuffer sb=new StringBuffer();
	    for(int i=0;i<N;i++) {
	    	int number=(int) Math.pow(3, N);
	    	for(int j=0;j<number;j++) {
	    		sb.append("-");
	    	}
	    	
	    	merge(0,N,sb);
	    }
	}
	public static void merge(int start,int end,StringBuffer sb) {
		
		if(sb.charAt(1)==' ')
			return;
		for(int i=start;i<end/3;i++) {
			
		}
		merge(0,N/3,sb);
		merge(N/3,(N/3)*2,sb);
		merge((N/3)*2,N,sb);
	}
}
