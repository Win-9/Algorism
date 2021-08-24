package por;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class bj {
	static int number=0;
	static int []sorted;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N=Integer.parseInt(br.readLine());
	    String[]str=br.readLine().split(" ");
	    int[]number=Stream.of(str).mapToInt(s->Integer.parseInt(s)).toArray();
	    int people=Integer.parseInt(br.readLine());
	    sorted=new int[str.length];
	    
	    mergeSort(number,0,N,people);
	    
	    for(int i=0;i<N;i++) {
	    	System.out.print(number[i]+" ");
	    }
	}
	
	public static void merge(int[]arr,int low,int middle,int high) {
		int i=low;
		int j=middle;
		
		int k=low;
		
		while(i<=middle && j<=high) {
			if(arr[i]<arr[j]) {
				sorted[k]=arr[i];
				i++;
			}
			else {
				sorted[k]=arr[j];
				j++;
			}
			k++;
		}
		
		if(i>middle) {
			for(int t=j;t<=high;t++) {
				sorted[k]=arr[t];
				k++;
			}
		}
		else {
			for(int t=i;t<=middle;t++) {
				sorted[k]=arr[t];
				k++;
			}
		}
		
		for(int t=0;t<=high;t++) {
			arr[t]=sorted[t];
		}
		
	}
	
	public static void mergeSort(int[]arr,int n,int m,int people) {
		int middle=(n+m)/2;
		if(n<m && people!=middle) {
			mergeSort(arr,n,middle,people);
			mergeSort(arr,middle+1,m,people);
			merge(arr,n,middle,m);
		}
	}
	
}
