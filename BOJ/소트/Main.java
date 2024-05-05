import java.lang.*;
import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int[] arr = new int[N + 1];
        str = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        int S = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            int maxIndex = N;
            for (int j = i + 1; j < N; j++) {
                if (arr[i] < arr[j] && j - i <= S) {
                    if (arr[maxIndex] < arr[j]) {
                        maxIndex = j;
                    }
                }
            }

            if (maxIndex != N) {
                S -= maxIndex - i;
                swap(arr, maxIndex, i);
            }

        }

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    static void swap(int[] arr, int firstIndex, int secondIndex) {
        int tmp = arr[firstIndex];
        for (int i = firstIndex - 1; i >= secondIndex ; i--) {
            arr[i + 1] = arr[i];
        }
        arr[secondIndex] = tmp;
    }
}
