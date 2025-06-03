package BOJ.BFSDFS.BOJ_9019_G5_DSLR;

import java.util.*;
import java.io.*;

public class BOJ_9019_G5_DSLR_250603 {
    static int start, end;
    static String ans;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int t = 0; t < T; t++) {
            visit = new boolean[10000];
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            bfs();
        }
        System.out.println(sb);
    }

    public static void bfs() {
        Queue<Digit> q = new ArrayDeque<>();
        q.add(new Digit(start, ""));

        while(!q.isEmpty()) {
            Digit cur = q.poll();
            int cnum = cur.num;
            int nextnum = 0;
            String nextCommand = "";
            for(int d = 0; d < 4; d++) {
                switch (d){
                    case 0: // D
                        if(cnum == 0) break;
                        nextnum = (cnum * 2) % 10000;
                        nextCommand = "D";
                        break;
                    case 1: // S
                        nextnum = (cnum - 1 < 0 ? 9999 : cnum - 1);
                        nextCommand = "S";
                        break;
                    case 2:
                        if(cnum == 0) break;
                        nextnum = (cnum % 1000) * 10 + cnum / 1000;
                        nextCommand = "L";
                        break;
                    case 3:
                        if(cnum == 0) break;
                        nextnum = (cnum / 10) + (cnum % 10) * 1000;
                        nextCommand = "R";
                        break;
                    default:
                        break;
                }
                if(visit[nextnum]) continue;
                visit[nextnum] = true;
                if(nextnum == end) {
                    sb.append(cur.command+nextCommand).append("\n");
                    return;
                }
                q.add(new Digit(nextnum, cur.command+nextCommand));
            }
        }
    }


    static class Digit {
        int num;
        String command;

        public Digit (int _num, String _command) {
            num = _num;
            command = _command;
        }
    }
}
