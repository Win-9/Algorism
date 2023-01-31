import java.lang.*;
import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int result = 0;
		List<Integer> list = new ArrayList<>();
		for (int elem : ingredient) {
			list.add(elem);
            if (list.size() >= 4) {
                if (list.get(list.size() - 4) == 1 && list.get(list.size() - 3) == 2 
                    && list.get(list.size() - 2) == 3 && list.get(list.size() - 1) == 1) {
                    result++;
                    list.remove(list.size() - 1);
                    list.remove(list.size() - 1);
                    list.remove(list.size() - 1);
                    list.remove(list.size() - 1);
                }
            }
		}
		return result;
    }
}
