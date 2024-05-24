package BOJ.DataStructure.Hash.BOJ_1972_S3_놀라운문자열;

import java.util.*;
import java.io.*;

public class BOJ_1972_S3_놀라운문자열 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String input = br.readLine();

            if(input.equals("*")) break;
            boolean flag = true;
            for(int j = 1; j <= input.length() / 2; j++) {
                Set<String> set = new HashSet<>();
                for(int i = 0; i < input.length() - j; i++) {
                    StringBuilder str = new StringBuilder();
                    str.append(input.charAt(i)).append(input.charAt(i+j));
                    if(set.contains(str.toString())) {
                        flag = false;
                        break;
                    } else {
                        set.add(str.toString());
                    }

                }
            }
            if(flag) sb.append(input).append(" is surprising.\n");
            else sb.append(input).append(" is NOT surprising.\n");

        }
        System.out.println(sb);
    }
}
