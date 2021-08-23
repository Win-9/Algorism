package por;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj {
	static int white=0;
	static int blue=0;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N=Integer.parseInt(br.readLine());
	    int[][]map=new int[N][N];
	    for(int i=0;i<N;i++) {
	    	String []str=br.readLine().split(" ");
	    	for(int j=0;j<N;j++) {
	    		map[i][j]=Integer.parseInt(str[j]);
	    	}
	    }
	    
	    Find(map,0,N);
	    
	}
	public static void Find(int[][]map,int low,int high) {
		int middle,left,right;
		boolean check_left=true;
		boolean check_right=true;
		middle=(low+high)/2;
		Loop1:
		for(int i=0;i<middle;i++) {
			for(int j=0;j<middle;j++) {
				int save=map[i][j];
				if(map[i][j]!=save) {
					check_left=false;
					break Loop1;
				}
			}
		}
		if(check_left==false) {
			Find(map,low,middle);
		}
		
		Loop2:
		for(int i=middle;i<high;i++) {
			for(int j=middle;j<high;j++) {
				int save=map[i][j];
				if(map[i][j]!=save) {
					check_left=false;
					break Loop2;
				}
			}
		}
		if(check_left==false) {
			Find(map,middle,high);
		}
	}
	
}
