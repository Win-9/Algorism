import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb=new StringBuilder();
	    String str=" ";
	    while(true) {
	    	str=br.readLine();
	    	if(str.charAt(0)=='.') break;
	    	
	    	if(Check(str)) {
	    		sb.append("yes\n");
	    	}
	    	else {
	    		sb.append("no\n");
	    	}
	    }
	    System.out.println(sb);
	}
	public static boolean Check(String str) {
	    Stack<Character>stack=new Stack<Character>();
	    ArrayList<Character>list=new ArrayList<Character>();
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='('|| str.charAt(i)=='[' || str.charAt(i)=='{') {
				stack.push(str.charAt(i));
			}
			else{
				switch(str.charAt(i)) {
				case ')':
					if(!stack.isEmpty() && stack.peek()=='(') {
						stack.pop();
						break;
					}
					list.add(')');
					break;
				case ']':
					if(!stack.isEmpty() && stack.peek()=='[') {
						stack.pop();
						break;
					}
					list.add(']');
					break;
					
				case '}':
					if(!stack.isEmpty() && stack.peek()=='{') {
						stack.pop();
						break;
					}
					list.add('}');
					break;
				default:
					continue;
				}
					
			}
		}		
		return stack.isEmpty() && list.isEmpty() ?true:false;
		
		
	}
	
}
