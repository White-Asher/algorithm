package BOJ.Bruteforce.BOJ_16987_G5_계란으로계란치기;

import java.util.*;
import java.io.*;

public class BOJ_16987_G5_계란으로계란치기 {
    static int N;
    static int[][] egg;
    static StringTokenizer st;
    static int max = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        egg = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            egg[i][0] = Integer.parseInt(st.nextToken()); // 내구도
            egg[i][1] = Integer.parseInt(st.nextToken()); // 무게
        }

        solution(0, 0);
        System.out.println(max);
    }

    private static void solution(int startEgg, int cnt) {
        // 마지막계란까지 옴.
        max = Math.max(cnt, max);

        if(startEgg == N) {
            return;
        } else {
            // 현재 달걀의 내구도가 0 이하라면 다음꺼 탐색함
            if(egg[startEgg][0] <= 0){
                solution(startEgg + 1, cnt);
            } else {
                // 현재 달갈 들면서 다른계란 깨버리기
                for(int i = 0; i < N; i++) {
                    // 계란 자기자신을 깰 수 없으니 패스 || 이미 깨버린 계란은 패스
                    if(i == startEgg || egg[i][0] <= 0) continue;
                    // 서로 계란을 부딪히고 내구도 감소
                    egg[startEgg][0] -= egg[i][1];
                    egg[i][0] -= egg[startEgg][1];
                    // 두개의 계란을 부딪힐 때 깨진 계란 수
                    int tempCnt = cnt;
                    if(egg[startEgg][0] <= 0) tempCnt++;
                    if(egg[i][0] <= 0) tempCnt++;
                    // 다음꺼 탐색 + 재귀
                    solution(startEgg + 1, tempCnt);
                    // 재귀 탈출 후 원복
                    egg[startEgg][0] += egg[i][1];
                    egg[i][0] += egg[startEgg][1];
                }
            }
        }
    }
}
