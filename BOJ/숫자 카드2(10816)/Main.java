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
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String[] n = br.readLine().split(" ");
		int[] nArr = Arrays.stream(n)
				.mapToInt(s -> Integer.parseInt(s)).toArray();
		
		Arrays.sort(nArr);
		
		int M = Integer.parseInt(br.readLine());
		int[] mArr = Arrays.stream(br.readLine().split(" "))
				.mapToInt(s -> Integer.parseInt(s)).toArray();
		
		for (int i = 0; i < M; i++) {
			sb.append(upperBound(nArr, mArr[i])-
					lowerBound(nArr, mArr[i])+" ");
		}
		System.out.println(sb);
	}


	static int lowerBound(int[] arr, int key) {
		int lo = 0; 
		int hi = arr.length; 
	 
		while (lo < hi) {
	 
			int mid = (lo + hi) / 2;
			if (key <= arr[mid]) {
				hi = mid;
				continue;
			}
			lo = mid + 1;
	 
		}
		return lo;
	}
	 
	static int upperBound(int[] arr, int key) {
		int lo = 0; 
		int hi = arr.length; 
	 
		while (lo < hi) {
	 
			int mid = (lo + hi) / 2;
	 
			// key값이 중간 위치의 값보다 작을 경우
			if (key < arr[mid]) {
				hi = mid;
				continue;
			}
			// 중복원소의 경우 else에서 처리된다.
			lo = mid + 1;
		}
		return lo;
	}
}
