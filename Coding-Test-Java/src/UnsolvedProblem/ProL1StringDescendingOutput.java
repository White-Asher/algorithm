// 프로그래머스 L1 - 문자열 내림차순 출력

package UnsolvedProblem;

import java.util.Arrays;
import java.util.Collections;

public class ProL1StringDescendingOutput {
    public static void main(String[] args) {
        L1StringDescendingOutputSol l1StringDescendingOutputSol = new L1StringDescendingOutputSol();
        String result = l1StringDescendingOutputSol.solution("Zbcdefg");
        System.out.println(result);
    }
}

class L1StringDescendingOutputSol{
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
