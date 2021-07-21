package por;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
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
	    	Check(N,M,br.readLine().split(" "));
	    	
	    }
		
	}
	
	public static void Check(int N,int M,String []str) {
		System.out.println("N:"+N+" M:"+M);
		M=Integer.parseInt(str[M]);
		/*int[]arr=Stream.of(str).mapToInt(s->Integer.parseInt(s)).toArray();
		Queue<Integer>queue=new LinkedList<>(Arrays.asList(arr));
		*/
		
		Queue<Integer>queue=new LinkedList<>();
		for(String s:str) {
			queue.add(Integer.parseInt(s));
		}
		int max=Collections.max(queue);

		int count=1;
		while(!(queue.peek()>max && queue.peek()==M)) {
			System.out.println("peek():"+queue.peek());
			if(queue.peek()==max) {
				count++;
				System.out.println("poll:"+queue.poll()+"===================");
				max=Collections.max(queue);
				System.out.println("changed max:"+max);
				continue;
			}
			
			queue.add(queue.poll());
		}
		
		System.out.println(count);
		
	}
	
}
