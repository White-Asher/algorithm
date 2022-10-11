package SSWtest.SWEA.SWEA_5644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_5644_TRY2 {
	static StringTokenizer st;
	static int M, A, ans;
	static BC[] bcList;
	
	static class BC{
		int r, c, potential, distance;

		public BC(int c, int r, int distance, int potential) {
			this.r = r;
			this.c = c;
			this.potential = potential;
			this.distance = distance;
		}	
	}
	static class User{
		int r, c;

		public User(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int[] aPath;
	static int[] bPath;
	
	static int[] dr = {0, -1, 0, 1, 0};
	static int[] dc = {0, 0, 1, 0, -1};
	static User aUser;
	static User bUser;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			aPath = new int[M+1];
			bPath = new int[M+1];
			
			bcList = new BC[A];
			
			// a경로
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				aPath[i] = Integer.parseInt(st.nextToken()); 
			}
			
			// b경로 
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				bPath[i] = Integer.parseInt(st.nextToken()); 
			}
			
			// 충전소...
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int dist = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				bcList[i] = new BC(r,c,dist,p);
			}
			aUser = new User(1,1);
			bUser = new User(10,10);
			
			int ans = move();
			System.out.printf("#%d %d\n", t, ans);
		}// test-case end
	}
	
	public static int move() {
		int ans = 0;
		for (int time = 0; time <= M; time++) {  // 각 시간별 모든 충전소에 접근해서 가장 큰값을 얻는다.
			// 사용자의 위치 이동(aUser, bUser)
			aUser.r += dr[aPath[time]];
			aUser.c += dc[aPath[time]];
			bUser.r += dr[bPath[time]];
			bUser.c += dc[bPath[time]];
			// 최대 충전량 가져오기
			ans += getSumCharge();
		}
		return ans;
	}

	private static int getSumCharge() {
		int maxCharge = 0;
		for (int a = 0; a < A; a++) {
			for (int b = 0; b < A; b++) {
				int sumChange = 0;
				
				int aCharge = isCoverage(a, aUser);
				int bCharge = isCoverage(b, bUser);
				
				if(a != b) sumChange = aCharge + bCharge; 
				else sumChange = Math.max(aCharge , bCharge);
				
				
				if(maxCharge < sumChange) 
					maxCharge = sumChange;
			}
		}
		return maxCharge;
		
	}
	
	public static int isCoverage(int index, User user) {
		return (Math.abs(bcList[index].r - user.r) 
				+ Math.abs(bcList[index].c - user.c)) 
				<= bcList[index].distance ? bcList[index].potential : 0; 
	}
	
}
