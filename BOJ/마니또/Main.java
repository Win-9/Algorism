import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = 1;
        while(true) {
            int N = Integer.parseInt(br.readLine());
            int count = 0;
            if (N == 0) {
                break;
            }

            Map<String, String> map = new HashMap<>();
            String[] keyArr = new String[N];
            for(int i = 0; i < N; i++) {
                String[] str = br.readLine().split(" ");
                map.put(str[0], str[1]);
                keyArr[i] = str[0];
            }

            for(String st : keyArr) {            
                List<String> keyList = new ArrayList<>();
                String value = map.get(st);
                keyList.add(st);
                while(true) {
                    keyList.add(value);
                    value = map.get(value);
                    if (value == null) {
                        break;
                    }

                    if (value.equals(st)) {
                        count++;
                        for(String key : keyList) {
                            map.remove(key);
                        }
                        break;
                    }

                }
            }

            System.out.println(caseNum + " " + count);
            caseNum++;
        }
    }
}
