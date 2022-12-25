import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		int count = 0;
		int len = 1;
		int tmp = 10;
		for(int i = 1; i <= number; i++) {
			if (i == tmp) {
				tmp *= 10;
				len++;
			}
			count += len;
		}
		
		System.out.println(count);
    }
	

}
