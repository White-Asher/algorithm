package BOJ.UnionFind.BOJ_10775_G2_공항;

import java.util.*;
import java.io.*;

public class BOJ_10775_G2_공항_250628 {
    static int G, P, ans;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        parent = new int[G + 1];
        for (int i = 1; i <= G; i++) {
            parent[i] = i;
        }
        for (int p = 0; p < P; p++) {
            int target = Integer.parseInt(br.readLine());
            int search = find(target);
            if(search == 0) break;
            ans++;
            union(search, search - 1);
        }

        System.out.println(ans);
    }

    public static int find(int i) {
        // 자기 자신이 대표면 자기 자신 반환
        if(parent[i] == i) {
            return i;
        }
        // 재귀호출 / 최종 대표 호출
        parent[i] = find(parent[i]);
        return parent[i];
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA != rootB) {
            parent[rootA] = rootB;
        }
    }
}
