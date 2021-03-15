package por;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Main {
	public static void main(String[]args) throws IOException{
		Solution s=new Solution();
		Solution1 s1=new Solution1();
		int n=5;
		int[]arr= {2,3,4};
		int[]arr2={1,2,3};
		int[]a= {10,1,10,2,1};
		System.out.println(s.solution());
		System.out.println(s.solution(5,arr,arr2));
	}
}
class Solution1{
	public int solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[]str=br.readLine().split("");
		int end=Integer.parseInt(str[2]);
		int start=Integer.parseInt(str[1]);
		int up=Integer.parseInt(str[3]);int down=Integer.parseInt(str[4]);
		LinkedList<Integer>[]list=new LinkedList[2];
		for(int i=0;i<2;i++) {
			list[i]=new LinkedList<Integer>();
		}
		dfs();
	}
	public void dfs() {
		Queue<Integer>queue=new LinkedList<>();
		while(queue.size()!=0) {
			int a=queue.poll();
		}
	}
}
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer=(n-lost.length);
        boolean[]visited=new boolean[reserve.length];
        boolean[]visited1=new boolean[lost.length];
        for(int i=0;i<lost.length;i++){
            int ex1=lost[i];
            for(int j=0;j<reserve.length;j++){
            	if(ex1==reserve[j]) {
            		visited[j]=true;
            		visited1[i]=true;
            		System.out.println("same:"+ex1);
            		++answer;
            		break;
            	}
            }
        }
        for(int i=0;i<lost.length;i++){
            int ex1=lost[i];
            int a=ex1-1;
            int b=ex1+1;
            for(int j=0;j<reserve.length;j++){
                if((b==reserve[j] && !visited[j] && !visited1[i])){
                	System.out.println("ex1:"+ex1);
                	System.out.println("b:"+b);
                    visited[j]=true;
                    visited1[i]=true;
                    ++answer;
                    break;
                }
                else if((a==reserve[j] && !visited[j] && !visited1[i])) {
                	System.out.println("ex1:"+ex1);
                	System.out.println("a:"+a);
                    visited[j]=true;
                    visited1[1]=true;
                    ++answer;
                    break;
                }
            }
        }
        return answer;
    }
}