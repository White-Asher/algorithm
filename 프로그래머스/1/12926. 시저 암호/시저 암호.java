/*
제목 : 시저 암호
알고리즘 유형 : #문자열
플랫폼 : #Programmers
난이도 : L1
문제번호 : 12926
시간 : 0
해결 : O
저장 : O
해결언어 : java
문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12926
특이사항 : #[도서실습] 프로그래머스 코딩 테스트 문제 풀이 전략: 자바편
*/

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isLowerCase(ch)){
                ch = (char) ((ch - 'a'+ n) % 26 + 'a');
            } else if(Character.isUpperCase(ch)){
                ch = (char) ((ch - 'A'+ n) % 26 + 'A');
            }
            answer += ch;
        }

        return answer;
    }
}