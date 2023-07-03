package BOJ.String.BOJ_1342_S1_행운의문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1342_행운의문자열 {
    static int N, ans;
    static int[] num;
    static char[] str;
    static boolean[] select;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine().toCharArray();
        N = str.length;
        num = new int[N];
        select = new boolean[N];

        int[] arr = new int[26];
        for (int i = 0; i < str.length; i++) {
            arr[str[i] -'a']++;
        }
        permu(0);
        for (int i = 0; i < 26; i++) {
            if(arr[i] > 1){
                ans /= factorial(arr[i]);
            }
        }
        System.out.println(ans);
    }

    public static int factorial(int n) {
        if(n == 1) return 1;
        return n * factorial(n - 1);
    }

    public static boolean checking() {
        boolean check = true;
        for (int i = 1; i < N; i++) {
            if(str[num[i]] == str[num[i-1]]) {
                return false;
            }
        }
        return check;
    }

    public static void permu(int x) {
        if(x == N) {
            if(checking()) ans++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if(select[i]) continue;
            select[i] = true;
            num[x] = i;
            permu(x + 1);
            select[i] = false;
        }
    }
}
