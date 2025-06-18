package BOJ.Greedy.BOJ_12904_G5_A와B;

import java.util.*;
import java.io.*;

public class BOJ_12904_G5_A와B_250616 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        String start = br.readLine();

        while(true) {
            if(start.length() >= target.length() && start.length() >= 1) {
                char lastchar = start.charAt(start.length() - 1);
                if (start.equals(target)) {
                    System.out.println(1);
                    return;
                }
                if(lastchar == 'A') {
                    start = add(start);
                } else if (lastchar == 'B') {
                    start = reverse(start);
                } else {
                    System.out.println(0);
                    return;
                }
            } else {
                System.out.println(0);
                return;
            }

        }
    }

    public static String add(String str) {
        return str.substring(0, str.length() -1);
    }

    public static String reverse(String str) {
        str = str.substring(0, str.length() -1);
        StringBuilder st = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            st.append(str.charAt(i));
        }
        return st.toString();
    }
}
