package _temp.BOJ_2143_두배열의합;

import java.io.*;
import java.util.*;

public class BOJ_2143_두배열의합 {
    static StringTokenizer st;
    static List<Integer> listA = new ArrayList<>();
    static List<Integer> listB = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            listA.add(input);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int input = Integer.parseInt(st.nextToken());
            listB.add(input);
        }

        Collections.sort(listA);
        Collections.sort(listB);

        int idxA = 0;
        int idxB = listB.size() - 1;



    }
}
