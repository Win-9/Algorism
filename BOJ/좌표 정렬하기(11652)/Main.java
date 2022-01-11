import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	static Location[] buff;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Location[] loc = new Location[N];

		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			loc[i] = new Location(Integer.parseInt(str[0]), 
					Integer.parseInt(str[1]));
		}
		

		merge(loc, N);

		for (int i = 0; i < N; i++) {
			System.out.println(loc[i].x+" "+loc[i].y);
		}
	}

	static void merge(Location[] loc, int N) {
		buff = new Location[N];

		merge_sort(loc, 0, N - 1);
		buff = null;
	}

	static void merge_sort(Location[] loc, int left, int right) {
		if (left < right) {
			int p = 0;
			int j = 0;
			int i;
			int k = left;
			int center = (left + right) / 2;

			merge_sort(loc, left, center);
			merge_sort(loc, center + 1, right);

			for (i = left; i <= center; i++) {
				buff[p++] = loc[i];
			}

			while (i <= right && j < p) {
				loc[k++] = compare(buff[j], loc[i]) ? buff[j++] : loc[i++];
			}

			while (j < p) {
				loc[k++] = buff[j++];
			}

		}
	}

	static boolean compare(Location loc1, Location loc2) {
		if (loc1.x < loc2.x) {
			return true;
		}

		if (loc1.x == loc2.x) {
			if (loc1.y < loc2.y) {
				return true;
			}
		}

		return false;
	}

}

class Location {
	int x;
	int y;

	public Location(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
}
