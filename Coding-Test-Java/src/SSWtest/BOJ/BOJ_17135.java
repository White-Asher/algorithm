package SSWtest.BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_17135 {
	static final int ARCHER_NUMBER = 3;
	static int killEnemyNumber = Integer.MIN_VALUE;
	static int N, M, D;
	static int[] archer = new int[ARCHER_NUMBER];
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		inputData();
		comb(0, 0);
		bw.write(String.valueOf(killEnemyNumber));
		bw.flush(); bw.close();
	}
	
	public static void solution() {
		int[][] copyMap = copyMap(); // 아처가 성벽에 있는 경우의 수 마다 최대값 계산하므로 원래의 맵 복사
		int caseResult = 0;
		
		for (int time = N; time >= 1; time--) { // 턴 
			boolean[][] visited = new boolean[N][M];
			
			for(int a = 0; a < ARCHER_NUMBER; a++) { // 아처 수만큼 반복
				int archerCol = archer[a]; // 아처 열 위치
				int minDistance = Integer.MAX_VALUE; // 최소 거리
				int minDistanceRow = Integer.MAX_VALUE; // 최소 거리의 행 좌표
				int minDistanceCol = Integer.MAX_VALUE; // 최소 거리의 열 좌표
				
				// 맵 탐색  (좌 하 -> 우 상(최대거리까지 탐색))
				for (int r = time-1; r >= (r-D < 0 ? 0: r-D) ; r--) {
					for (int c = 0; c < M; c++) {
						
						if (copyMap[r][c] == 1) { // 적이 있다면 
							if (minDistance >= calcDistance(r, c, time, archerCol)) { // 현재 거리보다 더 짧은 거리를 탐색했을 경우 최단 거리를 업데이트
								if (minDistance > calcDistance(r, c, time, archerCol)) {
									minDistance = calcDistance(r, c, time, archerCol);
									minDistanceRow = r;
									minDistanceCol = c;
								} else {
									if (minDistanceCol > c) { // 최소 거리와 현재 탐색한 위치가 최소 거리가 같을 경우 탐색 위치가 최소거리의 열 좌표보다 왼쪽 인지 검사.
										minDistanceRow = r;
										minDistanceCol = c;
									}
								}
							}
						}
						
						
					}
				}
				if (minDistance <= D) visited[minDistanceRow][minDistanceCol] = true;
			}
			caseResult += countKill(copyMap, visited, time);
		}
		killEnemyNumber = Math.max(killEnemyNumber, caseResult);
	}
	
	public static int countKill(int[][] copyMap, boolean[][] visited, int time) {
		int res = 0;
		for(int r = 0; r < time; r++) {
			for (int c = 0; c < M; c++) {
				if(visited[r][c]) {
					copyMap[r][c] = 0;
					res++;
				}
			}
		}
		return res;
	}
	
	public static int calcDistance(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}
	
	public static void comb(int cnt, int start) {
		if(cnt == ARCHER_NUMBER) {
			solution();
			return;
		}
		for (int i = start; i < M; i++) {
			archer[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
	
	public static int[][] copyMap() {
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) temp[i][j] = map[i][j];
		return temp;
	}

	public static void inputData() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N+1][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
	}
}
