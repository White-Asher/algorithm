/*
제목 : 1의 개수 세기
알고리즘 유형 : #dp , #bitmask
플랫폼 : #BOJ
난이도 : G2
문제번호 : 9527
시간 : INF
해결 : X
저장 : O
해결언어 : java
문제링크 : https://www.acmicpc.net/problem/9527
특이사항 : #
*/

package _UnsolvedProblem.BOJ_9527_G2_1의개수세기;

import java.io.*;
import java.util.*;

public class BOJ_9527_G2_1의개수세기 {
    static long[] bit;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        initBitCount();
        long ans = getBitCount(b) - getBitCount(a - 1);
        System.out.println(ans);
    }

    static long getBitCount(long n) {
        long ans = n & 1;
        for (int i = 54; i > 0; i--) {
            // 숫자 n의 i번째 비트가 1이라면...
            if((n & (1L  << i)) > 0L) {
                ans += bit[i - 1] + (n - (1L << i) +1);
                n-=(1L<<i);
            }
        }
        return ans;
    }

    // dp[n] = dp[n-1] * 2 + 2^n
    static void initBitCount() {
        bit = new long[55];
        bit[0] = 1;
        for (int i = 1; i < 55; i++) {
            bit[i] = 2 * bit[i - 1] + (1L << i);
        }
    }
}
