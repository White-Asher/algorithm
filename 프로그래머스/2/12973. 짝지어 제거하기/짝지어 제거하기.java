/*
제목 : 짝지어 제거하기
알고리즘 유형 : #stack, #string 
플랫폼 : #Programmers 
난이도 : L2
문제번호 : 12973
시간 : 5
해결 : O
저장 : X
해결언어 : java
문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12973
특이사항 : -
*/

import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            String tar = String.valueOf(s.charAt(i));
            if (stack.size() != 0 && stack.peek().equals(tar)) {
                stack.pop();
            } else {
                stack.add(tar); 
            }
        }

        return stack.size() == 0 ? 1 : 0;
    }
}