import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        List<Integer> positiveList = new ArrayList<>();
        List<Integer> negativeList = new ArrayList<>();
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int answer = 0;

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < N; i++) {
            if (arr[i] < 0) {
                negativeList.add(Math.abs(arr[i]));
            } else {
                positiveList.add(arr[i]);
            }
        }

        Collections.sort(positiveList, Collections.reverseOrder());
        Collections.sort(negativeList, Collections.reverseOrder());
        int pIndex = 0;
        int nIndex = 0;

        if (positiveList.isEmpty()) {
            answer += negativeList.get(nIndex);
        } else if (negativeList.isEmpty()) {
            answer += positiveList.get(pIndex);
        } else if (positiveList.get(pIndex) > negativeList.get(nIndex)) {
            answer += positiveList.get(pIndex);
            answer += 2 * negativeList.get(nIndex);
        } else {
            answer += negativeList.get(nIndex);
            answer += 2 * positiveList.get(pIndex);
        }


        pIndex += M;
        nIndex += M;

        for (int i = pIndex; i < positiveList.size(); i += M) {
            answer += 2 * positiveList.get(i);
        }

        for (int i = nIndex; i < negativeList.size(); i += M) {
            answer += 2 * negativeList.get(i);
        }

        System.out.println(answer);

    }
}
