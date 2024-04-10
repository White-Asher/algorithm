package BOJ.Hash.BOJ_1269_S4_대칭차집합;

import java.io.*;
import java.util.*;

public class BOJ_1269_S4_대칭차집합 {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<Integer> aset = new TreeSet<>();
        Set<Integer> bset = new TreeSet<>();
        int ans = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            aset.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            bset.add(Integer.parseInt(st.nextToken()));
        }
        Iterator aIter = aset.iterator();
        while(aIter.hasNext()) {
            Object a = aIter.next();
            if(!bset.contains(Integer.parseInt(a.toString()))) {
                ans++;
            }
        }
        Iterator bIter = bset.iterator();
        while(bIter.hasNext()) {
            Object b = bIter.next();
            if(!aset.contains(Integer.parseInt(b.toString()))) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
