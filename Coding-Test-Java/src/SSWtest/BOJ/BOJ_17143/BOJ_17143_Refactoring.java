package SSWtest.BOJ.BOJ_17143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17143_Refactoring {

	static class Shark {
		int r, c, s, d, z;

		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

	}

	static int R, C, M, ans;
	static Shark[][] shark;

	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = 0;
		
		shark = new Shark[R+2][C+2];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			shark[r][c] = new Shark(r, c, s, d, z);

		}

		sol();
		System.out.println(ans);
	}

	public static void sol() {
		int fisherLocation = 1;
		while (true) {
			System.out.println("fisherLocation : "+ fisherLocation);
			System.out.println("time");
			for (int i = 0; i <= R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(shark[i][j]);
				}
				System.out.println();
			}
			
			getFish(fisherLocation);
			System.out.println("get");
			for (int i = 0; i <= R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(shark[i][j]);
				}
				System.out.println();
			}
			
			moveShark();
			System.out.println("move");
			for (int i = 0; i <= R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(shark[i][j]);
				}
				System.out.println();
			}
			fisherLocation++; // 낚시왕 이동
			if (fisherLocation == C+1)
				break; // 낚시왕이 끝가지 이동하면 멈춤
		}
	}

	private static void moveShark() {
		
		Shark[][] copyShark = copyShark();
		
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if(shark[i][j] == null) continue;
				
				Shark curShark = shark[i][j];
				
				int r = curShark.r;
				int c = curShark.c;
				int s = curShark.s;
				int d = curShark.d;
				int z = curShark.z;
				
				switch (d) {
				
				case 1: // 상
					if(r - s >= 1) r -= s;
					else {
						s -= r - 1;
						int mod1 =  s % (R - 1) ;
						int divide1 = s / (R - 1);
						
						if(divide1 % 2 == 0) { 
							r = 1 + mod1;
							d = 2;
						} else {
							r = R - mod1;
							d = 1;
						} 
					}
					break;

				case 2: // 하
					
					if(r + s <= R) r += s;
					else {
						s -= R - r;
						int mod2 =  s % (R - 1);
						int divide2 = s / (R - 1);
						
						if(divide2 % 2 == 0) {
							r = R - mod2;
							d = 1;
						} else {
							r = 1 + mod2;
							d = 2;
						}
						
					}
					
					break;
					
				case 3: // 우
					if(c + s <= C) c += s;
					else {
						s -= C - c;
						int mod3 =  s % (C - 1);
						int divide3 = s / (C - 1);
						
						if(divide3 % 2 == 0) { 
							c = C - mod3;
							d = 4;
						} else {
							c = 1 + mod3;
							d = 3;
						}
					}
					
					break;
					
				case 4: // 좌
					if(c - s >= 1) c -= s;
					else {
						s -= c - 1;
						int mod4 = s % (C - 1);
						int divide4 = s / (C - 1);
						
						if(divide4 % 2 == 0) { 
							c = 1 + mod4;
							d = 3;
						} else {
							c = C - mod4;
							d = 4;
						}
						
					}
					
					break;
					
				default:
					break;
				}
				
				if(copyShark[r][c] != null) {
					if(copyShark[r][c].z < curShark.z) {
						copyShark[r][c] = new Shark(r, c, curShark.s, d, curShark.z);
						copyShark[curShark.r][curShark.c] = null;
					}
				} else {
					copyShark[curShark.r][curShark.c] = null;
				}
				

			}
		}
		
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				shark[i][j] = copyShark[i][j];
			}
		}
		
		
	}
	
	public static Shark[][] copyShark(){
		Shark[][] temp = new Shark[R+2][C+2];
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				temp[i][j] = shark[i][j];
			}
		}
		return temp;
	}

	public static void getFish(int fisherLocation) {
		
		for (int i = 1; i <= R; i++) {
			Shark curShark = shark[i][fisherLocation];
			if(curShark != null) {
				ans += curShark.z;
				System.out.println(curShark.z);
				shark[i][fisherLocation] = null;
				break;
			}
			
		}
	}

}
