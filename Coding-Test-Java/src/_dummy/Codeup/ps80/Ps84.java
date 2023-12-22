package _dummy.Codeup.ps80;
//
//import java.util.Scanner;
//
//public class Ps84 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int c = sc.nextInt();
//        int sum = 0;
//        for (int i=0; i<a;i++){
//            for (int j=0; j<b;j++){
//                for (int k=0; k<c;k++){
//                    System.out.println(i+" "+j+" "+k);
//                    sum += 1;
//                }
//            }
//        }
//        System.out.println(sum);
//    }
//}

// println은 매우 느린 출력함수이다.

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Ps84 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();

        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<r; i++) {
            for(int j=0; j<g; j++) {
                String str="";
                for(int k=0; k<b;k++) {
                    str += i+" "+j+" "+k+"\n";
                }
                bf.write(str);
                bf.flush();
            }
        }
        System.out.println(r*g*b);
    }
}