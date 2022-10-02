package SSWtest.SWEA.SWEA_2117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_2117_TRY01 {
	static StringTokenizer st;
	static int[][] map;
	static int N, M, ans, K;
	static List<House> houseList;
	// 도시크기, 지불비용
	static class House{
		int x, y;

		public House(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			houseList = new ArrayList<>();
			ans = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] > 0)
						houseList.add(new House(i,j));
				}
			}
			
			solution();
			
			System.out.printf("#%d %d\n", t, ans);
		}
	}
	
	private static void solution() {
		K = N+1;
		while(K != 0) {
//			System.out.println("K : "+ K);
			if (K == 0)	break;
			
			for (int serviceX = 0; serviceX < N; serviceX++) {
				for (int serviceY = 0; serviceY < N; serviceY++) {
					int profit = 0;
					int house = 0;
					
					for (int index = 0; index < houseList.size(); index++) {
						int houseX = houseList.get(index).x;
						int houseY = houseList.get(index).y;
						if(checkDist(houseX, houseY, serviceX, serviceY)) {
							profit += M;
							house += 1;
						}
					}
					if(calcProfit(profit)) {
//						System.out.println(house);
						ans = Math.max(house, ans);
					}
					
				}
			}
			K -= 1;
		}
		
	}
	
	public static boolean calcProfit(int profit) {
		int cost = K * K + (K-1) * (K-1) ;
		return (profit - cost) >= 0;
	}

	public static boolean checkDist(int houseX, int houseY, int serviceX, int serviceY) {
		// System.out.println("houseX : "+ houseX+ "| houseY : "+ houseY + "| serviceX : " + serviceX+ "| serviceY : "+ serviceY + "| K : " + K + "result : " + (Math.abs(houseX-serviceX) + Math.abs(houseY-serviceY) <= K));
		return Math.abs(houseX-serviceX) + Math.abs(houseY-serviceY) <= K-1;
	}
}
