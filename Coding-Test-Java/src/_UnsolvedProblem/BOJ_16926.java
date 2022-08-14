package _UnsolvedProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_16926 {
	// 우, 하, 좌, 상  탐색
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		// N, M, R 입력
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];

		// 배열 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 배열 테두리를 몇 번 돌릴지 계산. (N,M 중 가장 작은 값 / 2)
		int level;
		if (N < M) level = N/2;
		else level = M/2;
		
		// 해당 횟수만큼 돌리기
		for (int r = 0; r < R; r++) {

			for (int j = 0; j < level; j++) {
				// 테두리 마다 시작점 설정
				int x = j;
				int y = j;

				// 한번 테두리를 돌리면 시작점의 값이 없어지므로 temp로 임시 저장. (j, j값)
				int temp = arr[x][y];
				
				// 방향 (우)
				int dire = 0;

				// 우 -> 하 -> 좌 -> 상 방향 진행
				while (dire < 4) {
					// 해당 방향 다음값이
					int nx = x + dx[dire];
					int ny = y + dy[dire];

					// 돌리고자하는 테두리 범위를 벗어나지 않았다면
					if (nx >= j && nx < N - j && ny >= j && ny < M - j) {
						// ex. (1,1) 값에 (1,2)값을 대입
						arr[x][y] = arr[nx][ny];
						// 탐색 좌표 이동 (ex.(1,1) -> (1,2)이동)
						x = nx;
						y = ny;
					} else {
						// 돌리는 테두리 범위를 벗어나면 방향 전환
						dire++;
					}

				}
				// 원래 (j,j)값을 대입
				arr[j + 1][j] = temp;
			}
		}
		// 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				bw.write(arr[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
