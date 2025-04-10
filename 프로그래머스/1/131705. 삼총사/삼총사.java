/*
제목 : 삼총사
알고리즘 유형 : 
플랫폼 : #Programmers
난이도 : L1
문제번호 : 131705
시간 : 5
해결 : O
저장 : X
해결언어 : java
문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/131705
특이사항 : X
*/

import java.util.*;

class Solution {
    public int solution(int[] number) {
        int answer = 0;
        for(int i = 0 ; i < number.length; i++) {
            for(int j = i + 1; j < number.length; j++) {
                if(j == i) continue;
                for(int k = j + 1; k < number.length; k++) {
                    if(k == j || k == i) continue;
                        if(number[i] + number[j] + number[k] == 0) answer++;
                }
            }
        }
        return answer;
    }
}