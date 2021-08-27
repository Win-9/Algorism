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

public class Main {
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
		    
		    if(N==0 && str.charAt(0)=='D') {
		    	result.append("error\n");
		    	continue;
		    }
		    
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
		if(check==false) {
			result.append("error\n");
		}
		else {
			if(reverse==true) {
				result.append("[");
				while(queue.size()>=1) {
					if(queue.size()==1) {
						result.append(queue.removeLast()+"\n");
						break;
					}
					result.append(queue.removeLast()+",");
				}
				result.append("]");
			}
			else {
				result.append("[");
				while(queue.size()>=1) {
					if(queue.size()==1) {
						result.append(queue.removeFirst()+"\n");
						break;
					}
					result.append(queue.removeFirst()+",");
				}
				result.append("]");
			}
		}
		reverse=false;
		check=true;
	}
	
}
