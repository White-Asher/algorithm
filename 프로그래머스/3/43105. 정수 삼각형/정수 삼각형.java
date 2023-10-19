import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle[triangle.length-1].length];
        
        dp[0][0] = triangle[0][0];
        
        // 삼각형 전부 돌기
        for(int i = 1; i < triangle.length; i++) {
            for(int j = 0; j <= i; j++) {
                // 만약 첫번째, 마지막 항목이라면 그것만 수행
                if (j == 0) {
                    dp[i][0] = dp[i-1][0] + triangle[i][0];
                } else if (j == i) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i][j], triangle[i][j] + dp[i-1][j-1]);
                    dp[i][j] = Math.max(dp[i][j], triangle[i][j] + dp[i-1][j]);
                }
            }
        }
        
        for(int i = 0; i < triangle[triangle.length-1].length; i++) {
            answer = Math.max(answer, dp[triangle.length-1][i]);
        }
        
        // for(int i = 0; i < triangle.length; i++) {
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        
        return answer;
    }
}