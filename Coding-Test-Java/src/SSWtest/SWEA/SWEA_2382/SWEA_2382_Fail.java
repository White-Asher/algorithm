package SSWtest.SWEA.SWEA_2382;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// start: 11:02 (못품) 테케 47개 통과 -> 실패한 코드 (탐색중에 리스트를 제거했기 때문...)
public class SWEA_2382_Fail {
	
	static int N, M, K;
	static StringTokenizer st;
	
	static class Micro{
		int y, x, dire;
		long amount;
		public Micro(int y, int x, long amount, int dire) {
			this.y = y;
			this.x = x;
			this.amount = amount;
			this.dire = dire;
		}
		@Override
		public String toString() {
			return "Micro [y=" + y + ", x=" + x + ", amount=" + amount + ", dire=" + dire + "]";
		}
		
	}
	static Micro[] microList;
	// 상 1, 하 2, 좌3, 우4
	static int[] dy = {0,-1,1,0,0};
	static int[] dx = {0,0,0,-1,1};
	static int[][] visit;
	static int listSize;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 셀의 개수
			M = Integer.parseInt(st.nextToken()); // 격리시간
			K = Integer.parseInt(st.nextToken()); // 미생물 군집의 개수
			listSize = 0;
			microList = new Micro[K];
			visit = new int[N][N];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				long amount = Long.parseLong(st.nextToken());
				int dire = Integer.parseInt(st.nextToken());
				microList[i] = new Micro(y, x, amount, dire);
				visit[y][x] = 1;
			}
			
			simulation();
			int ans = calcMicroAmount();
			
//			for (int i = 0; i < listSize; i++) {
//				System.out.println(microList[i]);
//			}
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(visit[i][j]);
//				}
//				System.out.println();
//			}
			System.out.printf("#%d %d\n", t, ans);
		}
		
	}

	private static void simulation() {
		listSize = microList.length;
		
		// M시간동안 반복함.
		for (int time = 0; time < M; time++) {
			
			// 미생물이 저장된 배열 돌면서 미생물 이동시키기
			for (int i = 0; i < listSize; i++) {
				Micro curMicro = microList[i];
				int curY = curMicro.y;
				int curX = curMicro.x;
				long curA = curMicro.amount;
				int curD = curMicro.dire;
								
				int ny = curY + dy[curD];
				int nx = curX + dx[curD];
				long na = 0L;
				int nd = 0;
				
				// 원래 있던 지역 방문 원래대로 하기
				visit[curY][curX] -= 1;
				// 새로 이동할 곳 방문 카운트 증가

				visit[ny][nx] += 1;
				// 이동했는데 빨간 구역에 들어간다면?
				if(isForbidArea(ny, nx)) {
					// 방향전환
					nd = changeDire(curD);
					// 미생물 양 반감
					na = (long)Math.ceil((double)(curA/2));
//					na = curA/2;
//					na = (long)((long)curA/(long)2);
					
					
				} else {
					na = curA;
					nd = curD;
				}
				
				curMicro.x = nx;
				curMicro.y = ny;
				curMicro.dire = nd;
				curMicro.amount = na;
			
				
				// 미생물이 죽었다면? 리스트에서 제거하기 -> 이 코드는 여기 있으면 안된다!.
				if(na == 0) {
					// 여기서 탐색 로직을 뺀다면 한번 더 이동하게 되므로 for문 있어야 함. 
					for (int index = 0; index < listSize; index++) {
						Micro searchMicro = microList[index];
						if(searchMicro.amount == 0) {
							microList[index] = microList[listSize-1];
							microList[listSize-1] = null;
							listSize--;
							index--;
							// 방문 해당지역 미생물 수 하나 감소하기
							visit[ny][nx] -= 1;
							break;
						}
					}
				}
				
				
			// 미생물 이동 블록 끝
			}
			
			// 미생물 다 이동하고나서 곂쳐지는지 확인하기 (맵 탐색) 
			for (int searchY = 0; searchY < N; searchY++) {
				for (int searchX = 0; searchX < N; searchX++) {
					// 해당 지점이 미생물이 두개 이상 오는 경우...
					if(visit[searchY][searchX] >= 2) {
						
						long sumAmount = 0; // 미생물 군집 합
						long MaxAmount = 0; // 가장 큰 미생물 군집 수
						int dire = 0; // 가장 큰 미생물 군집 방향
						
						// 미생물 리스트 탐색...
						for (int index = 0; index < listSize; index++) {
							
							// 해당 지점에 마지막 한개 남았을 때 그 미생물이랑 비교하여 데이터 덮어 띄우기
							
							// 배열돌면서 미생물 가져오기 
							Micro curMicro = microList[index];
							// 탐색하는 지점에 있는 미생물을 배열에서 찾았으면
							if(curMicro.y == searchY && curMicro.x == searchX) {
								sumAmount += curMicro.amount; // 미생물 합치기
								if(MaxAmount < curMicro.amount) { // 양이 많다면 해당 미생물 방향을 덮어쓰기
									MaxAmount = curMicro.amount;
									dire = curMicro.dire;
								}
								// 하나 남았으면 거기에 가장 미생물 양 합과 그때의 방향을 입력함 (덮어쓰기)
								if(visit[searchY][searchX] == 1) {
									curMicro.amount = sumAmount;
									curMicro.dire = dire;
									break;
								} 
								// 2이상 있으면.. 리스트에서 하나 지움
								else {
									microList[index] = microList[listSize-1];
									microList[listSize-1] = null;
									listSize--;
									index--;
									// 방문 하는 미생물 수 하나 감소하기
									visit[searchY][searchX] -= 1;									
								}
								
								
							}
							
						}
						
					}
					
					
				}
				
//				System.out.println("listSize : " + listSize);
//				System.out.println("simult");
//				for (int i = 0; i < microList.length; i++) {
//					System.out.println(microList[i]);
//				}
			// 맵 탐색 블록 끝
			}
			
	
			
		//time 블록 끝
		}
		
	}
	
	// 시간이 지나고 남은 미생물 수 구하기
	public static int calcMicroAmount() {
//		System.out.println("calc listSize -> "+listSize);
		int sum = 0;
		for (int i = 0; i < listSize; i++) {
			sum += microList[i].amount;
		}
		return sum;
	}
	
	
	// 미생물이 가장자리(약품이 칠해진 빨간구역) 으로 이동하는가?
	public static boolean isForbidArea(int y, int x) {
		return (y == 0 || x == 0 || y == N-1 || x == N-1);
	}
	
	// 방향 반대방향으로 전환 (상 <->하, 좌<->우)
	public static int changeDire(int dire) {
		if(dire == 1) return 2;
		if(dire == 2) return 1;
		if(dire == 3) return 4;
		if(dire == 4) return 3;
		return 0;
	}
	
}