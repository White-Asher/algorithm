package BOJ.Implementation;

import java.util.Scanner;

public class BOJ_2567 {
	public static void main(String[] args) {
		int[] dx = {0,0,-1,1};
		int[] dy = {-1,1,0,0};
		
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[101][101];
		int t = sc.nextInt();
		
		int ans = 0;
		int nx = 0;
		int ny = 0;
		int x, y;
		
		for (int i = 0; i < t; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			for(int j = x; j < x+10; j++) {
				for(int k = y; k < y+10; k++) {
					if(map[j][k] == 0) {
						map[j][k] = 1;
					}
				}
			}
			
		}
		
		for(int j = 1; j < 101; j++) {
			for(int k = 1; k < 101; k++) {
				if(map[j][k] == 1) {
					for(int d = 0; d < 4; d++) {
						ny = j + dy[d];
						nx = k + dx[d];
						if(nx >= 0 && nx < 101 && ny >= 0 && ny <101) {
							if(map[ny][nx] == 0) {
								ans++;
							}
						}
					}
					
				}
			}
		}
		System.out.println(ans);
	}
}
