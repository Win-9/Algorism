import java.io.*;
import java.util.*;

public class Main {
  //static List<Integer>list = new ArrayList<>();
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			arr = new int[num + 1];
			func(num);
		}
		
	}
	
	static void func(int num) {
		// TODO Auto-generated method stub
		if (num == 1) {
			System.out.println(1);
			return;
		}
		
		if (num == 2) {
			System.out.println(2);
			return;
		}
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;

		for(int i = 4; i <= num; i++) {
			arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
		}
		
		System.out.println(arr[num]);
	}
  
  static void func2(int num) {
		// TODO Auto-generated method stub
		
		if (list.size() >= num) {
			System.out.println(list.get(num - 1));
			return;
		}

		for (int i = list.size(); i <= num; i++) {
			list.add(list.get(i - 1) + list.get(i - 2) + list.get(i - 3));
		}

		System.out.println(list.get(num - 1));
	}

}
