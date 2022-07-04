package testground;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = bf.readLine();
        bw.write(s);
        bf.close();
        bw.close();
    }
}
