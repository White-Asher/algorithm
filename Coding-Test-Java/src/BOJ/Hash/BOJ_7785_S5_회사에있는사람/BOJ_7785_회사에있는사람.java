package BOJ.Hash.BOJ_7785_S5_회사에있는사람;

import java.io.*;
import java.util.*;

public class BOJ_7785_회사에있는사람 {
    static int N;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // 역순정렬
        Set<String> set = new TreeSet<>(Collections.reverseOrder()) ;

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            if (str[1].equals("enter")) {
                set.add(str[0]);
            } else {
                set.remove(str[0]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : set) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}
