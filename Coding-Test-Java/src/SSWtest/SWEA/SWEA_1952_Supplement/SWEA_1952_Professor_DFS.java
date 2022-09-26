package SSWtest.SWEA.SWEA_1952_Supplement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1952_Professor_DFS {

	static int T, feeDay, feeMonth, fee3Month, feeYear, min;
	static int[] plan = new int[12];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			// 입력 => 변수 및 자료 구조
			StringTokenizer st = new StringTokenizer(br.readLine());
			feeDay = Integer.parseInt(st.nextToken());
			feeMonth = Integer.parseInt(st.nextToken());
			fee3Month = Integer.parseInt(st.nextToken());
			feeYear = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}

			// 완탐 dfs
			// 1년 치 제외한 3가지 사용료 방법을 모두 따지는 방식 진행 각각 min 갱신
			// dfs() 끝나고 나면 min 에 가장 작은 값이 들어가 있음. => 마지막으로 1년치 비용과 비교 최소값
			// min <- 1년치 비용을 넣고 시작 (마지막 비교 X)

			min = feeYear;
			dfs(0, 0); // 최초, 비용 0
			System.out.println("#" + t + " " + min);
		}

	}

// 재귀 호출방식 => 파라미터로 어떤 값을 가지고 계속 이어갈 것인가?
	/*
	static void dfs(int cnt, int sum) {
		// 기저 조건
		if (cnt >= 12) {
			min = Math.min(min, sum);
			return;
		}

		// 계속 따져간다.
		// 이용하지 않는 월에 대한 처리
		if (plan[cnt] == 0) {
			dfs(cnt + 1, sum);
		} else {
			// cnt + 1 번째 달에 대해
			// 1. 일 계산
			dfs(cnt + 1, sum + (plan[cnt] * feeDay));
			// 2. 월 계산
			dfs(cnt + 1, sum + feeMonth);
			// 3. 3개월 계산
			dfs(cnt + 3, sum + fee3Month);
		}
	}
	*/
	
	// 이걸 가지치기 해보자
	static void dfs(int cnt, int sum) {
		// 기저 조건
		if (cnt >= 12) {
			min = Math.min(min, sum);
			return;
		}

		// 계속 따져간다.
		// 이용하지 않는 월에 대한 처리
		if (plan[cnt] == 0) {
			dfs(cnt + 1, sum);
		} else {
			int cost = plan[cnt]*feeDay;
			// cnt + 1 번째 달에 대해
			
			// if 문도 비용이 발생하더라도 (뒤의 로직이 많이 수행되지 않으면 일반적으로 가지치기를 많이한다. 
			// 1. 일 계산
			if(sum + cost < min)
				dfs(cnt + 1, sum + (plan[cnt] * feeDay));
			// 2. 월 계산
			if(sum + fee3Month < min)
				dfs(cnt + 1, sum + feeMonth);
			// 3. 3개월 계산
			if(sum + fee3Month < min)
				dfs(cnt + 3, sum + fee3Month);	
		}
	}
}