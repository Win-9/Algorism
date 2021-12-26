import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("");
		int[] arr = Arrays.stream(str).mapToInt(s -> Integer.parseInt(s)).toArray();
		quickSorting(arr, 0, arr.length-1);
		for(int a: arr) {
			System.out.print(a);
		}
	}

	public static void quickSorting(int[] arr, int left, int right) {
		int pl = left;
		int pr = right;
		int x = arr[(pl + pr) / 2];

		while (pl <= pr) {
			while (arr[pl] > x)
				pl++;
			while (arr[pr] < x)
				pr--;

			if (pl <= pr) {
				swap(arr, pl++, pr--);
			}
		}

		if (left < pl)
			quickSorting(arr, left, pr);
		if (right > pr)
			quickSorting(arr, pl, right);
	}

	public static void swap(int[] arr, int idx1, int idx2) {
		int tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	}

}
