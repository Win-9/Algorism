package por;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class bj {
	static int count=0;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int T=Integer.parseInt(br.readLine());
	    StringTokenizer st;
	    StringBuilder sb=new StringBuilder();
	    StringBuilder ex;//[1,2,3,4]
	    for(int i=0;i<T;i++) {
		    String str=br.readLine();
		    int N=Integer.parseInt(br.readLine());
		    st=new StringTokenizer(br.readLine(),"[]");
		    Stream.of(st).filter(s->!s.equals(",")).forEach(s->sb.append(s));
		    
		    System.out.println("sb:"+sb);
		    func1(sb,str);
		    print(sb);
	    }	
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st=new StringTokenizer(br.readLine(),"[]");
		System.out.println("st:"+st);
		
	    StringBuilder sb=new StringBuilder();
	    for(int i=0;i<4;i++) {
	    	sb.append(Integer.parseInt(st.nextToken()));
	    }
	    
		
	    System.out.println(sb);
	}
	
	public static void func1(StringBuilder sb,String str) {
		Loop1:
		for(int i=0;i<str.length();i++) {
			switch(str.charAt(i)) {
			case 'R':
				sb.reverse();
				break;
			case 'D':
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
