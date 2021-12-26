import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		quickSort(arr, 0, N-1);
		for (int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void quickSort(int[] arr, int left, int right) {
		int pl = left;
		int pr = right;
		int x = arr[(left + right) / 2];

		while (pl <= pr) {
			while (arr[pl] < x)
				pl++;
			while (arr[pr] > x) pr--;
			
			if(pl<=pr) {
				swap(arr, pl++, pr--);
			}
		}
		
		if(left < pr) quickSort(arr, left, pr);
		if(right > pl) quickSort(arr, pl, right);
	}

	public static void swap(int[] arr, int idx1, int idx2) {
		int tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	}

}
