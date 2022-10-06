package SSWtest.SWEA.SWEA_5650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_5650_TEST {
	
	static class WormHole{
		int y, x, no;

		public WormHole(int y, int x, int no) {
			this.y = y;
			this.x = x;
			this.no = no;
		}
		
	}
	
	static StringTokenizer st;
	static int[][] map;
	// 상하 좌우
	static int[] dy = {0,-1,1,0,0};
	static int[] dx = {0,0,0,-1,1};
	static int[][] wormHole;
	static int[][][] wormHoleArr;
	static int startX, startY, N, ans;
	static List<WormHole> wormHoleList;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			
			// 웜홀 리스트 (시간초과)
			wormHoleList = new ArrayList<>();
			
			// 웜홀 배열 초기화
//			wormHoleArr = new int[5][2][2];
//			for (int i = 0; i < 5; i++) {
//				for (int j = 0; j < 2; j++) {
//					for (int j2 = 0; j2 < 2; j2++) {
//						wormHoleArr[i][j][j2] = -1;
//					}
//				}
//			}
			
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int input = Integer.parseInt(st.nextToken());
					map[i][j] = input;
					
					if(input >= 6) {
						// 웜홀 리스트 시간초과
						wormHoleList.add (new WormHole(i, j, input));
//						for (int index = 0; index < 2; index++) {
//							if(wormHoleArr[input][index][0] == 0) {
//								
//							}
//						}
					}
				}
			}
			
			int maxScore = 0;
			// 처음부터 탐색
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 0)
					for (int d = 1; d <= 4; d++) {
						startY = i;
						startX = j;
						simulate(d);
						
						maxScore = Math.max(maxScore, ans);
					}
				}
			}
			
			System.out.printf("#%d %d\n", t, maxScore);
		}
		
	}
	
	
	// 시뮬레이션
	private static void simulate(int d) {
		int x = startX;
		int y = startY;
		ans = 0;
		
		// 처음위치까지 오거나 블랙홀 만날때까지 
		while(true) {
			// 이동할 곳 좌표
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			// 이동할 곳이 인덱스 범위를 넘어섰다면 방향전환과 위치 지정
			if(nx < 0) {
				d = approachWall(d, 5);
				nx = x;
			} else if(ny < 0) {
				d = approachWall(d, 5);
				ny = y;
			} else if(nx >= N) {
				d = approachWall(d, 5);
				nx = x;
			} else if(ny >= N) {
				d = approachWall(d, 5);
				ny = y;
			}
			
			int nextValue = map[ny][nx];
			// 만약 블록 만나면 방향전환하기
			if(nextValue >= 1 && nextValue <= 5) {
				d = approachWall(d, map[ny][nx]);
			}
			
			// 만약 웜홀을 만나면 워프하기
			if (nextValue >= 6 && nextValue <= 10) {
				int[] warp = warpWormHole(ny, nx, map[ny][nx]);
				ny = warp[0];
				nx = warp[1];
			}
			
			// 블랙홀 만나면 정지
			if(map[ny][nx] == -1) break;
			
			// 만약 원점으로 돌아왔다면 정지
			if(nx == startX && ny == startY) break;

			// 이동 좌표 업데이트
			y = ny;
			x = nx;
		}
		
	}
	
	public static int[] warpWormHole(int y, int x, int number) {
		int[] location = new int[2];
		for (int i = 0; i < wormHoleList.size(); i++) {
			WormHole curWormHole = wormHoleList.get(i);
			if(curWormHole.no == number && curWormHole.y != y && curWormHole.x != x) {
				location[0] = curWormHole.y;
				location[1] = curWormHole.x;
			}
		}
		return location;
	}

	//상하 좌우 12 34
	public static int approachWall(int dire, int wall) {
		ans++;
		switch (wall) {
		case 1:
			if(dire == 1) return 2;
			if(dire == 2) return 4;
			if(dire == 3) return 1;
			if(dire == 4) return 3;
		case 2:
			if(dire == 1) return 4;
			if(dire == 2) return 1;
			if(dire == 3) return 2;
			if(dire == 4) return 3;
		case 3:
			if(dire == 1) return 3;
			if(dire == 2) return 1;
			if(dire == 3) return 4;
			if(dire == 4) return 2;
		case 4:
			if(dire == 1) return 2;
			if(dire == 2) return 3;
			if(dire == 3) return 4;
			if(dire == 4) return 1;
		case 5:
			if(dire == 1) return 2;
			if(dire == 2) return 1;
			if(dire == 3) return 4;
			if(dire == 4) return 3;
		default:
			return 0;
		}
		
	}
}
