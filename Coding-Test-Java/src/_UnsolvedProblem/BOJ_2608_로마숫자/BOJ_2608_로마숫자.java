package _UnsolvedProblem.BOJ_2608_로마숫자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2608_로마숫자 {
    static String[] num;
    public static void main(String[] args) throws IOException {
        num = new String[1001];
        num[1] = "I"; num[5] = "V"; num[10] = "X"; num[50] = "L"; num[100] = "C"; num[500] = "D"; num[1000] = "M";
        num[4] = "IV"; num[9] = "IX"; num[90] = "XC"; num[400] = "CD"; num[900] = "CM";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a1 = br.readLine();
        String a2 = br.readLine();
        a1 = re(a1);
        a2 = re(a2);
        int b1 = ch(a1);
        int b2 = ch(a2);
        int ansInt = b1 + b2;
        String ansStr = er(sumSt(ansInt));

        System.out.println(ansInt);
        System.out.println(ansStr);
    }

    public static String sumSt (int a) {
        StringBuilder sb = new StringBuilder();
        if (a / 1000 > 0){
            int b = a / 1000;
            for (int i = 0; i < b; i++) {
                sb.append(num[1000]);
            }
            a %= 1000;
        }
        if (a / 100 > 0) {
            int b =  a / 100;
            for (int i = 0; i < b; i++) {
                sb.append(num[100]);
            }
            a %= 100;
        }
        if (a / 10 > 0) {
            int b = a / 10;
            for (int i = 0; i < b; i++) {
                sb.append(num[10]);
            }
            a %= 10;
        }
        if (a > 0) {
            int b = a % 10;
            for (int i = 0; i < b; i++) {
                sb.append(num[1]);
            }
        }
        return sb.toString();
    }

    public static int ch (String a) {
        int num = 0;
        for (int i = 0; i < a.length(); i++) {
            switch (a.charAt(i)){
                case 'I':
                    num+=1;
                    break;
                case 'V':
                    num+=5;
                    break;
                case 'X':
                    num+=10;
                    break;
                case 'L':
                    num+=50;
                    break;
                case 'C':
                    num+=100;
                    break;
                case 'D':
                    num+=500;
                    break;
                case 'M':
                    num +=1000;
                    break;
                default:
                    break;
            }
        }
        return num;
    }

    public static String re(String t) {
        t = t.replace("IV", "IIII");
        t = t.replace("IX", "VIIII");
        t = t.replace("XL", "XXXX");
        t = t.replace("XC", "LXXXX");
        t = t.replace("CD", "CCCC");
        t = t.replace("CM", "DCCCC");
        return t;
    }

    public static String er(String t) {
        t = t.replace("CCCCCCCCC", "CM");
        t = t.replace("CCCC", "CD");
        t = t.replace("XXXXXXXXX", "XC");
        t = t.replace("XXXX", "XL");
        t = t.replace("IIIIIIIII", "IX");
        t = t.replace("IIII", "IV");
        return t;
    }
}

