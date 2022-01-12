import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int[] buff;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		int result = Integer.parseInt(br.readLine());
		int count = 0;
		int i = 0;
		
		while (st.hasMoreTokens()) {
			arr[i++] = Integer.parseInt(st.nextToken());
		}
		
		mergeSort(arr, N);
		
		for (int k = 0; k < N ; k++) {
			if(binarySearch(arr, result - arr[k]))
				count++;
		}
		
		System.out.println(count/2);

	}

	static void mergeSort(int[] arr, int N) {
		buff = new int[N];
		mergeSorting(arr, 0, N-1);
		buff = null;
	}

	static void mergeSorting(int[] arr, int left, int right) {
		if (left < right) {
			int i = 0;
			int j = 0;
			int center = (left + right) / 2;
			int k = left;
			int p = 0;
			mergeSorting(arr, left, center);
			mergeSorting(arr, center + 1, right);

			for (i = left; i <= center; i++) {
				buff[p++] = arr[i];
			}
			
			while (i <= right && j < p) {
				arr[k++] = buff[j] < arr[i] ? buff[j++] : arr[i++];
			}
			
			while (j < p) {
				arr[k++] = buff[j++];
			}

		}
	}
	
	static boolean binarySearch(int[] arr, int key) {
		int pl = 0;
		int pr = arr.length -1;
		
		while(pl <= pr) {
			int pc = (pl + pr)/2;
			
			if (key == arr[pc]) {
				return true;
			}
			
			if (key < arr[pc]) {
				pr = pc - 1;
			}
			else if (key > arr[pc]) {
				pl = pc + 1;
			}
		}
		
		return false;
	}

}
