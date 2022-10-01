package SSWtest.SWEA_5644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*none*/
public class SWEA_5644_TRY_01 {
	
	static class User{
		int r, c;
		User(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	static class BC {
		int r, c, coverage, performance;
		
		public BC(int c, int r, int coverage, int performance) {
			this.r = r;
			this.c = c;
			this.coverage = coverage;
			this.performance = performance;
		}
	}
	
	static int M, A;
	static User aUser, bUser;
	static BC[] bc;
	static int[] dr = {0, -1, 0, 1, 0};
	static int[] dc = {0, 0, 1, 0, -1};
	static int[] aPath, bPath;
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			aPath = new int[M+1];
			bPath = new int[M+1];
			
			// a사용자 경로, b사용자 경로
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
				int inputX = Integer.parseInt(st.nextToken());
				int inputY = Integer.parseInt(st.nextToken()); 
				int inputCoverage = Integer.parseInt(st.nextToken());
				int inputPerformace = Integer.parseInt(st.nextToken());
				bc[i] = new BC(inputX, inputY, inputCoverage, inputPerformace);
			}
			
			aUser = new User(1,1);
			bUser = new User(10,10);
			
			System.out.printf("#%d %d\n", t, solve());
		}

	}

	private static int solve() {
		int ans = 0;
		for (int time = 0; time < M; time++) {
			aUser.r += dr[aPath[time]];
			aUser.c += dc[aPath[time]];
			bUser.r += dr[bPath[time]];
			bUser.c += dc[bPath[time]];
			ans += getCharge();
		}
		return ans;
	}

	private static int getCharge() {
		int max = 0;
		for (int a = 0; a < A; a++) {
			for (int b = 0; b < A; b++) {
				int sum = 0;
				int aSum = getBCPerformance(a, aUser);
				int bSum = getBCPerformance(b, bUser);
				
				if(a != b) {
					sum = aSum + bSum;
				} else {
					sum = Math.max(aSum, bSum);
				}
				
				if(max < sum)
					max = sum;
				
			}
		}
		
		return max;
	}

	private static int getBCPerformance(int idx, User user) {
		return (Math.abs(bc[idx].r - user.r) + Math.abs(bc[idx].c - user.c)) <= bc[idx].coverage ? bc[idx].performance : 0;
	
		
	}
	
	
	
}

