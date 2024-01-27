/*
제목 : 로봇 조종하기
알고리즘 유형 : #DP
플랫폼 : #BOJ
난이도 : G2
문제번호 : 2169
시간 : INF
해결 : X
저장 : O
해결언어 : java
문제링크 : https://www.acmicpc.net/problem/2169
특이사항 : #
* 접근방법
일반적인 이중 for문으로 해결 될 것 같지만 문제에서 오른쪽에서 왼쪽으로 탐색될 때의 경우의 수도 고려해야함.
왼쪽 -> 오른쪽, 오른쪽 -> 왼쪽 탐색하면서 최대값을 임시 배열에 각각 저장해서
한줄씩 내려올 때마다 왼->오, 오->왼 탐색한 임시배열에서 최대값을 비교해서 dp에 저장하면 된다.
여기서 힌트를 얻었다 (https://blog.naver.com/occidere/220808155184)
*/

package BOJ.DP.BOJ_2169_G2_로봇조종하기;

import java.io.*;
import java.util.*;

public class BOJ_2169_G2_로봇조종하기 {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] mars = new int[N+1][M+1];
        int[][] dp = new int[N+1][M+1];
        int[][] temp = new int[2][M+2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                mars[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][1] = mars[1][1];

        for (int i = 2; i <= M; i++) {
            dp[1][i] = dp[1][i - 1] + mars[1][i];
        }

        for (int i = 2; i <= N; i++) {
            // 왼쪽 -> 오른쪽
            // 왼쪽부터 탐색시 위에서 내려온 값 대입
            temp[0][0] = dp[i-1][1];
            for (int j = 1; j <= M; j++) {
                // 왼쪽에서 온 값이랑 위에서 온 값이랑 비교해서 가장 큰 값 구함
                temp[0][j] = Math.max(temp[0][j-1], dp[i-1][j]) + mars[i][j];
            }

            // 오른쪽 -> 왼쪽
            // 오른쪽부터 탐색시 위에서 내려 온 값 대입
            temp[1][M+1] = dp[i-1][M];
            for (int j = M; j >= 1; j--) {
                // 왼쪽에서 온 값이랑 위에서 온 값이랑 비교해서 가장 큰 값 구함
                temp[1][j] = Math.max(temp[1][j+1], dp[i-1][j]) + mars[i][j];
            }

            // 왼쪽 비교 값이랑 오른쪽 비교값이랑 가장 최대값 dp배열에 대입
            for (int j = 1; j <= M; j++) {
                dp[i][j] = Math.max(temp[0][j], temp[1][j]);
            }

        }

        System.out.println(dp[N][M]);
    }
}
