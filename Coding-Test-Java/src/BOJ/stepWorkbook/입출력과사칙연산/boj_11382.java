package BOJ.stepWorkbook.입출력과사칙연산;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11382 {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        long sum = 0L;
        for(int i = 0; i < 3; i++) {
            sum += Long.parseLong(st.nextToken());
        }
        System.out.println(sum);
    }
}
