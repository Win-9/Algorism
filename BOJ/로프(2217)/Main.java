import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int num=Integer.parseInt(br.readLine());
	    int[]re_arr=new int[num];
	    for(int i=0;i<num;i++) {
	    	re_arr[i]=Integer.parseInt(br.readLine());
	    }
	    Arrays.sort(re_arr);
	    int result=0;
	    for(int i=0;i<num;i++) {
	    	int count=0;
	    	int sum=0;
	    	for(int j=0;j<i;j++) {
	    		if(re_arr[i]==re_arr[j]) {
	    			count+=1;
	    		}
	    	}
	    	sum+=(re_arr[i]*count);
	    	for(int k=i;k<num;k++) {
	    		sum+=re_arr[i];
	    	}
            
	    	if(result<sum) {
	    		result=sum;
	    	}
	    	
	    }
	    System.out.println(result);
	    
	}
}
