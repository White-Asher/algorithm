package BOJ.Math.BOJ_2023_G5_신기한소수;

import java.util.Scanner;

public class BOJ_2023_신기한소수_TimeOut {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int s = (int) Math.pow(10, n - 1);
        int e = (int) Math.pow(10, n);

        StringBuilder sb = new StringBuilder();

        for (int i = s; i < e; i++) {
            boolean flag = false;
            int tar = i;
            while (true) {
                if (!isPrime(tar)) {
                    flag = true;
                    break;
                }
                tar /= 10;
                if(tar <= 0) {
                    break;
                }
            }

            if(!flag) {
                sb.append(i).append("\n");
            }

        }
        System.out.println(sb);
    }

    public static boolean isPrime(int num) {
        if(num < 2) return false;
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
