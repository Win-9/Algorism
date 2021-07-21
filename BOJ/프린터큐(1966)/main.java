import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int number=Integer.parseInt(br.readLine());
	    String[]str;
	    StringBuilder sb= new StringBuilder();
	    for(int i=0;i<number;i++) {
	    	str=br.readLine().split(" ");
	    	int N=Integer.parseInt(str[0]);
	    	int M=Integer.parseInt(str[1]);
	    	sb.append(Check(N,M,br.readLine().split(" "))+"\n");
	    	
	    }
	    System.out.println(sb);
		
	}
	
	public static int Check(int N,int M,String []str) {		
		Queue<Node>queue=new LinkedList<>();
		for(int k=0;k<str.length;k++) {
			queue.add(new Node(k,Integer.parseInt(str[k])));
		}

		
		int max=queue.stream().mapToInt(s-> s.getImportance()).max().getAsInt();
		int count=1;
		while(!(queue.peek().index==M && queue.peek().importance>=max)) {
			if(queue.peek().importance==max) {
				count++;
				max=queue.stream().mapToInt(s-> s.getImportance()).max().getAsInt();
				continue;
			}
			
			queue.add(queue.poll());
		}
		
		return count;
		
	}
	
}

class Node{
	int index;
	int importance;
	
	public Node(int index, int importance) {
		// TODO Auto-generated constructor stub
		this.index=index;
		this.importance=importance;
	}
	
	public int getIndex() {
		return index;
	}
	
	public int getImportance() {
		return importance;
	}
	
}
