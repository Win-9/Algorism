import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x1 = arr[0];
            int y1 = arr[1];
            int r1 = arr[2];
            int x2 = arr[3];
            int y2 = arr[4];
            int r2 = arr[5];
            System.out.println(getLocation(x1, y1, r1, x2, y2, r2));
        }
        
    }
    
    static int getLocation(int x1, int y1, int r1, int x2, int y2, int r2) {
        int distance = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        
        if(x1 == x2 && y1 == y2 && r1 == r2) {    // 두 원이 일치 시
			return -1;
		} else if(distance > Math.pow(r1 + r2, 2)) {    // 외부에서 반지름 합이 짧을 때
			return 0;
		} else if(distance < Math.pow(r2 - r1, 2)) {    // 내부에서 반지름이 더 길 때 
			return 0;
		} else if(distance == Math.pow(r2 - r1, 2)) {    // 내접 시
			return 1;
		} else if(distance == Math.pow(r1 + r2, 2)) {    // 외접 시
			return 1;
		} else {
			return 2;
		}
        
    }
}
