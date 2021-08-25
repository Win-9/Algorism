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
	static StringBuilder result=new StringBuilder();
	static StringBuilder ex=new StringBuilder();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int T=Integer.parseInt(br.readLine());
	    Deque<String>queue=new LinkedList<>();
	    for(int i=0;i<T;i++) {
		    StringBuilder sb=new StringBuilder();
		    StringBuilder str=new StringBuilder(br.readLine());
		    int N=Integer.parseInt(br.readLine());
		    String []temp = br.readLine().replace("[", "").replace("]", "").split(",");
		    
		    Stream.of(temp).forEach(s->queue.add(s.toString()));
		    func1(queue,str);
		    print(queue);
	    }
	}
	
	public static void func1(Deque<String>queue,StringBuilder str) {
		boolean reverse=false;
		Loop1:
		for(int i=0;i<str.length();i++) {
			switch(str.charAt(i)) {
			case 'R':
				reverse=(!reverse);
				break;
			case 'D':
				if(queue.size()==0) {
					break Loop1;
				}
				
				if(reverse==true) {
					queue.removeLast();
				}
				else {
					queue.remove();
				}
				break;
			}
		}
	}
	
	public static void print(Deque<String>queue) {
		if(queue.size()==0) {
			result.append("error\n");
		}
		else {
			result.append("[");
			for(int i=0;i<queue.size()-1;i++) {
				ex.append(queue.remove()+",");
			}
			result.append("]\n");
		}
		
		System.out.println(result);
		result=new StringBuilder();
	}
	
}
