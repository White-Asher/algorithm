// SWEA-2056[D1] 연월일 달력

package SWEA.D1;

import java.util.Scanner;

public class SWEA2056D1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        String[] time = new String[t+1];
        scanner.nextLine();
        for (int tc = 1; tc <= t; tc++) {

            time[tc] = scanner.nextLine();
            int year = Integer.parseInt(time[tc].substring(0,4));
            int month = Integer.parseInt(time[tc].substring(4,6));
            int day = Integer.parseInt(time[tc].substring(6,8));

            String result = sol(time[tc], year, month, day);

            System.out.print("#"+tc+" "+result);
            System.out.println();
        }
    }

    public static String sol(String toN, int year, int month, int day){
        if(month >= 13 || month<=0){
            return "-1";
        } else if (month == 2) {
            if(day > 28){
                return "-1";
            }
        }
        else if(day >= 31){
            return "-1";
        }
        else if(year <=0){
            return "-1";
        }

        return toN.substring(0,4) + "/" + toN.substring(4,6)+"/"+toN.substring(6);

    }
}
