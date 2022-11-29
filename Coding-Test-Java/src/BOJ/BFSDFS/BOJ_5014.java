package BOJ.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        if(S==G){
            System.out.println(0);
            System.exit(0);
        }

        int[] d = new int[]{U,-D};

        Deque<Integer> queue = new ArrayDeque<>();
        int[] visited = new int[F+1];
        visited[S] = 1;
        queue.add(S);

        while(!queue.isEmpty()) {
            int q = queue.pop();

            for (int i = 0; i < 2; i++) {
                int nq = q + d[i];
                if(nq == G) {
                    System.out.println(visited[q]);
                    System.exit(0);
                }
                if(nq > F || nq <= 0) continue;
                if(visited[nq] != 0) continue;
                visited[nq] = visited[q] + 1;
                queue.add(nq);
            }
        }
        if(visited[G] == 0) {
            System.out.println("use the stairs");
        }
    }

}
