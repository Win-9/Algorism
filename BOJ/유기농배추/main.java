import java.util.*;
import java.io.*;
class Main {
static Location loc;
static int []x_loc={-1,1,0,0};
static int []y_loc={0,0,1,-1};
static int count=0;
public static void main(String[] args) throws Exception {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
ArrayList<Integer>list= new ArrayList<>();
boolean[][] visited;
int[][] mma;
int all=Integer.parseInt(br.readLine());
for(int ss=0;ss<all;ss++){
String []str=br.readLine().split(" ");
int n =Integer.parseInt(str[0]);
System.out.println("n:"+n);
int m = Integer.parseInt(str[1]);
System.out.println("m:"+m);
int number=Integer.parseInt(str[2]);
System.out.println("number:"+number);
mma = new int[n][m];
visited = new boolean[n][m];
for(int s=0;s<number;s++){
String []num1= br.readLine().split(" ");
mma[Integer.parseInt(num1[0])][Integer.parseInt(num1[1])] = 1;
}
for(int i=0;i<n;i++) {
       for(int j=0;j<m;j++) {
         if(!visited[i][j] && mma[i][j]==1){
bfs(visited,mma,i,j);
++count;
}
       }
     }
list.add(count);
count=0;
}
for(int i=0;i<list.size();i++){
System.out.println(list.get(i));
}
}
static public void bfs(boolean[][]visited,int[][]mma,int i,int j){
Queue<Location>queue=new LinkedList<>();
queue.add(new Location(i,j));
while(queue.size()!=0){
loc=queue.poll();
visited[loc.x][loc.y]=true;
for(int k=0;k<4;k++){
int ex1=loc.x+x_loc[k];
int ex2=loc.y+y_loc[k];
if(check(ex1,ex2,mma,visited)){
queue.add(new Location(ex1, ex2));
}
}
}
}
static public boolean check(int ex1,int ex2,int[][]mma,boolean [][]visited){
if((ex1>=0 && ex1<mma.length) && (ex2>=0 && ex2<mma[0].length)){
if(!visited[ex1][ex2] && mma[ex1][ex2]==1){
visited[ex1][ex2]=true;
return true;
}
}
return false;
}
}
class Location{
int x;
int y;
Location(int x,int y){
this.x=x;
this.y=y;
}
}
