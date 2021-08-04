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
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[]str=br.readLine().split(" ");
	    Deque<Integer>queue=new LinkedList<>();
	    int N=Integer.parseInt(str[0]);
	    int M=Integer.parseInt(str[1]);
	    int[]arr=Stream.of(br.readLine().split(" "))
	    		.mapToInt(s->Integer.parseInt(s))
	    		.toArray();

	    int idx=0;

	    int count=0;//2,9,5
    	for(int i=N;i>0;i--) {
    		queue.add(i);
    	}
    	print(queue);
 
    	while(idx!=arr.length) {
    		if(arr[idx]==queue.peekLast()) {
    			queue.pollLast();
    			++idx;
    			print(queue);
    			continue;
    		}

    		if(arr[idx]<queue.size()/2) {
    			queue.addFirst((queue.pollLast()));
    			count++;
    			print(queue);

    		}
    		else if(arr[idx]>=queue.size()/2) {
    			queue.addLast((queue.pollFirst()));
    			count++;
    			print(queue);

    		}
    	}
    	
    	System.out.println(count);
	}
	
	public static void print(Deque<Integer>queue) {
		for(int i:queue) {
			System.out.print(i+" ");
		}
		System.out.println();
	}

	
}
