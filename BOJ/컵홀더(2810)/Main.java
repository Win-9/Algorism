import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N=Integer.parseInt(br.readLine());
	    String str=br.readLine();
	    boolean[]visited=new boolean[N+1];
	    int count_visited=0;
	    int result=0;
	    for(int i=0;i<N;i++) {
	    	char now=str.charAt(i);
	    	switch(now) {
	    	case'S':
	    		if(visited[count_visited]==true) {
	    			visited[++count_visited]=true;
	    			break;
	    		}
	    		visited[count_visited]=true;
	    		count_visited++;
	    		break;
	    	case'L':
	    		i++;
	    		if(visited[count_visited]==true) {
	    			count_visited+=2;
		    		visited[count_visited]=true;
		    		break;
	    		}
	    		visited[count_visited]=true;
	    		count_visited+=2;
	    		visited[count_visited]=true;
	    		break;
	    	}
	    	
	    	
	    }
	    
	    for(int i=0;i<visited.length;i++) {
	    	if(visited[i]) result++;
	    }
	    System.out.println(result);
	    
	    
	}
}
