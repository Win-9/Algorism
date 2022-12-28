import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<StringBuilder> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			list.add(new StringBuilder(br.readLine()));
		}
		
		int deleteNum = list.get(0).length() - 1;
		while(true) {
			List<String> subStrList = new ArrayList<>();

			for(int i = 0; i < list.size(); i++) {
				subStrList.add(list.get(i).substring(deleteNum));
			}
			
			if (subStrList.size() == subStrList.stream().distinct().collect(Collectors.toList()).size()) {
				System.out.println(list.get(0).length() - deleteNum);
				return;
			}
			deleteNum--;

		}
		
    }

}
