/*
제목 : 텀 프로젝트
알고리즘 유형 : #dfs
플랫폼 : #BOJ
난이도 : G3
문제번호 : 9466
시간 : 60m
해결 : X
저장 : O
해결언어 : java
문제링크 : https://www.acmicpc.net/problem/9466
특이사항 : #
*/

package BOJ.BFSDFS.BOJ_9466_G3_텀프로젝트;

import java.util.*;
import java.io.*;

public class BOJ_9466_G3_텀프로젝트 {
    static StringTokenizer st;
    static int[] arr; // 함께하고 싶은 학생 배열
    static int n; // 전체 학생 수
    static int count; // 팀 편성된 학생 수
    static boolean[] finish; // 팀 편성 완료된 배열
    static boolean[] visited; // 탐색 배열
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            count = 0;
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int end = Integer.parseInt(st.nextToken()) - 1;
                arr[i] = end;
            }
            finish = new boolean[n];
            visited = new boolean[n];
            for(int i = 0; i < n; i++) {
                if(finish[i]) continue;
                dfs(i);
            }
            sb.append(n - count).append("\n");
        } // end :: TC
        System.out.println(sb);
    }

    public static void dfs(int cur) {
        // 팀편성 완료된 학생은 제외
        if(finish[cur]) return;
        int next = arr[cur];

        // 방문했었으면 사이클 구성원이다.
        if(visited[cur]) {
            finish[cur] = true;
            count++;
        }
        visited[cur] = true;
        dfs(next);
        visited[cur] = false;
        finish[cur] = true;
    }

}
