import java.util.*;

class Solution {
    static List<Integer> infoList = null;
    static int[] peach; 
    // 각 점수의 정답 개수 0으로 초기화
    static int[] lion = {0,0,0,0,0,0,0,0,0,0,0};
    // 최대 점수
    static int maxScore = 0;
    // 정답
    static int[] answer = {0,0,0,0,0,0,0,0,0,0,0};
    
    public int[] solution(int n, int[] info) {
        peach = info;
        backtracking(0, 0, n);
        
        // 배열 0의 수가 0이면 이길 수 있는 방법이 없음.
        int zeroCnt = 0;
        for(int i = 0; i <= 10; i++) {
            if(answer[i] == 0) zeroCnt++;
        }
        if(zeroCnt == 11) answer = new int[]{-1};
        
        return answer;
    }
    
    static void backtracking(int idx, int curArrowCnt, int totalArrowCnt) {
        // 모든 화살을 전부 발사했다면 점수 계산
        if(curArrowCnt >= totalArrowCnt) {
            int pScore = 0; // 라이언의 점수
            int lScore = 0; // 어피치의 점수
            
            // 둘다 0일 때를 제외한다. 라이언이 커야지만 점수를 얻는다. 
            for(int i = 0; i < peach.length; i++) {
                if(peach[i] == 0 && lion[i] == 0) continue;
                if(lion[i] > peach[i]) lScore += (10 - i);
                else pScore += (10 - i);
            }
            
            // 두 사람의 격차 점수
            int cntScore = lScore - pScore;
            
            // 라이언이 어피치의 점수를 이긴다면
            if(lScore > pScore) {
                // 기존 점부보다 큰지 비교하고 크다면 새로 할당함
                if(cntScore > maxScore) {
                    maxScore = cntScore;
                    answer = lion.clone();
                }
                
                // 기존 점수와 같을 경우
                else if(cntScore == maxScore) {
                    // 마지막 배열부터 앞으로 이동
                    for(int i = 10; i >= 0; i--) {
                        // 가장 낮은 수가 새로 찾은 배열이 더 클 때,
                        if(lion[i] > answer[i]) answer = lion.clone();
                        // 가장 낮은 수가 기존의 정답 배열이 클 때
                        else if(lion[i] < answer[i]) return;
                    }
                }
                
            }
            return;
        }

        // 중복 조합으로 백트래킹
        for(int i = idx; i <= 10; i++) {
            if(lion[i] > peach[i]) continue;
            lion[i]++;
            backtracking(i, curArrowCnt + 1, totalArrowCnt);
            lion[i]--; // 원복
        }
    }

    
}