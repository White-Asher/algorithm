/*
제목 : 자연수 뒤집어 배열로 만들기
알고리즘 유형 : #문자열
플랫폼 : #Programmers
난이도 : L1
문제번호 : 12932
시간 : 0
해결 : O
저장 : O
해결언어 : java
문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12932?language=java
특이사항 : #[도서실습] 프로그래머스 코딩 테스트 문제 풀이 전략: 자바편
*/

class Solution {
    public int[] solution(long n) {
        String str = String.valueOf(n);
        int[] answer = new int[str.length()];
        int idx = 0;
        for(int i = str.length() - 1; i >= 0; i--) {
            answer[idx++] = Integer.valueOf(String.valueOf(str.charAt(i)));
        }
        return answer;
    }
}