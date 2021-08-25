package por;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class bj {
	static int people;
	static int N;
	static String []sorted;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N=Integer.parseInt(br.readLine());
	    String[]str=br.readLine().split(" ");
	    people=Integer.parseInt(br.readLine());
	    sorted=new String[str.length];
	    
	    mergeSort(str,0,N-1);
	    
	    for(int i=0;i<N;i++) {
	    	System.out.print(str[i]+" ");
	    }
	}//1 5 2 4 2 9 7 3
	
	public static void merge(String[]arr,int low,int middle,int high) {
		
		if(high-low>N/people)
			return;
		
		int i=low;
		int j=middle+1;
		
		int k=low;
		
		while(i<=middle && j<=high) {
			System.out.println("arr[i]:"+arr[i]+" arr[j]:"+arr[j]);
			if(arr[i].compareTo(arr[j])<0) 
				sorted[k++]=arr[i++];
			else 
				sorted[k++]=arr[j++];
			
			System.out.println("====================");
		}
		
		while(i<=middle) {
			sorted[k++]=arr[i++];
		}
		while(j<=high) {
			sorted[k++]=arr[j++];
		}

		for(int t=0;t<=high;t++) {
			arr[t]=sorted[t];
		}
		
	}
	
	public static void mergeSort(String[]arr,int n,int m) {		
		if(n==m)
			return;
		
		int middle=(n+m)/2;
		mergeSort(arr,n,middle);
		mergeSort(arr,middle+1,m);
		merge(arr,n,middle,m);
	}
	
}
