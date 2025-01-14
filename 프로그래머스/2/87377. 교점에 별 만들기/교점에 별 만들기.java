/*
제목 : 교점에 별 만들기
알고리즘 유형 : #배열
플랫폼 : #Programmers
난이도 : L2
문제번호 : 87377
시간 : -
해결 : -
저장 : O
해결언어 : java
문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/87377
특이사항 : #[도서실습] 프로그래머스 코딩 테스트 문제 풀이 전략: 자바편
*/

import java.util.*;

class Solution {
    
    static class Point{
        long x, y;
        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        for(int i = 0; i < line.length; i++) {
            for(int j = i + 1; j < line.length; j++) {
                Point intersection = intersection(
                    line[i][0], line[i][1], line[i][2],
                    line[j][0], line[j][1], line[j][2]
                );
                if(intersection != null) {
                    points.add(intersection);
                }
            }
        }
        
        Point minimum = getMinimumPoint(points);
        Point maximum = getMaximumPoint(points);
        
        int width = (int) (maximum.x - minimum.x + 1);
        int height = (int) (maximum.y - minimum.y + 1);
        
        char[][] arr = new char[height][width];
        for(char[] c : arr) {
            Arrays.fill(c, '.');
        }
        
        for(Point p : points) {
            int x = (int) (p.x - minimum.x);
            int y = (int) (maximum.y - p.y);
            arr[y][x] = '*';
        }
        
        String[] answer = new String[arr.length];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = new String(arr[i]);
        }
        
        return answer;
    }
    
    public Point intersection(long a, long b, long e, long c, long d, long f) {
        if((a * d - b * c) != 0){
            double x = (double) (b * f - e * d) / (a * d - b * c);
            double y = (double) (e * c - a * f) / (a * d - b * c);
            if(x % 1 == 0 && y % 1 == 0){                           //정수인 경우에만 저장
                return new Point((long)x, (long)y);
            }
        }
        return null;
    }
    
    public Point getMinimumPoint(List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;
        
        for(Point p : points) {
            if(p.x < x) x = p.x;
            if(p.y < y) y = p.y;
        }
        
        return new Point(x, y);
    }
    
    public Point getMaximumPoint(List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;
        
        for(Point p : points) {
            if(p.x > x) x = p.x;
            if(p.y > y) y = p.y;
        }
        
        return new Point(x, y);
    }
    
}
