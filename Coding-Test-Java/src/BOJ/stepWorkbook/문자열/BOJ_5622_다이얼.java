package BOJ.stepWorkbook.문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_5622_다이얼 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");
        int ans = 0;

        for (int i = 0; i < str.length; i++) {
            if (str[i].charAt(0) < 68) ans += 3;
            else if (str[i].charAt(0) < 71) ans += 4;
            else if (str[i].charAt(0) < 74) ans += 5;
            else if (str[i].charAt(0) < 77) ans += 6;
            else if (str[i].charAt(0) < 80) ans += 7;
            else if (str[i].charAt(0) < 84) ans += 8;
            else if (str[i].charAt(0) < 87) ans += 9;
            else ans += 10;
        }

        System.out.println(ans);
    }
    
    
}
