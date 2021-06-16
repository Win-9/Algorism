import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int num=Integer.parseInt(br.readLine());
	    String[]str=br.readLine().split(" ");
	    
	    int[]sec_arr=new int[str.length];
	    for(int i=0;i<sec_arr.length;i++) {
	    	sec_arr[i]=Integer.parseInt(str[i]);
	    }
	    int sum=0;
	    Arrays.sort(sec_arr);
	    for(int i=0;i<sec_arr.length;i++) {
	    	for(int j=0;j<=i;j++) {
	    		sum+=sec_arr[j];
	    	}
	    }
	    System.out.println(sum);
	    
	}
}
