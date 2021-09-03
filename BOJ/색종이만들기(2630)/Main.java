package por;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class bj {
	static int[][]map;
	static int white=0;
	static int blue=0;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N=Integer.parseInt(br.readLine());
	    map=new int[N][N];
	    for(int i=0;i<N;i++) {
	    	String[]str=br.readLine().split(" ");
	    	for(int j=0;j<N;j++) {
	    		map[i][j]=Integer.parseInt(str[j]);
	    	}
	    }
	    merge(0,0,N);
	    System.out.print(white+"\n"+blue);
	}
	
	public static void merge(int x,int y,int N) {
		int sum=0;
		
		if(N==1) {
			if(map[x][y]==1) {
				blue++;
			}
			else {
				white++;
			}
			return;
		}
		
		for(int i=x;i<x+N;i++) {
			for(int j=y;j<y+N;j++) {
				sum+=map[i][j];
			}
		}
		
		if(sum==N*N) {
			blue++;
		}
		else if(sum==0) {
			white++;
		}
		else {
			merge(x,y,N/2);
			merge(x+N/2,y,N/2);
			merge(x,y+N/2,N/2);
			merge(x+N/2,y+N/2,N/2);
		}
	}
}
