package BOJ.Bruteforce.BOJ_14889_스타트와링크;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와링크 {
    static int N, R;
    static int[] nums;
    static int[] othernums;
    static boolean[] check;
    static int min;
    static int[][] arr;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        R = N / 2;
        min = Integer.MAX_VALUE;
        nums = new int[R];
        othernums = new int[R];
        check = new boolean[N];

        // 시너지 입력
        arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        comb(0, 0);
        System.out.println(min);
    }


    // 계산하기
    public static void calc() {
        int start = 0;
        int link = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < R; j++) {
                if(i != j){
                    start += arr[nums[i]][nums[j]];
                    link += arr[othernums[i]][othernums[j]];
                }
            }
        }
        min = Math.min(Math.abs(start - link), min);
    }


    // 경우의 수 뽑기 반개 나누기
    public static void comb(int cnt, int start) {
        if(cnt == R) {
            // 경우의 수 배열 하나랑 나머지 경우의 수 배열 하나 구하기
            int tidx = 0;
            for(int j = 0; j < N; j++) {
                if(!check[j]) {
                    othernums[tidx++] = j;
                }
            }
            calc();
            return;
        }

        for (int i = start; i < N; i++) {
            nums[cnt] = i;
            check[i] = true;
            comb(cnt + 1, i + 1);
            check[i] = false;
        }
    }

}
