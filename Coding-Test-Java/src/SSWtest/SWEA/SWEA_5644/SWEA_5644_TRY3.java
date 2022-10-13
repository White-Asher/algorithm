package SSWtest.SWEA.SWEA_5644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_5644_TRY3 {
	static StringTokenizer st;
	static int M, A;
	
	static class User{
		int x, y;
		public User(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class BC{
		int x, y, coverage, power;
		public BC(int y, int x, int coverage, int power) {
			this.x = x;
			this.y = y;
			this.coverage = coverage;
			this.power = power;
		}
	}
	static User aUser;
	static User bUser;
	static int[] aPath;
	static int[] bPath;
	static List<BC> bcList;
	// 상 우 하 좌
	static int[] dx = {0,-1,0,1,0};
	static int[] dy = {0,0,1,0,-1};
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			aPath = new int[M+1];
			bPath = new int[M+1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) aPath[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) bPath[i] = Integer.parseInt(st.nextToken());
			
			bcList = new ArrayList<>();
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int coverage = Integer.parseInt(st.nextToken());
				int power = Integer.parseInt(st.nextToken());
				bcList.add(new BC(x, y, coverage, power));
			}
			aUser = new User(1,1);
			bUser = new User(10,10);
			
			ans = 0;
			move();
			System.out.printf("#%d %d\n", t, ans);
		}
		
	}
	
	public static void move() {
		for (int i = 0; i <= M; i++) {
			aUser.x += dx[aPath[i]];
			aUser.y += dy[aPath[i]];
			bUser.x += dx[bPath[i]];
			bUser.y += dy[bPath[i]];
			searchBC();
		}
	}

	private static void searchBC() {
		// a,b사용자 위치에서 BC리스트 안에 들어있는거 찾고 뽑아봄.
		int maxSum = 0;
		for (int a = 0; a < A; a++) {
			for (int b = 0; b < A; b++) {
				// a차지
				int sum = 0;
				int aCharge = getCharge(aUser, a);
				// b차지
				int bCharge = getCharge(bUser, b);
				// 비교
				if(a == b) {
					sum = Math.max(aCharge, bCharge);
				} else if (a != b) {
					sum = aCharge + bCharge;
				}
				maxSum = Math.max(sum, maxSum);
			}
		}
		ans += maxSum;
	}
	
	public static int getCharge(User user, int index) {
		BC curBC = bcList.get(index);
		int curX = curBC.x;
		int curY = curBC.y;
		int curCoverage = curBC.coverage;
		if(isCoverage(user.x, curX, user.y, curY, curCoverage)) return curBC.power;
		return 0;
	}
	
	public static boolean isCoverage(int x1, int x2, int y1, int y2, int coverage) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2) <= coverage;
	}
}
