/*
제목 : 디스크 컨트롤러
알고리즘 유형 : #heap
플랫폼 : #Programmers 
난이도 : L3
문제번호 : 42627
시간 : -
해결 : X
저장 : O
해결언어 : java
문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42627
특이사항 : #프로그래머스-고득점
*/

import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        int answer = 0;
        int end = 0; // 수행되고난 직후의 시간
        int idx = 0; // jobs 배열의 인덱스
        int count = 0; // 수행된 요청 갯수
        
        // 들어오는 시간 별로 배열 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        // 소요시간이 작은 것 부터 정렬한다. 
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        // 작업 순회
        while (count < jobs.length) {
            // 작업을 순회하면서 작업 시작 시간이 수행 끝나는 시간보다 작거나 같다면
            while (idx < jobs.length && jobs[idx][0] <= end) {
                // 우선순위 큐에 해당 작업 배치
                pq.add(jobs[idx++]);
            }
            
            // 큐가 비어있다면? 끝나는 시간은 해당 작업 요청시점
            if (pq.isEmpty()) {
                end = jobs[idx][0];
            } else {
                // 큐가 비어있지 않을 때 
                int[] temp = pq.poll();
                // 요청에서 종료까지 시간은 
                // = (현재 작업 소요시간 + 이전작업 종료된 시점 - 현재작업 시작시점)
                // = (9 + 3 - 1)
                answer += temp[1] + end - temp[0];
                end += temp[1];
                count++; 
            }
        }
        
        return (int) Math.floor(answer / jobs.length);
    }
}