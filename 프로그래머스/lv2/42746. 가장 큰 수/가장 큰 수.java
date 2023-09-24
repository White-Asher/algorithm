import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strNumbers = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        // Array 정렬
        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
            
        if(strNumbers[0].equals("0")) return "0";
        
        return String.join("", strNumbers);
    }
}

/** 잘못 이해한 풀이 */
// class Solution {
//     public String solution(int[] numbers) {
        
//         List<Integer> list = new ArrayList<>();
//         for(int i = 0; i < numbers.length; i++) {
//             String[] str = String.valueOf(numbers[i]).split("");
//             for(int j = 0; j < str.length; j++) {
//                 // System.out.println(Integer.parseInt(str[j]));
//                 list.add(Integer.parseInt(str[j]));
//             }
//         }
        
        
//         Collections.sort(list);
//         StringBuilder sb = new StringBuilder();
//         String s = "";
//         for(int i = list.size()-1; i >= 0; i--) {
//             System.out.println(list.get(i));
//             s = s + String.valueOf(list.get(i));
//         }
        
        
//         return s;
//     }
// }