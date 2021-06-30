import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    LinkedList<Group>list=new LinkedList<Group>();
	    int result=0;
	    int N=Integer.parseInt(br.readLine());
	    boolean[]visited=new boolean[N];
	    for(int i=0;i<N;i++) {
	    	String[]str=br.readLine().split(" ");
	    	list.add(new Group(Integer.parseInt(str[0]),Integer.parseInt(str[1]),i));
	    }  
	    Collections.sort(list);
	    for(Group g1:list) {
	    	if(visited[g1.num]) {continue;}
	    	visited[g1.num]=true;
	    	result++;
	    	Iterator<Group>iter=list.iterator();
	    			    
	    	while(iter.hasNext()) {
	    		Group g2=iter.next();
	    		if(!visited[g2.num] && g1.T==g2.S) {
	    			visited[g2.num]=true;
	    			g1=g2;
	    			continue;
	    		}
	    	}
	    }
	    
	    System.out.println(result);
	    
	}
}

class Group implements Comparable<Group>{
	int S;
	int T;
	int num;
	public Group(int S,int T,int num) {
		// TODO Auto-generated constructor stub
		this.S=S;
		this.T=T;
		this.num=num;
	}
	
	@Override
	public int compareTo(Group o) {
		// TODO Auto-generated method stub
		return this.S>o.S?1:-1;
	}

}
