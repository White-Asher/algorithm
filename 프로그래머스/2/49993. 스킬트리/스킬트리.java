/*
제목 : 스킬트리
알고리즘 유형 : #string
플랫폼 : #Programmers 
난이도 : L2
문제번호 : 49993
시간 : 30
해결 : X
저장 : O
해결언어 : java
문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/49993#fn1
특이사항 : #Summer/Winter Coding(~2018)
*/

import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        int answer = 0;
        
        for (int i = 0; i < skill_trees.length; i++) {
            String str = skill_trees[i];
            for (int j = 0; j < skill_trees[i].length(); j++) {
                String st = String.valueOf(str.charAt(j));
                if (!skill.contains(st)) {
                    str = str.replace(st, " ");
                }
            }
            
            str = str.replace(" ", "");
            if (skill.indexOf(str) == 0) {
                    answer++;
            }
        }
        return answer;
    }
}