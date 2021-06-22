import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[]str=br.readLine().split(" ");
	    int N=Integer.parseInt(str[0]);
	    int K=Integer.parseInt(str[1]);
	    LinkedList<Jam>list=new LinkedList<>();
	    int[]bag=new int[K];
	    boolean[]bag_visited=new boolean[K];
	    long result=0;
	    for(int i=0;i<N;i++) {
	    	str=br.readLine().split(" ");
	    	list.add(new Jam(Integer.parseInt(str[0]),Integer.parseInt(str[1])));
	    }	  
	    Collections.sort(list);
	    for(int i=0;i<K;i++) {
	    	bag[i]=Integer.parseInt(br.readLine());
	    }
	    Arrays.sort(bag);//오름
	    
	    Iterator<Jam>iter=list.iterator();
	    while(iter.hasNext()) {
	    	Jam jam=iter.next();
	    	for(int j=0;j<bag.length;j++) {
	    		if(!bag_visited[j] && bag[j]>=jam.M) {
	    			bag_visited[j]=true;
	    			result+=jam.V;
	    			break;
	    		}
	    	}
	    }
	    System.out.println(result);
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
