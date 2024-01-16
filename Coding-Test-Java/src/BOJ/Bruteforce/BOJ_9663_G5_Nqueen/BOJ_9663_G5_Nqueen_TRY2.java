package BOJ.Bruteforce.BOJ_9663_G5_Nqueen;

import java.util.*;

public class BOJ_9663_G5_Nqueen_TRY2 {
    static int n;
    static int cnt;
    static int[] num;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        cnt = 0;
        num = new int[n];
        sol(0);
        System.out.println(cnt);
    }

    private static void sol(int idx) {
        if(idx == n) {
            cnt++;
            return;
        }

        for(int i = 0; i < n; i++) {
            num[idx] = i;
            if(poss(idx)) sol(idx + 1);
        }
    }

    private static boolean poss(int idx) {
        for (int i = 0; i < idx; i++) {
            if(num[i] == num[idx]) return false;
            else if(Math.abs(i - idx) == Math.abs(num[i] - num[idx])) return false;
        }
        return true;
    }
}
