/*
제목 : 쿠키 구입
알고리즘 유형 : #Two-Pointer
플랫폼 : #Programmers 
난이도 : L4
문제번호 : 49995
시간 : 30m
해결 : X
저장 : O
해결언어 : java
문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/49995
특이사항 : #프로그래머스-Summer/Winter Coding(~2018)
*/

/*
test-case:1
input
[3, 1, 4, 1, 2, 3, 1]
output
6
test-case:2
input
[1, 2, 3, 4, 5, 2]
output
7
*/

import java.util.*;

class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        
        // 쿠키 처음부터 끝까지 탐색
        for(int c = 0; c < cookie.length - 1; c++) {
            
            // 왼쪽
            int cur = c;
            int curSum = cookie[c];
            
            // 오른쪽
            int next = c + 1;
            int nextSum = cookie[next];
            
            while(true) {
                
                // 두 바구니 값이 같다면.. max값 넣기
                if(curSum == nextSum) {
                    answer = Math.max(answer, curSum);
                }
                
                // System.out.println(" --- ");
                // System.out.println("curSum : " + curSum);
                // System.out.println("nextSum : " + nextSum);
                
                // 왼쪽 바구니가 작으면 왼쪽 인덱스 한개 더 탐색
                if(curSum <= nextSum && cur > 0) {
                    // System.out.println("left");
                    cur--;
                    curSum += cookie[cur];
                    // 오른쪽 바구니가 작으면 오른쪽 인텍스 한개 더 탐색
                } else if(curSum >= nextSum && next < cookie.length-1) {
                    // System.out.println("right");
                    next++;
                    nextSum += cookie[next];
                } else {
                    break;
                }
            }
            
        }
        
        return answer;
    }
}