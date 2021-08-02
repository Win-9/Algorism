package por;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class bj {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[]str=br.readLine().split(" ");
	    Deque<Integer>queue=new LinkedList<>();
	    int N=Integer.parseInt(str[0]);
	    int M=Integer.parseInt(str[1]);
	    
	    ArrayList<Integer>list=new ArrayList(Arrays.asList(Stream.of(br.readLine().split(" "))
	    		.mapToInt(s->Integer.parseInt(s))
	    		.toArray()));
	    int count=0;//2,9,5
    	for(int i=N;i>0;i--) {
    		queue.add(i);
    	}
 
    	while(list.size()!=0) {
    		if(list.get(0)==queue.peekLast()) {
    			queue.pollLast();
    			list.remove(0);
    		}
    		if(list.get(0)<queue.size()/2) {
    			queue.addFirst((queue.pollLast()));
    			count++;
    		}
    		else if(list.get(0)>=queue.size()/2) {
    			queue.addLast((queue.pollFirst()));
    			count++;
    		}
    	}
    	
    	System.out.println(count);
	}

	
}
