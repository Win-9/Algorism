import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int N=Integer.parseInt(br.readLine());
	    ArrayList<Integer>list=new ArrayList<>();
	    for(int i=0;i<N;i++) {
	    	Deque(br.readLine().split(" "),list);
	    }
		
	}
	public static void Deque(String []str,ArrayList<Integer>list) {
		
		switch(str[0]) {
		case "push_front":
			list.add(0,Integer.parseInt(str[1]));
			break;
			
		case "push_back":
			list.add(Integer.parseInt(str[1]));
			break;
			
		case "pop_front":
			if(!list.isEmpty()) {
				System.out.println(list.remove(0));
			}
			else {System.out.println("-1");}
			break;
			
		case "pop_back":
			if(!list.isEmpty()) {
				System.out.println(list.remove(list.size()-1));
			}
			else {System.out.println("-1");}
			break;
			
		case "size":
			System.out.println(list.size());
			break;
			
		case "empty":
			if(!list.isEmpty()) {
				System.out.println("0");
			}
			else {System.out.println("1");}
			break;
			
		case "front":
			if(!list.isEmpty()) {
				System.out.println(list.get(0));
			}
			else {System.out.println("-1");}
			break;
			
		case "back":
			if(!list.isEmpty()) {
				System.out.println(list.get(list.size()-1));
			}
			else {System.out.println("-1");}
			break;
		}
		
	}

	
}
