package BOJ.BFSDFS.BOJ_16928_G5_뱀과사다리게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, ans;
    static int[] move;
    static boolean[] visited;
    static int[] count;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ans = 0;

        move = new int[101]; // 뱀 사다리 배열
        visited = new boolean[101]; // 방문 배열
        count = new int[101]; //  카운트 배열

        for (int i = 0; i < N+M; i++) {
            st = new StringTokenizer(br.readLine());
            move[Integer.parseInt(st.nextToken())] =  Integer.parseInt(st.nextToken());
        }
        BFS();
        System.out.println(ans);
    }

    public static void BFS() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        count[1] = 0;
        visited[1] = true;

        while(queue.size() != 0) {
            int q = queue.poll();
            if(q == 100) {
                ans = count[q];
                return;
            }

            for (int i = 1; i < 7; i++) {
                int nq = q + i;
                if(100 < nq) continue; // 100이상 X
                if (visited[nq]) continue; // 방문한 곳 재방문 X
                visited[nq] = true; // 방문 체크

                // 사다리, 뱀 이동 할수 있는지 확인함
                if (move[nq] != 0) { // 이동가능 .
                    if(!visited[move[nq]]){ // 해당 지점 이동했는지 체크함.
                        queue.add(move[nq]);
                        visited[move[nq]] = true;
                        count[move[nq]] = count[q] + 1;
                    }
                } else{
                    queue.add(nq);
                    count[nq] = count[q] + 1;
                }

            }
        }

    }
}