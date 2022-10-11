package SSWtest.SWEA.SWEA_4014;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
메모리: 26,992 kb
실행시간: 121 ms
코드길이: 3,349
*/

public class SWEA_4014_V2 {
    static StringTokenizer st;
    static int N, X;
    static int[][] map;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 맵 크기
            X = Integer.parseInt(st.nextToken()); // 경사로 길이
            
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            // 경사로 건설 가능 갯수 변수
            int count = 0;
            
            // 가로 탐색
            for (int i = 0; i < N; i++) {
            	// 경사로를 다시 놓지 않기 위해 boolean배열로 check함
                boolean[] check = new boolean[N];
                outer: for (int j = 1; j < N; j++) {
                    
                    // 탐색값이 이전 탐색 값 보다 2이상 크면, 탐색값이 이전 탐색 값 보다 2이상 작으면 => 경사가 2이상 차이 날 때 -> 건설할 수 없음
                    if (map[i][j] - map[i][j - 1] >= 2 || map[i][j - 1] - map[i][j] >= 2) break outer;

                    // 탐색값이 이전값보다 크다면 (상향) -> 이전탐색 위치부터 경사 확인
                    if (map[i][j] == map[i][j - 1] + 1) {
                        for (int j2 = 1; j2 <= X; j2++) {
                            int nj = j - j2;
                            if (nj < 0 || check[nj]) break outer; // 맵 범위를 넘어서거나 경사로를 건설할 곳에 이미 경사로가 있다면
                            if (map[i][nj] != map[i][j - 1]) break outer; // 길이 X만큼 같은 경사를 건설할 수 없을 때 (건설할 곳이 같은 높이가 아님)
                            check[nj] = true; // 경사로 놓기 체크
                        }
                    }

                    // 탐색값이 이전값보다 작다면 (하향) -> 탐색 위치부터 경사가 확인
                    else if (map[i][j] == map[i][j - 1] - 1) {
                        for (int j2 = 1; j2 <= X; j2++) {
                            int nj = j - 1 + j2;
                            if (nj >= N || check[nj]) break outer;
                            if (map[i][nj] != map[i][j]) break outer;
                            check[nj] = true;
                        }
                    }
                    if (j == N - 1) count++; // 끝까지 탐색이 가능하다면 경사로를 건설할 수 있으므로 count증가 
                }
            }
            
            // 세로 탐색
            for (int j = 0; j < N; j++) {
                boolean[] check = new boolean[N];
                outer: for (int i = 1; i < N; i++) {
                	// 탐색값이 이전값보다 2이상 크면, 또는 탐색값이 이전값보다 2이상 작으면
                    if (map[i][j] - map[i - 1][j] >= 2 || map[i - 1][j] - map[i][j] >= 2) break outer;

                    // 탐색값이 이전값보다 크다면 (상향) -> 이전탐색 위치부터 경사 확인
                    if (map[i][j] == map[i - 1][j] + 1) {
                        for (int i2 = 1; i2 <= X; i2++) {
                            int ni = i - i2;
                            if (ni < 0 || check[ni]) break outer;
                            if (map[ni][j] != map[i - 1][j]) break outer;
                            check[ni] = true;
                        }
                    }

                    // 탐색값이 이전값보다 작다면 (하향) -> 탐색 위치부터 경사가 확인
                    else if (map[i][j] == map[i - 1][j] - 1) {
                        for (int i2 = 1; i2 <= X; i2++) {
                            int ni = i - 1 + i2;
                            if (ni >= N || check[ni]) break outer;
                            if (map[ni][j] != map[i][j]) break outer;
                            check[ni] = true;
                        }
                    }
                    if (i == N - 1) count++;
                }
            }
            
            sb.append("#"+ t +" "+count+"\n");
        }
        System.out.println(sb);
    }

}