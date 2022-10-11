package SSWtest.BOJ.BOJ_17281;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17281_sol2 {
	static int[] order;
	static boolean[] visit;
	static int n;
	static int[][] map;
	static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][9];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		order = new int[9];
		order[3] = 0;
		visit = new boolean[9];
		visit[0] = true;
		select(0);

		System.out.println(answer);
	}

	private static void select(int end) {
		if (end == 9) { // 하나의 팀 구성이 완료되는 때
			int score = play(); // 한번 정해지면 n이닝이 끝날때까지 안바뀐다.
			answer = Math.max(answer, score);
			return;
		}
		if (end == 3) {
			select(end + 1);
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (visit[i] == false) {
				visit[i] = true;
				order[end] = i;
				select(end + 1);
				visit[i] = false;
			}
		}

	}

	private static int play() {
		int score = 0;
		int cur = 0;
		for (int i = 0; i < n; i++) { // n회의 이닝에 대해서
			int base = 0;
			int goal = 1<<4;
			int out = 0; // 아웃 횟수
			while (out < 3) {
				int r = map[i][order[cur % 9]];

				if (r == 0) {
					out++;
				} 
				else {
					base=(base|1);
					for(int j=0;j<r;j++) {
						base = base<<1;
						if((base&goal)>0)
							score++;
					}
				}

				cur++;
			}

		}
		return score;
	}

}