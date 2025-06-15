package BOJ.Greedy.BOJ_1744_G4_수묶기;

import java.util.*;
import java.io.*;

public class BOJ_1744_G4_수묶기_250615 {
    static int N;
    static int zero = 0;
    static int mone = 0;
    static int one = 0;
    static List<Integer> posList = new ArrayList<>();
    static List<Integer> negList = new ArrayList<>();

    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N == 1) {
            System.out.println(Integer.parseInt(br.readLine()));
            return;
        }

        for (int i = 0; i < N; i++) {
            int get = Integer.parseInt(br.readLine());
            if(get > 1) {
                posList.add(get);
            } else if (get == 1) {
                one++;
            } else if (get == 0) {
                zero++;
            } else {
                negList.add(get);
            }
        }

        Collections.sort(posList, Collections.reverseOrder());
        Collections.sort(negList);

        while(posList.size() >=2) {
            int get1 = posList.get(0);
            int get2 = posList.get(1);
            ans += get1 * get2;
            posList.remove(0);
            posList.remove(0);
        }
        if(!posList.isEmpty()) {
            ans += posList.get(0);
        }
        ans+= one;

        while(negList.size() >= 2) {
            int get1 = negList.get(0);
            int get2 = negList.get(1);
            ans += get1 * get2;
            negList.remove(0);
            negList.remove(0);
        }

        if(negList.size() >= 1 && zero == 0) {
            ans += negList.get(0);
        }

        System.out.println(ans);
    }
}
