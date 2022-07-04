package BOJ.stepWorkbook.asmd;

import java.io.*;
import java.util.StringTokenizer;

public class boj_10430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str," ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf((A+B)%C));
        bw.newLine();
        bw.write(String.valueOf(((A%C) + (B%C))%C));
        bw.newLine();
        bw.write(String.valueOf((A*B)%C));
        bw.newLine();
        bw.write(String.valueOf(((A%C) * (B%C))%C));
        bw.newLine();

        bw.flush();
        bw.close();
    }
}
