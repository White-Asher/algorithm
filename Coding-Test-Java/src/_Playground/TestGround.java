package _Playground;

import java.util.*;
import java.io.*;

public class TestGround {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int M = scanner.nextInt();

        M -= 45;

        if (M < 0) {
            M += 60;
            H--;

            if (H < 0) {
                H = 23;
            }
        }

        System.out.println(H + " " + M);
    }
}
