package BOJ.Math.BOJ_5073_B3_삼각형과세변;

import java.util.*;
import java.io.*;

public class BOJ_5073_B3_삼각형과세변 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String[] input = br.readLine().split(" ");
            int[] num = new int[3];
            num[0] = Integer.parseInt(input[0]);
            num[1] = Integer.parseInt(input[1]);
            num[2] = Integer.parseInt(input[2]);
            Arrays.sort(num);
            int i1 = num[0];
            int i2 = num[1];
            int i3 = num[2];

            if(i1 == 0 && i2 == 0 && i3 == 0) {
                break;
            }

            if (i1 + i2 <= i3) {
                sb.append("Invalid").append("\n");
            } else if(i1 == i2 && i2 == i3) {
                sb.append("Equilateral").append("\n");
            } else if(i1 == i2 || i2 == i3) {
                sb.append("Isosceles").append("\n");
            } else {
                sb.append("Scalene").append("\n");
            }
        }
        System.out.println(sb);
    }
}
