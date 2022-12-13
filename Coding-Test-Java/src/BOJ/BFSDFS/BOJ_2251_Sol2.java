package BOJ.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// BFS
public class BOJ_2251_Sol2 {
    static int A, B, C;
    static Set<Integer> list = new HashSet<>();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[201][201];
        BFS(0, 0, C);
        List<Integer> li = new ArrayList<>(list);
        Collections.sort(li);
        for (int i = 0; i < li.size(); i++) {
            System.out.print(li.get(i) + " ");
        }
    }

    private static void BFS(int ia, int ib, int ic) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[201][201];

        queue.add(new int[]{ia,ib,ic});

        while(!queue.isEmpty()){
            int[] q = queue.poll();
            int a = q[0];
            int b = q[1];
            int c = q[2];

            if(visited[a][b]) continue;
            if(a == 0) list.add(c);
            visited[a][b] = true;

            // A -> B
            if(a + b > B) queue.add(new int[]{(a+b) - B, B, c});
            else queue.add(new int[]{0, a+b, c});

            // A -> C
            if(a + c > C) queue.add(new int[]{(a+c) - C, b, C});
            else queue.add(new int[] {0, b, a+c});

            // B -> A
            if(a + b > A) queue.add(new int[]{A, (a+b) - A, c});
            else queue.add(new int[]{a+b, 0, c});

            // B -> C
            if(b + c > C) queue.add(new int[]{a, B, (b+c) - B});
            else queue.add(new int[]{a, 0, b+c});

            // C -> A
            if(a + c > A) queue.add(new int[]{A, b, (a+c) - A});
            else queue.add(new int[]{a+c, b, 0});

            // C -> B
            if(b + c > B) queue.add(new int[]{a, B, (b+c) - B});
            else queue.add(new int[]{a, b+c, 0});

        }

    }
}
