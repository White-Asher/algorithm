/* one-pass
제목 : 문자열 내림차순으로 배치하기
알고리즘 유형 : #자료구조 , #hashset 
플랫폼 : #Programmers 
난이도 : L1
문제번호 : 12917
시간 : -
해결 : O
중요 : X
해결언어 : java
문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12917
특이사항 : - 
*/

import java.util.Arrays;
import java.util.Collections;

class Solution {
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