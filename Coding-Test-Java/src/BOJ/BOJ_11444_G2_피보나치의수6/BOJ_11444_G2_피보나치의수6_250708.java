package BOJ.BOJ_11444_G2_피보나치의수6;

import java.util.*;
import java.io.*;

public class BOJ_11444_G2_피보나치의수6_250708 {
    final static long MOD = 1_000_000_007;
    public static long[][] baseMatrix = {{1, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        if (n <= 1) {
            System.out.println(n);
            return;
        }

        long[][] resultMatrix = power(baseMatrix, n);

        System.out.println(resultMatrix[0][1]);
    }

    public static long[][] power(long[][] matrix, long exp) {
        if (exp == 1) {
            return matrix;
        }

        long[][] half = power(matrix, exp / 2);
        long[][] squared = multiply(half, half);

        if (exp % 2 == 1) {
            return multiply(squared, baseMatrix);
        }

        return squared;
    }

    public static long[][] multiply(long[][] m1, long[][] m2) {
        long[][] result = new long[2][2];

        result[0][0] = (m1[0][0] * m2[0][0] + m1[0][1] * m2[1][0]) % MOD;
        result[0][1] = (m1[0][0] * m2[0][1] + m1[0][1] * m2[1][1]) % MOD;
        result[1][0] = (m1[1][0] * m2[0][0] + m1[1][1] * m2[1][0]) % MOD;
        result[1][1] = (m1[1][0] * m2[0][1] + m1[1][1] * m2[1][1]) % MOD;

        return result;
    }
}

