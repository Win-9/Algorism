import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] n = br.readLine().split(" ");
		int[] nArr = Arrays.stream(n)
				.mapToInt(s -> Integer.parseInt(s)).toArray();
		
		Arrays.sort(nArr);
		
		int M = Integer.parseInt(br.readLine());
		int[] mArr = Arrays.stream(br.readLine().split(" "))
				.mapToInt(s -> Integer.parseInt(s)).toArray();
		
		for (int i = 0; i < M; i++) {
			int index = binarySearch(nArr, mArr[i]);
			if(index == -1) {
				System.out.print(0+" ");
				continue;
			}
			System.out.print(findSameIndex(nArr, nArr[index] , index)+" ");
		}
	}
	
	static int findSameIndex(int[]arr, int key, int index) {
		int sum = 0;
		int pr = index;
		int pl = index;
		
		while(pl > -1 && arr[pl--] == key) {
			sum++;
		}
		
		while( pr < arr.length && arr[pr++] == key) {
			sum++;
		}
		
		return sum-1;
	}

	static int binarySearch(int[] arr, int key) {
		int pl = 0;
		int pr = arr.length - 1;
		while (pl <= pr) {
			int pc = (pl + pr) / 2;
			if (arr[pc] == key) {
				return pc;
			}

			if (arr[pc] < key) {
				pl = pc + 1;
			} else if (arr[pc] > key) {
				pr = pc - 1;
			}
		}
		
		return -1;
	}
}
