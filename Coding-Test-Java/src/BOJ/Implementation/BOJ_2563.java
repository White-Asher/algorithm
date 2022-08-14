package BOJ.Implementation;
import java.util.Scanner;

public class BOJ_2563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[100][100];
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int j = x; j<x+10; j++) {
				for(int k = y; k<y+10; k++) {
					if(map[j][k] == 0) {
						map[j][k] = 1;
					}
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j] == 1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}