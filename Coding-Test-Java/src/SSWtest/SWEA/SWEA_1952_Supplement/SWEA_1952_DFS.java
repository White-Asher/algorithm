package SSWtest.SWEA.SWEA_1952_Supplement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1952_DFS {
	
	static StringTokenizer st;
	static int[] way;
	static int[] monthPlan;
	static int minPrice;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			monthPlan = new int[13];
			way = new int[4];
			st = new StringTokenizer(br.readLine());
			// 이용권 가격 받기
			for (int i = 0; i < 4; i++) {
				way[i] = Integer.parseInt(st.nextToken());
			}
			
			// 이용 계획 받기 (1월 12월까지)
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < 13; i++) {
				monthPlan[i] = Integer.parseInt(st.nextToken());
			}
			
			minPrice = way[3];
			
			// DFS 완탐
			DFS(1, 0);
			
			System.out.printf("#%d %d\n", t, minPrice);
			 
		}
	}
	
	public static void DFS(int month, int totalPrice) {
		// 마지막 달 까지 전부 계산
		if(month >= 13) {
			minPrice = Math.min(totalPrice, minPrice);
			return;
		}
		
		// 해당 날짜 사용계획이 없다면 (즉 0일때) 다음달 탐색
		if(monthPlan[month] == 0) {
			DFS(month+1, totalPrice);
		}
		// 하루이용권
		DFS(month+1, totalPrice + way[0]*monthPlan[month]);
		// 1달이용권
		DFS(month+1, totalPrice + way[1]);
		// 3달이용권
		DFS(month+3, totalPrice + way[2]);
		
	}
}
