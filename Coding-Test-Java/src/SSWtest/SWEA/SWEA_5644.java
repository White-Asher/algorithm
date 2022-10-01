package SSWtest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5644 {
	static class User{
		int x;
		int y;
		public User(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static class BC{
		int x;
		int y;
		int coverage;
		int performance;
		
		public BC(int x, int y, int coverage, int performance) {
			this.x = x;
			this.y = y;
			this.coverage = coverage;
			this.performance = performance;
		}
		
	}
	static StringTokenizer st; 
	static int M, A;
	static User aUser, bUser;
	static int[] aPath;
	static int[] bPath;
	static BC[] bc;
	static int[] dx = {0, 0, 1, 0, -1};
	static int[] dy = {0, -1, 0, 1, 0};
	
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
			for (int i = 0; i < M; i++) {
				aPath[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				bPath[i] = Integer.parseInt(st.nextToken());
			}
			
			bc = new BC[A];
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				
				bc[i] = new BC(x,y,c,p);
			}
			
			aUser = new User(1,1);
			bUser = new User(10,10);
			
			System.out.printf("#%d %d\n", t, solve());
		}
		
	}
	
	public static int solve() {
		int ans = 0;
		for (int time = 0; time < M; time++) {
			aUser.x += dx[aPath[time]];
			aUser.y += dy[aPath[time]];
			bUser.x += dx[bPath[time]];
			bUser.y += dy[bPath[time]];
			
			ans += getCharge();
		}
		return ans;
	}

	private static int getCharge() {
		int max = 0;
		for (int i = 0; i < A; i++) {
			for (int j = 0; j < A; j++) {
				int sum = 0;
				int aSum = getBCPerformance(i, aUser);
				int bSum = getBCPerformance(j, aUser);
				if(i != j)
					sum = aSum +bSum;
				else 
					sum = Math.max(aSum, bSum);
				
				if (max < sum)
					max = sum;
			}
			
		}
		
		return max;
	}

	private static int getBCPerformance(int x, User user) {
		return Math.abs(bc[x].x - user.x) + Math.abs(bc[x].y - user.y) <= bc[x].coverage ?
				bc[x].performance : 0;
	}
}
