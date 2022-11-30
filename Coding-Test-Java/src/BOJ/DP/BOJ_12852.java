package BOJ.DP;

import java.util.Scanner;

public class BOJ_12852 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        int[] dp = new int[X + 1];
        int[] path = new int[X + 1];

        String str = "";
        dp[1] = 0;

        for (int i = 2; i <= X; i++) {
            dp[i] = dp[i-1] + 1;
            path[i] = i - 1;

            if(i % 3 == 0 && dp[i / 3] + 1 < dp[i]){
                dp[i] = dp[i / 3] + 1;
                path[i] = i / 3;
            }
            if(i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                dp[i] = dp[i / 2] + 1;
                path[i] = i / 2;
            }
            System.out.println(dp[X]);

            while(X > 0){
                str += X + " ";
                X = path[X];
            }

            System.out.print(str);
        }


    }
}
