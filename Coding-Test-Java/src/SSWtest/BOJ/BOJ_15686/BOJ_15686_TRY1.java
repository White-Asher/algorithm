package SSWtest.BOJ.BOJ_15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class BOJ_15686_TRY1 {
	static StringTokenizer st;
	static int N, M;
	static class Point{
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static List<Point> houseList;
	static List<Point> chickenList;
	static int[] pick;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		houseList = new ArrayList<>();
		chickenList = new ArrayList<>();
		ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int input = Integer.parseInt(st.nextToken());
				if(input == 1) houseList.add(new Point(i, j));
				else if(input == 2) chickenList.add(new Point(i,j));
			}
			
		}
		
		pick = new int[M];
		
		combination(0,0);
		System.out.println(ans);
	}
	
	public static void combination(int cnt, int start) {
		if(cnt == M) {
//			System.out.println(Arrays.toString(pick));
			solution();
			return;
		}
		
		for (int i = start; i < chickenList.size(); i++) {
			pick[cnt] = i;
			combination(cnt+1, i+1);
		}
	}
	
	public static void solution() {
		// 뽑힌 치킨 인덱스돌면서
		int totalDist = 0;
		for (int i = 0; i < houseList.size(); i++) {
			Point curHouse = houseList.get(i);
			int curHouseX = curHouse.x;
			int curHouseY = curHouse.y;
			
			// 집과 거리를 계산함 가장 짧은 거리 킵
			int minDist = Integer.MAX_VALUE;
			for (int j = 0; j < pick.length; j++) {
				Point curChicken = chickenList.get(pick[j]);
				int curChickenX = curChicken.x;
				int curChickenY = curChicken.y;
				
				minDist = Math.min(calcDist
				(curChickenX, curHouseX, curChickenY, curHouseY), minDist);
				
			}
			totalDist += minDist;
			
		}
		ans = Math.min(ans, totalDist);
	}
	
	
	public static int calcDist(int x1, int x2, int y1, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}