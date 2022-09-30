import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<Integer> list = Arrays.stream(br.readLine().split(" "))
				.map(a -> Integer.parseInt(a))
				.collect(Collectors.toList());
		
		Collections.sort(list);
		System.out.println(list.get(1));
		
		
	}
}
