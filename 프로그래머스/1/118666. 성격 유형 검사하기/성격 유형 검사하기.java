/*
제목 : 성격 유형 검사하기
알고리즘 유형 : #자료구조 , #hashmap 
플랫폼 : #Programmers 
난이도 : L1
문제번호 : 118666
시간 : -
해결 : X
중요 : O
해결언어 : java
문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/118666
특이사항 : 2022 KAKAO TECH INTERNSHIP
*/

import java.util.*;
import java.io.*;

class Solution {
    static StringBuilder sb = null;
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>();
        int surveyCnt = survey.length;

        for (int i = 0; i < surveyCnt; i++) {
            if (choices[i] < 4) {
                char type = survey[i].charAt(0);
                int cnt =  4 - choices[i];
                map.put(type, map.getOrDefault(type, 0) + cnt);
            } else if(choices[i] > 4) {
                char type = survey[i].charAt(1);
                int cnt = choices[i] - 4;
                map.put(type, map.getOrDefault(type, 0) + cnt);
            }
        }

        sb = new StringBuilder();
        sb.append(map.getOrDefault('R', 0) >= map.getOrDefault('T', 0) ? 'R' : 'T')
                .append(map.getOrDefault('C', 0) >= map.getOrDefault('F', 0) ? 'C' : 'F')
                .append(map.getOrDefault('J', 0) >= map.getOrDefault('M', 0) ? 'J' : 'M')
                .append(map.getOrDefault('A', 0) >= map.getOrDefault('N', 0) ? 'A' : 'N');
        return sb.toString();
    }
}