import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[]str = br.readLine().split("");
		int count = 0;
		
		while(str.length != 1) {
			int sum = 0;
			for (String string : str) {
				sum += Integer.parseInt(string);
			}
			count++;
			str = String.valueOf(sum).split("");
		}
		
		System.out.println(count);
		if (Integer.parseInt(str[0]) % 3 == 0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		
    }
	

}
