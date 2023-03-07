package _Playground;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, ans;
    static int[] ladder;
    static int[] snake;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ans = 0;

        ladder = new int[101];
        snake = new int[101];
        visited = new int[101];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ladder[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            snake[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        BFS(0);
        System.out.println(Arrays.toString(visited));
        System.out.println(ans);
    }

    public static void BFS(int x) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(x);

        while(queue.size() != 0) {
            int q = queue.poll();
            System.out.println(q);
            for (int i = 1; i <= 6; i++) {
                System.out.println(i);
                int nq = q + i;

                if(nq >= 100) {
                    ans = visited[nq] + 1;
                    return;
                }

                if (visited[nq] != 0){
                    
                }

                // 사다리 확인
                for (int l = 0; l < ladder.length; l++) {
                    if(ladder[l] == nq) {
                        nq = ladder[l];
                    }
                }

                // 뱀 확인
                for (int s = 0; s < snake.length; s++) {
                    if(snake[s] == nq) {
                        nq = snake[s];
                    }
                }

                visited[nq]+=1;
                queue.add(nq);

            }
        }

    }
}
