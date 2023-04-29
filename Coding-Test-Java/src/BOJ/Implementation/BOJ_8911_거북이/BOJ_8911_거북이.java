package BOJ.Implementation.BOJ_8911_거북이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8911_거북이 {
    // 북, 동, 서, 남
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] a = br.readLine().split("");
            System.out.println(process(a));
        }
    }

    public static int process(String[] a) {
        int x = 0, y = 0, minX = 0, minY = 0, maxX = 0, maxY = 0, dire = 0;
        for (int i = 0; i < a.length; i++) {
            if(a[i].equals("F")){
                x += dx[dire];
                y += dy[dire];
            } else if (a[i].equals("B")) {
                x -= dx[dire];
                y -= dy[dire];
            } else if (a[i].equals("L")) {
                dire -= 1;
                if(dire < 0) {
                    dire = 3;
                }
            } else {
                dire += 1;
                if(dire > 3) {
                    dire = 0;
                }
            }
            maxX = Math.max(x, maxX);
            maxY = Math.max(y, maxY);
            minX = Math.min(x, minX);
            minY = Math.min(y, minY);
        }
        return (Math.abs(maxX - minX) * Math.abs(maxY - minY));
    }
}
