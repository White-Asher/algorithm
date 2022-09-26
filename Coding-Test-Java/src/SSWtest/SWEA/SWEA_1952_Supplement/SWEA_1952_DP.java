package SSWtest.SWEA.SWEA_1952_Supplement;

import java.io.*;
import java.util.*;

public class SWEA_1952_DP {
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
			// 이용권 가격 입력
			for (int i = 0; i < 4; i++) {
				way[i] = Integer.parseInt(st.nextToken());
			}
			
			minPrice = way[3];
			// 이용계획 입력하면서 가장 작은 비용 계산
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < 13; i++) {
				int pointMonth = Integer.parseInt(st.nextToken());
				// 하루로 결제한 것과 한달로 결제한 것과 비교
				monthPlan[i] = Math.min((monthPlan[i-1] + pointMonth * way[0]), monthPlan[i-1] + way[1]);
				// 3월달 이후부터 3달 결제했을 때 비교
				if(i >= 3) {
					monthPlan[i] = Math.min(monthPlan[i], monthPlan[i-3] + way[2]);					
				}
			}
			// 하루, 한달, 세달씩 결제해서 가장 최소 비용과 1년 비용 비교
			monthPlan[12] = Math.min(monthPlan[12], minPrice);
			System.out.printf("#%d %d\n", t, monthPlan[12]);
		}
	}

}
