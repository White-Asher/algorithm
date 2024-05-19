package BOJ.DataStructure.LinkedList.BOJ_1406_S2_에디터;

import java.util.*;
import java.io.*;

public class BOJ_1406_S2_에디터_TRY1 {
    static String str;
    static int cur;
    static int N;
    static int idx;
    static LinkedList<Character> list = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        str = br.readLine();
        N = str.length();
        cur = N;
        for (int i = 0; i < N; i++) {
            list.add(str.charAt(i));
        }
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            func(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : list) {
            sb.append(c);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void func(String input) {
//        System.out.println(idx++);
//        System.out.println("N : " + N);
//        System.out.println("cur : " + cur);
        switch (input.charAt(0)) {
            case 'L' :
                cur--;
                if(cur < 0) {
                    cur = 0;
                }
                break;

            case 'D':
                cur++;
                if(cur > N){
                    cur = N;
                }
                break;

            case 'B':
                if(cur == 0) break;
                list.remove(cur-1);
                cur--;
                N--;
                if(cur < 0) {
                    cur = 0;
                }
                break;
            case 'P':
//                System.out.println("P cur : " + cur);
//                System.out.println("val : " + input.charAt(2) );
                list.add(cur, input.charAt(2));
                N++;
                cur++;
                break;
            default:
                break;
        }
    }
}
