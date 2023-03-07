package BOJ.stepWorkbook.입출력과사칙연산;

import java.io.*;
import java.util.StringTokenizer;

public class boj_1008 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str," ");
        double a = Integer.parseInt(st.nextToken());
        double b = Integer.parseInt(st.nextToken());

        System.out.println(a/b);
    }
}