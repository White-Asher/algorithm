// BOJ-2615-S2-오목

package BOJ.Implementation;

import java.util.Scanner;

public class BOJ2615 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] map = new int[19+2][19+2];
		
		// 8방향을 탐색하는 것이 아닌 4 방향을 탐색
		// 위 -> 아래, 
		// 왼쪽 -> 오른쪽, 
		// 왼쪽상단 -> 오른쪽 하단, 
		// 왼쪽 하단 -> 오른쪽 상단
		int[] dx = {1,0,1,-1};
		int[] dy = {0,1,1,1};
		
		for(int i = 1; i <= 19; i++) {
			for (int j = 1; j <= 19; j++) {
				map[i][j] = scanner.nextInt();
			}
		}
		scanner.close();
		
		for(int i = 0; i <= 19; i++) {
			for(int j = 1; j <= 19; j++) {
				int curVal = map[i][j];
				if (curVal == 0) continue;
				
				for(int d = 0; d < 4; d++) {
					if(curVal == map[i + dx[d] * -1][j + dy[d] * -1]) continue;
					int count = 1;
					while (curVal == map[i + dx[d] * count][j + dy[d] * count]) ++count;
					
					if (count == 5) {
						System.out.println(curVal);
						System.out.println(i + " " + j);
						return;
					}
				}
			}
		}
		
		System.out.println(0);
	}
}
