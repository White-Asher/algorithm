package BOJ.BFSDFS.BOJ_2668_G5_숫자고르기;

import java.io.*;
import java.util.*;

public class BOJ_2668_숫자고르기 {
    static int[] arr;
    static boolean[] check;
    static int n, ans;
    static List<Integer> list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        check = new boolean[n+1];
        ans = Integer.MIN_VALUE;
        list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            List<Integer> aList = new ArrayList<>();
            int cnt = 0;
            DFS(i, aList, cnt, i);
        }
        List<Integer> ansList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(check[i]) ansList.add(i);
        }
        System.out.println(ansList.size());
        for (int i = 0; i < ansList.size(); i++) {
            System.out.println(ansList.get(i));
        }
    }

    public static void DFS(int start, List<Integer> aList, int cnt, int tar) {
        // 사이클임
        if (arr[start] == tar) {
            for (int i = 0; i < aList.size(); i++) {
                int target = aList.get(i);
                check[target] = true;
            }
        }
        if(cnt > 100) {
            return;
        }
        aList.add(start);
        DFS (arr[start], aList, cnt+1, tar);

    }
}
