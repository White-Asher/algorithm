// SWEA-1986[D2] 지그재그 숫자

package SWEA;

import java.util.Scanner;

public class swea1986D2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 0; tc < T; tc++) {
            int n = sc.nextInt();
            int result = 0;
            for (int i = 1; i <= n; i++) {
                if(i % 2 == 1){
                    result += i;
                } else{
                    result -= i;
                }
            }
            System.out.print("#"+(tc+1)+" "+ result);
            System.out.println();
        }
    }
}
