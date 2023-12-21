import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        int[] numbers = new int[b + 1];
        int sum = 0;
        int count = 0;
        int number = 1;
        int countNumber = 1;
        for(int i = 0; i <= b; i++) {
            if (count == countNumber) {
                number++;
                count = 0;
                countNumber++;
            }
            numbers[i] = number;
            count++;
        }
        
        for(int i = (a - 1); i <= (b - 1); i++) {
            sum += numbers[i];
        }
        System.out.println(sum);
    }
}
