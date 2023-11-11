import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] aa = {1, 2, 3, 4, 5};
        int[] bb = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] cc = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int a = 0;
        int b = 0;
        int c = 0;
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == aa[i % 5]) {
                a++;
            }
            if(answers[i] == bb[i % 8]) {
                b++;
            }
            if(answers[i] == cc[i % 10]) {
                c++;
            }
        }
        int max = 0;
        
        max = Math.max(max, a);
        max = Math.max(max, b);
        max = Math.max(max, c);
        
        List<Integer> list = new ArrayList<>();
        if(max == a) {
            list.add(1);
        }
        if(max == b) {
            list.add(2);
        }
        if(max == c) {
            list.add(3);
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i< list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}