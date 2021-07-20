package por;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Stream;

public class bj {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int number=Integer.parseInt(br.readLine());
	    String[]str;
	    for(int i=0;i<number;i++) {
	    	str=br.readLine().split(" ");
	    	int N=Integer.parseInt(str[0]);
	    	int M=Integer.parseInt(str[1]);
	    	Check(N,M,br.readLine());
	    	
	    }
		
	}
	
	public static void Check(int N,int M,String str) {
		int[]arr=Stream.of(str).mapToInt(s->Integer.parseInt(s)).toArray();
		int max=Arrays.stream(arr).max().getAsInt();
		int count=0;int i=0;
		while(true) {
			if(arr[i]<max) {
				int temp=arr[i];
				arr[i]=arr[arr.length-1];
				arr[arr.length-1]=temp;
				count++;
			}
			else {
				
				
			}
		}
		
	}
	
}
