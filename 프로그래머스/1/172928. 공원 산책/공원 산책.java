/*
제목 : 공원 산책
알고리즘 유형 : #string
플랫폼 : #Programmers 
난이도 : L1
문제번호 : 172928
시간 : 30m
해결 : O
저장 : X
해결언어 : java
문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/172928
특이사항 : 
*/

import java.util.*;

class Solution {
    // 상(N) 하(S) 좌(W) 우(E)
    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};
    static String[][] arr;
    static int startY;
    static int startX;
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer;
        arr = new String[park.length][park[0].length()];
        
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[i].length(); j++) {
                arr[i][j] = String.valueOf(park[i].charAt(j));
                if (arr[i][j].equals("S")) {
                    startY = i;
                    startX = j;
                }
            }
        }
        System.out.println("startY :" + startY);
             System.out.println("startX :" + startX);
        
        for(String s : routes) {
            String dires = String.valueOf(s.charAt(0));
            int dist = Integer.parseInt(String.valueOf(s.charAt(2)));
             System.out.println("dires :" + dires);
             System.out.println("dist :" + dist);
            
            int dire = -1;
            switch(dires) {
                case "N":
                    dire = 0;
                    break;
                case "S":
                    dire = 1;
                    break;
                case "W":
                    dire = 2;
                    break;
                case "E":
                    dire = 3;
                    break;
                default:
                    break;
            }
            boolean flag = true;
            int ny = startY;
            int nx = startX;
            // System.out.println("park.length : " + park.length);
            // System.out.println("park[0].length() : " + park[0].length());
            
            for(int a = 1; a <= dist; a++) {
                ny += dy[dire];
                nx += dx[dire];
                // System.out.println("ny :" + ny);
                // System.out.println("nx :" + nx);
                if(ny < 0 || nx < 0 || ny >= park.length || nx >= park[0].length() || arr[ny][nx].equals("X") 
                   ) {
                    // System.out.println(">>");
                    flag = false;
                    break;
                }
            }
            if(flag) {
                startY = ny;
                startX = nx;
            }
            
            
        }
        answer = new int[]{startY, startX};
        
        return answer;
    }
}