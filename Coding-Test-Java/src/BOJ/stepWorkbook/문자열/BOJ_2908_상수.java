package BOJ.stepWorkbook.문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2908_상수 {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        StringBuilder sb1 = new StringBuilder(st.nextToken()).reverse();
        StringBuilder sb2 = new StringBuilder(st.nextToken()).reverse();
        int a = Integer.parseInt(sb1.toString());
        int b = Integer.parseInt(sb2.toString());

        System.out.println(Math.max(a, b));

    }
}
