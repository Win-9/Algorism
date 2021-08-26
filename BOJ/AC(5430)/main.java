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
	static boolean check=true;
	static boolean reverse=false;
	static StringBuilder result=new StringBuilder();
	static StringBuilder ex=new StringBuilder();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int T=Integer.parseInt(br.readLine());
	    for(int i=0;i<T;i++) {
		    Deque<String>queue=new LinkedList<>();
		    StringBuilder str=new StringBuilder(br.readLine());
		    int N=Integer.parseInt(br.readLine());
		    String []temp = br.readLine().replace("[", "").replace("]", "").split(",");
		    
		    Stream.of(temp).forEach(s->queue.add(s.toString()));
		    
		    func1(queue,str);
		    print(queue);
	    }
	    System.out.println(result);
	}
	
	public static void func1(Deque<String>queue,StringBuilder str) {
		Loop1:
		for(int i=0;i<str.length();i++) {
			switch(str.charAt(i)) {
			case 'R':
				reverse=(!reverse);
				break;
			case 'D':
				if(queue.size()==0) {
					check=false;
					break Loop1;
				}
				
				if(reverse==true) {
					queue.removeLast();
				}
				else {
					queue.removeFirst();
				}
				break;
			}
		}
	}
	
	public static void print(Deque<String>queue) {
		if(check=false) {
			ex.append("error\n");
		}
		else {
			ex.append("[");
			Iterator<String>iterator=queue.iterator();
			
			while(iterator.hasNext()) {
				String iter=iterator.next();
				ex.append(iter+",");
			}
			ex.delete(ex.length()-1, ex.length());
			ex.append("]\n");
		}
		
		
		result.append(ex);
		ex.setLength(0);
		reverse=false;
		check=true;
	}
	
}
