package BOJ.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// DFS
public class BOJ_2251_Sol1 {
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
        DFS(0,0, C);
        List<Integer> li = new ArrayList<>(list);
        Collections.sort(li);
        for (int i = 0; i < li.size(); i++) {
            System.out.print(li.get(i) + " ");
        }

    }

    public static void DFS(int a, int b, int c) {
        if(visited[a][b]) return;
        if(a == 0) list.add(c);
        visited[a][b] = true;

        // a물통 b에 붓기
        if(a + b > B) DFS((a+b) - B, B, c);
        else DFS(0, a+b, c);

        // a물통 c에 붓기
        if(a + c > C) DFS((a+c) - C, b, C);
        else DFS(0, b, a+c);

        // b물통 a에 붓기
        if(a + b > A) DFS(A, (a+b) - A, c);
        else DFS(a+b, 0, c);

        // b물통 c에 붓기
        if(b + c > C) DFS(a, B, (b+c) - B);
        else DFS(a, 0, b+c);

        // c물통 a에 붓기
        if(a + c > A) DFS(A, b, (a+c) - A);
        else DFS(a+c, b, 0);

        // c물통 b에 붓기
        if(b + c > B) DFS(a, B, (b+c) - B);
        else DFS(a, b+c, 0);
    }

}
