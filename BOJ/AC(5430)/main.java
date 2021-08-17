import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
	static int count=0;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int T=Integer.parseInt(br.readLine());

	    for(int i=0;i<T;i++) {
		    StringBuilder sb=new StringBuilder();
		    String str=br.readLine();
		    int N=Integer.parseInt(br.readLine());
		    String temp = br.readLine().replace("[", "").replace("]", "").replace(",", " ");
			StringTokenizer st = new StringTokenizer(temp);
		    
		    while(st.hasMoreTokens()) {
		    	sb.append(st.nextToken());
		    }
		    		    
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
				break;
			case 'D':
				if((sb.toString()).equals("")) {
					break Loop1;
				}
				sb.delete(0,1);
				break;
			}
		}
	}
	
	public static void print(StringBuilder sb) {
		if((sb.toString()).equals("")) {
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
