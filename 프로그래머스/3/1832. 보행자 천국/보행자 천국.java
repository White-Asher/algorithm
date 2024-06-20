import java.util.*;

/*
유형 : dp
2인 경우는 보행자 안전을 위해 좌회전이나 우회전이 금지된다. 
(왼쪽에서 오던 차는 오른쪽으로만, 위에서 오던 차는 아래쪽으로만 진행 가능하다)
해당 조건으로 인해 3차원 dp배열을 사용해야 함. 

왼, 위 -> 모두 0 = dp[0] = dp[1];
왼, 위 -> 한개라도 1일시 해당 방향 더하지 않음
왼, 위 -> 한개라도 2일시 위 -> 위쪽방향만 가져옴, 왼 -> 왼쪽에서 온 방향만 가져옴
*/

class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        int[][][] dp = new int[m][n][2];
        
        // 초기값 설정
        dp[0][0][0] = 1;
        dp[0][0][1] = 1;
        
        for(int i = 1; i < m; i++){
            if(cityMap[i][0] != 1) dp[i][0][0] = dp[i-1][0][0];
        }
        for(int i = 1; i < n; i++){
            if(cityMap[0][i] != 1) dp[0][i][1] = dp[0][i-1][1];
        }
        
        // 경로 탐색
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                // 위 -> 아래
                if(cityMap[i-1][j] != 1) {
                    if(cityMap[i-1][j] == 2) {
                        dp[i][j][0] = dp[i-1][j][0];
                    } else {
                        // 위쪽에서 올 수 있는 경로는 바로 이전 위에서 올 수 있는 위, 왼 에서 올 수 있는 경로 더함
                        dp[i][j][0] = (dp[i-1][j][0] + dp[i-1][j][1]) % MOD;
                    }
                }
                
                // 왼 -> 오
                if(cityMap[i][j-1] != 1) {
                    if(cityMap[i][j-1] == 2) {
                        dp[i][j][1] = dp[i][j-1][1];
                    } else {
                        dp[i][j][1] = (dp[i][j-1][0] + dp[i][j-1][1]) % MOD;
                    }
                }
            }
        } // END:FOR
        
        return (dp[m-1][n-1][0] + dp[m-1][n-1][1]) % MOD;
    }
}