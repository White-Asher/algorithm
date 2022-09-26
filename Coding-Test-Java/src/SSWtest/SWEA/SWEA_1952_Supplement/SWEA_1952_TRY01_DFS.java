package SSWtest.SWEA.SWEA_1952_Supplement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1952_TRY01_DFS {
	static int[] way;
	static int[] monthPlan;
	static int ans = 0;
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테케 수 입력
		int T = Integer.parseInt(br.readLine());
		
		// 테스트 케이스 시작
		for(int t = 1; t <= T; t++) {
			
			way = new int[4];
			monthPlan = new int[13];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				way[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < 13; i++) {
				monthPlan[i] = Integer.parseInt(st.nextToken());
			}
			
			ans = way[3];
			
			DFS(1,0);
			
			System.out.printf("#%d %d\n", t, ans);
		}
	}

	private static void DFS(int month, int totalPrice) {
		if(month >=13) {
			ans = Math.min(totalPrice, ans);
			return;
		}
		
		if(monthPlan[month] == 0) {
			DFS(month+1, totalPrice);
		}
		
		DFS(month+1, totalPrice + monthPlan[month]*way[0]);
		DFS(month+1, totalPrice + way[1]);
		DFS(month+3, totalPrice + way[2]);
		
	}
}
