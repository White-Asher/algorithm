package BOJ._BRONZE.BOJ_20492_B5_세금;

import java.io.*;

public class BOJ_20492_B5_세금_250715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a = n - (int) (n * 0.22);
        int b = n - (int) (n * 0.2 * 0.22);
        System.out.println(a + " " + b);
    }
}
