package SSWtest.SWEA.SWEA_5644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5644_refactoring_value {

	static class User {
		int x, y;

		public User(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class BC {
		int y, x, coverage, performance;

		public BC(int x, int y, int coverage, int performance) {
			this.x = x;
			this.y = y;
			this.coverage = coverage;
			this.performance = performance;
		}

	}

	static int M, A;
	static User aUser, bUser;
	static BC[] bc;
	static int[] dx = {0, 0, 1, 0, -1};
	static int[] dy = {0, -1, 0, 1, 0};
	static int[] aPath, bPath; // a사용자경로, b사용자 경로
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 총 이동시간
			A = Integer.parseInt(st.nextToken()); // BC갯수

			aPath = new int[M + 1];
			bPath = new int[M + 1];

			// a사용자에 대한 경로, b사용자에 대한 경로
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++)
				aPath[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++)
				bPath[i] = Integer.parseInt(st.nextToken());

			bc = new BC[A];
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int inputX = Integer.parseInt(st.nextToken());
				int inputY = Integer.parseInt(st.nextToken());
				int inputCoverage = Integer.parseInt(st.nextToken());
				int inputPerformance = Integer.parseInt(st.nextToken());
				bc[i] = new BC(inputX, inputY, inputCoverage, inputPerformance);
			}

			aUser = new User(1, 1);
			bUser = new User(10, 10);

			System.out.println("#" + t + " " + solve());
		}
	}

	private static int solve() {
		int ans = 0;
		for (int time = 0; time <= M; time++) {  // 각 시간별 모든 충전소에 접근해서 가장 큰값을 얻는다.
			// 사용자의 위치 이동(aUser, bUser)
			aUser.x += dx[aPath[time]];
			aUser.y += dy[aPath[time]];
			bUser.x += dx[bPath[time]];
			bUser.y += dy[bPath[time]];
			// 해당 시간에 a,b 사용자 좌표에서 최대 충전량 가져오기
			ans += getCharge();
		}
		return ans;
	}

	// 한 타임마다. 충전기에서 a선택과 b선택 경우의 수를 모두 따짐. (중복조합)
	private static int getCharge() {
		int max = 0;
		for (int a = 0; a < A; a++) {    // aUser 선택 BC
			for (int b = 0; b < A; b++) {	// bUser 선택 BC
				int sum = 0;
				// 만약 a사용자가 선택하는 충전기와 b사용자가 선택한 중전기가 같은 경우가 나올 수 있음.
				int aSum = getBCPerformance(a, aUser);
				int bSum = getBCPerformance(b, bUser);
				// 서로 다른 충전기면 서로 충전양 더함. 
				if (a != b) sum = aSum + bSum;
				else 		sum = Math.max(aSum, bSum);
				
				// 현재 계산한게 기존 최대 값 넘으면 갱신함.
				if (max < sum) max = sum;
			}			
		}
		return max;
	}

	// 배터리의 위치와 사용자의 위치를 계산하여 범위에 들어오는지 확인.
	private static int getBCPerformance(int idx, User user) {
		return Math.abs(bc[idx].y - user.y) 
				+ Math.abs(bc[idx].x - user.x) 
				<= bc[idx].coverage ? bc[idx].performance : 0;
	}
}
