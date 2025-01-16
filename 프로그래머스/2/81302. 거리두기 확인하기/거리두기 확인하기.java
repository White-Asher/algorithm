/*
제목 : 거리두기 확인하기
알고리즘 유형 : #배열
플랫폼 : #Programmers
난이도 : L2
문제번호 : 81302
시간 : 40
해결 : O
저장 : O
해결언어 : java
문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/81302
특이사항 : #[도서실습] 프로그래머스 코딩 테스트 문제 풀이 전략: 자바편
*/
import java.util.*;
import java.io.*;

class Solution {
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static boolean[][] visit;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i = 0; i < places.length; i++) {
            answer[i] = check(places[i]);
        }
      
        return answer;
    }
    
    public int check(String[] place) {
        char[][] arr = new char[5][5];
        visit = new boolean[5][5];
        
        for(int i = 0; i < 5; i++) {
            String temp = place[i];
            for(int j = 0; j < 5; j++) {
                arr[i][j] = temp.charAt(j);
            }
        }
        
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(arr[i][j] == 'P') {
                    for(int d = 0; d < 4; d++) {
                        int ny = i + dy[d];
                        int nx = j + dx[d];
                        
                        if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                        if(arr[ny][nx] == 'X') continue;
                        
                        if(arr[ny][nx] == 'P' || visit[ny][nx]) {
                            return 0;
                        }
                        
                        visit[ny][nx] = true;
                        
                    }
                }
                
                
            }
        }
        
        return 1;
    }
}

