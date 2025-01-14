/*
제목 : 삼각 달팽이
알고리즘 유형 : #배열
플랫폼 : #Programmers
난이도 : L2
문제번호 : 68645
시간 : 20
해결 : O
저장 : O
해결언어 : java
문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/68645
특이사항 : #[도서실습] 프로그래머스 코딩 테스트 문제 풀이 전략: 자바편
*/

import java.util.*;

class Solution {
    static int[] dy = {1,0,-1};
    static int[] dx = {0,1,-1};
    
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int dire = 0;
        int y = 0;
        int x = 0;
        int cnt = 1;
        
        while(true){
            arr[y][x] = cnt;
            int ny = y + dy[dire];
            int nx = x + dx[dire];
            
            if(ny < 0 || nx < 0 || ny >= n || nx >= n || arr[ny][nx] != 0) {
                dire  = (dire + 1) % 3;

                if(y + dy[dire] >= n || y + dy[dire] < 0 || x + dx[dire] >= n || x + dx[dire] < 0) {
                    break;
                }
                if(arr[y + dy[dire]][x + dx[dire]] != 0) {
                    break;
                }
                y = y + dy[dire];
                x = x + dx[dire];
            } else {
                y = ny;
                x = nx;
            }
            
            cnt++;

        }
        
        int[] answer = new int[cnt];
        int idx = 0;
        
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] != 0) {
                    answer[idx++] = arr[i][j];
                }
            }
        }
        
        return answer;
    }
}