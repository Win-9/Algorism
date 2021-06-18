package por;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class bj {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[]str=br.readLine().split(" ");
	    int N=Integer.parseInt(str[0]);
	    int K=Integer.parseInt(str[1]);
	    PriorityQueue<Jam>queue=new PriorityQueue<Jam>();
	    int[]bag=new int[K];
	    boolean[]bag_visited=new boolean[K];
	    long result=0;
	    for(int i=0;i<N;i++) {
	    	str=br.readLine().split(" ");
	    	queue.add(new Jam(Integer.parseInt(str[0]),Integer.parseInt(str[1])));
	    }	    
	    
	    for(int i=0;i<K;i++) {
	    	bag[i]=Integer.parseInt(br.readLine());
	    }
	  
	    Arrays.sort(bag);//오름
	    
	    while(!queue.isEmpty()) {
	    	Jam val=queue.poll();
	    	for(int i=0;i<K;i++) {
	    		if(bag[i]>=val.M && !bag_visited[i]) {
	    			bag_visited[i]=true;
	    			result+=val.V;
	    			break;
	    		}
	    	}
	    }
	    System.out.println("Result:"+result);
	}
}

class Jam implements Comparable<Jam>{
	int M;
	int V;
	
	public Jam(int M,int V){
		this.M=M;
		this.V=V;
	}

	@Override
	public int compareTo(Jam o) {
		// TODO Auto-generated method stub
		return this.V>o.V?-1:1;
	}
	

}
