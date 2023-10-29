import java.lang.*;
import java.util.*;
import java.io.*;

class Main {
    static List<List<Integer>> list = new ArrayList<>();
    static int K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        for(int i = 0; i < K; i++) {
            list.add(new ArrayList<>());
        }
        
        search(numbers, 0, numbers.length, 0);
        
        for(List<Integer> treeList : list) {
            for(int a : treeList) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
        
    }
    
    static void search(int[] numbers, int start, int end,int depth) {
        int mid = (start + end) / 2;
        if (depth == K) {
            return;
        }
        
        list.get(depth).add(numbers[mid]);        
        search(numbers, start, mid - 1, depth + 1);
        search(numbers, mid + 1, end, depth + 1);
    }
}
