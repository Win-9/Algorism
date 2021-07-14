import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = "";
		while((str=br.readLine()).compareTo(".")!=0) sb.append(balance(str));
		System.out.println(sb);
		br.close();
	}
	
	static public String balance(String str){
	    char[] stack = str.toCharArray();
	    int top = 0;
	    for(int i=0; i<stack.length; i++){
	        if(stack[i]=='(' || stack[i]=='[') stack[top++] = stack[i];
	        else if(stack[i]==')'){
	            if(top==0 || stack[top-1]!='(') return "no\n";
	            top--;
	        }
	        else if(stack[i]==']'){
	            if(top==0 || stack[top-1]!='[') return "no\n";
	            top--;
	        }
	    }
	    if(top==0) return "yes\n";
	    else return "no\n";
	}
}
