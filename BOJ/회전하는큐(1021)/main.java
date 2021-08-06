import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
	static int count=0;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[]str=br.readLine().split(" ");
	    ArrayList<Integer>queue=new ArrayList<>();
	    int N=Integer.parseInt(str[0]);
	    int M=Integer.parseInt(str[1]);
	    int[]arr=Stream.of(br.readLine().split(" "))
	    		.mapToInt(s->Integer.parseInt(s))
	    		.toArray();

	    int idx=0;

    	for(int i=1;i<=N;i++) {
    		queue.add(i);
    	} 
    	while(idx!=arr.length) {

    		if(arr[idx]==queue.get(0)) {
    			queue.remove(0);
    			++idx;
    			continue;
    		}

    		if(queue.indexOf(arr[idx])<=queue.size()/2) {
    			queue.add(queue.remove(0));
    			count++;
    		}
    		
    		else {
    			queue.add(0,queue.remove(queue.size()-1));
    			count++;
    		}
    	}
    	System.out.println(count);
	}
	
}
