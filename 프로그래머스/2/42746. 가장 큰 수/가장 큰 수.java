import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
            String[] str = String.valueOf(numbers[i]).split("");
            for(int j = 0; j < str.length; j++) {
                System.out.println(Integer.parseInt(str[j]));
                list.add(Integer.parseInt(str[j]));
            }
        }
        
        
        Collections.sort(list, Collections.reverseOrder());
        for(int i = 0; i < list.size(); i++) {
            // System.out.println(list.get(i));
            sb.append(list.get(i));
        }
        
        
        return sb.toString();
    }
}