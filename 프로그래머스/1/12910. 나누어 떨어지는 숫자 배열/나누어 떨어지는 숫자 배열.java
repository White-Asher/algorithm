/* one-pass */

import java.util.*;

class Solution {
    public List<?> solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        for (int a : arr) {
            if (a % divisor == 0) {
                list.add(a);
            }
        }
        if(list.size() == 0) {
            list.add(-1);
        }
        Collections.sort(list);
        return list;
    }
}