/*
제목 :
알고리즘 유형 : #bfs
플랫폼 : #BOJ
난이도 : P5
문제번호 : 17071
시간 : INF
해결 : X
저장 : O
해결언어 : java
문제링크 : https://www.acmicpc.net/problem/17071
특이사항 : 라인 인턴채용 코테 유형 (19년)
*/

package BOJ.BFSDFS.BOJ_17071_P5_숨바꼭질5;

import java.util.*;
import java.io.*;

public class BOJ_17071_P5_숨바꼭질5 {
    static StringTokenizer st;
    static int[][] visited;
    static final int MAX_NUM = 500001;
    static int N, K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[2][MAX_NUM];
        Arrays.fill(visited[0], -1); // 짝수시간 방문
        Arrays.fill(visited[1], -1); // 홀수시간 방문
        // 수빈 시작지점
        visited[0][N] = 0;
        if(N == K) {
            System.out.println(0);
        }else {
            System.out.println(bfs());
        }
    }
    public static int bfs(){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(N);

        int size = 0;
        int mod = 0;
        int time = 0;
        int now = 0;

        while(!queue.isEmpty()) {
            size = queue.size();
            time++;
            mod = time % 2;

            for (int i = 0; i < size; i++) {
                now = queue.poll();
                if(now + 1 < MAX_NUM && visited[mod][now + 1] == -1) {
                    queue.add(now+1);
                    visited[mod][now+1] = time;
                }
                if(now - 1 >= 0 && visited[mod][now - 1] == -1) {
                    queue.add(now-1);
                    visited[mod][now-1] = time;
                }
                if(now * 2 < MAX_NUM && visited[mod][now*2] == -1) {
                    queue.add(now*2);
                    visited[mod][now*2] = time;
                }

                int broLocation = getBroLocation(time);
                if(broLocation >= MAX_NUM) return -1;
                if(visited[mod][broLocation] != -1) {
                    return time;
                }
            }
        }
        return time;
    }
    private static int getBroLocation(int time) {
        return K + (time * (time + 1) / 2);
    }
}
