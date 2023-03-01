package _OnlineContest.SCUPC2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pro_A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int sNum = 0;
        int bNum = 0;

        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == 'b'){
                i += 6;
                bNum += 1;
            } else if (input.charAt(i) == 's') {
                i += 7;
                sNum += 1;
            }
        }

        if(sNum < bNum) System.out.println("bigdata?");
        else if(sNum > bNum) System.out.println("security!");
        else if(sNum == bNum) System.out.println("bigdata? security!");
    }
}
