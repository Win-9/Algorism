import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Hashtable<String, Integer> hash = new Hashtable<>();
		String str = "";
		StringBuilder sb = new StringBuilder();
		int size = 0;
		while (true) {
			str = br.readLine();
			if (str == null ||str.length() == 0) {
				break;
			}
			size++;
			if (hash.containsKey(str)) {
				int num = hash.get(str);
				hash.put(str, ++num);
				continue;
			}
			hash.put(str, 1);
		}

		ArrayList<String> list = new ArrayList<>(hash.keySet());
		Collections.sort(list);

		for (String s : list) {
			sb.append(s+" ").append(String.format("%.4f", 
					(double) hash.get(s) * 100 / size)).append("\n");
		}

		System.out.println(sb);

	}

}
