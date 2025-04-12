/*
제목 : 이진 변환 반복하기
알고리즘 유형 : #문자열
플랫폼 : #Programmers
난이도 : L2
문제번호 : 70129
시간 : 20
해결 : O
저장 : O
해결언어 : java
문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/70129
특이사항 : #[도서실습] 프로그래머스 코딩 테스트 문제 풀이 전략: 자바편
*/

class Solution {
    public int[] solution(String s) {
        int loopCnt = 0;
        int removeCnt = 0;
        
        while(!s.equals("1")) {
            int zeros = countZeros(s);
            loopCnt++;
            removeCnt+=zeros;
            
            int decimal = s.length() - zeros;
            s = Integer.toString(decimal, 2); // 이진수 변환
        }
        return new int[]{loopCnt, removeCnt};
    }
    
    int countZeros(String s) {
        int cnt = 0;
        for(char c : s.toCharArray()) {
            if(c == '0') cnt++;
        }
        return cnt;
    }
}