package BOJ.BFSDFS.BOJ_2668_G5_숫자고르기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2668_숫자고르기_Refactor1 {
    static int[] arr;
    static boolean[] check;
    static List<Integer> list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        check = new boolean[n+1];
        list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            check[i] = true;
            DFS(i, i);
            check[i] = false;
        }

        Collections.sort(list); //작은 수 부터 출력하므로 정렬한다.
        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

    public static void DFS(int start, int tar) {
        if(arr[start] == tar) list.add(tar);
        if(!check[arr[start]]) {
            check[arr[start]] = true;
            DFS(arr[start], tar);
            check[arr[start]] = false;
        }

    }
}
