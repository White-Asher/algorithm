// 프로그래머스 L1 - 문자열 내림차순 출력

package Programers.lv1.문자열내림차순출력;

import java.util.Arrays;
import java.util.Collections;

public class Programmers_L1_문자열내림차순출력 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.solution("Zbcdefg");
        System.out.println(result);
    }
}

class Solution{
    public String solution(String s) {
        String[] arrayWord = s.split("");

        String str = "";

        Arrays.sort(arrayWord, Collections.reverseOrder());

        for (int i = 0; i < arrayWord.length; i++) {
            str += arrayWord[i];
        }

        return str;
    }
}
