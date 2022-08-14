package SWEA.D2;

import java.util.Scanner;

// 1954. 달팽이 숫자
public class SWEA_1954 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			
			int x = 0;
			int y = 0;
			int d = 0;
			
			for (int i = 1; i <= N*N; i++) {
				map[y][x] = i;
				x += dx[d];
				y += dy[d];
				
				if(x < 0 || x >= N || y < 0 || y >= N || map[y][x] != 0) {
					x -= dx[d];
					y -= dy[d];
					d = (d+1) % 4;
					x += dx[d];
					y += dy[d];
				}
			}
			System.out.printf("#%d\n", tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.printf("%d ", map[i][j]);
				}
				System.out.println();
			}
		}
	}
}
