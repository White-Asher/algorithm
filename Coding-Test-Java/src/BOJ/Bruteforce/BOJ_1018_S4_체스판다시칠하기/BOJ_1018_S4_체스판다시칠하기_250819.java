package BOJ.Bruteforce.BOJ_1018_S4_체스판다시칠하기;

import java.util.*;
import java.io.*;

public class BOJ_1018_S4_체스판다시칠하기_250819 {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j);
            }
        }

        // 두가지 케이스 봐야지

        // 첫번째칸이 화이트거나
        int ans1 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ans1 += check(true, i ,j);
            }
        }

        // 첫번째칸이 블랙이거나
        int ans2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ans2 += check(true, i ,j);
            }
        }

        System.out.println(Math.min(ans2, ans1));

    }

    public static int check(boolean flag, int y, int x) {
        int ans = 0;

        if(flag) {
            if (y % 2 == 0) {
                if (x % 2 == 0) {
                    if (arr[y][x] == 'B') {
                        ans++;
                    }
                } else {
                    if (arr[y][x] == 'W') {
                        ans++;
                    }
                }
            } else {
                if (x % 2 == 0) {
                    if (arr[y][x] == 'W') {
                        ans++;
                    }
                } else {
                    if (arr[y][x] == 'B') {
                        ans++;
                    }
                }
            }
        }else {
            if (y % 2 == 0) {
                if (x % 2 == 0) {
                    if (arr[y][x] == 'W') {
                        ans++;
                    }
                } else {
                    if (arr[y][x] == 'B') {
                        ans++;
                    }
                }
            } else {
                if (x % 2 == 0) {
                    if (arr[y][x] == 'B') {
                        ans++;
                    }
                } else {
                    if (arr[y][x] == 'W') {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }
}
