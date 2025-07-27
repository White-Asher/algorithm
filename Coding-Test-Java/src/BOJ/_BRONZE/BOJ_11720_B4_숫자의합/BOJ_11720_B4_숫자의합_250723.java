package BOJ._BRONZE.BOJ_11720_B4_숫자의합;

import java.util.*;
import java.io.*;

public class BOJ_11720_B4_숫자의합_250723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int ans = 0;
        for (int s = 0; s < str.length(); s++) {
            ans += Integer.parseInt(String.valueOf(str.charAt(s)));
        }
        System.out.println(ans);
    }
}
