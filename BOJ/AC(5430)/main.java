package por;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class bj {
	static int count=0;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int T=Integer.parseInt(br.readLine());
	    StringBuilder sb=new StringBuilder();
	    
	    for(int i=0;i<T;i++) {
		    String str=br.readLine();
		    int N=Integer.parseInt(br.readLine());
		    String[]input_arr=br.readLine().split(",");
		    Stream.of(input_arr).forEach(s->sb.append(s));

		    sb.delete(0,1);
		    sb.delete(N+1,N+2);
		    System.out.println(sb);
		    func1(sb,str);
		    print(sb);
	    }	    
	}
	
	public static void func1(StringBuilder sb,String str) {
		Loop1:
		for(int i=0;i<str.length();i++) {
			switch(str.charAt(i)) {
			case 'R':
				sb.reverse();
				System.out.print(sb);
				break;
			case 'D':
				System.out.print(sb);
				if(sb.equals("")) {
					break Loop1;
				}
				sb.delete(0,1);
				break;
			}
		}
	}
	
	public static void print(StringBuilder sb) {
		if(sb.equals("")) {
			System.out.println("error");
		}
		else {
			int i=0;
			System.out.print("[");
			for(;i<sb.length()-1;i++) {
				System.out.print(sb.charAt(i)+",");
			}
			System.out.print(sb.charAt(i)+"]");
		}
	}
	
}
