package SSWtest.BOJ.BOJ_17143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;



public class BOJ_17143_WrongWay {
	static class Shark{
		int r, c, s, d, z;
		boolean alive;

		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		public Shark(int r, int c, int s, int d, int z, boolean alive) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
			this.alive = true;
		}
		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}
	}
	
	static int R, C, M;
	static StringTokenizer st;
	static List<Shark> sharkList;
	static int[][] map;
	static int ans;
	// 1 : 상, 2: 하 , 3: 우 , 4: 좌
	static int[] dr = {0,-1,1,0,0};
	static int[] dc = {0,0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[R+1][C+1];

		ans = 0;
		
		sharkList = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			sharkList.add(new Shark(r,c,s,d,z,true));
			
			map[r][c] = z; 
		}
		
//		System.out.println("initial");
//		for (int i = 0; i < sharkList.size(); i++) {
//			System.out.println(sharkList.get(i));
//		}
		
		System.out.println(Arrays.deepToString(map));
		sol();
		System.out.println(ans);
	}
	
	public static void getFish(int fisherLocation) {
		
		for (int i = 1; i <= R; i++) {
			
			if(map[i][fisherLocation] != 0) {
				ans += map[i][fisherLocation];
				
//				System.out.println(map[i][fisherLocation]);
				map[i][fisherLocation] = 0;
				
				for (int j = 0; j < sharkList.size(); j++) {
					Shark temp = sharkList.get(j);
//					System.out.println(temp.toString());
					
					int r = temp.r;
					int c = temp.c;
					
					if(r == i && c == fisherLocation && temp.alive == true) {
//						System.out.println("r : "+r + " c: "+c);
//						System.out.println(sharkList.get(j));
//						System.out.println("===");
						temp.alive = false;
					}
				}
				return;
			}
		}
	}
	
	public static int[] moveShark(int inputr, int inputc, int inputs, int inputd, int inputz) {
		
			int r = inputr;
			int c = inputc;
			int s = inputs;
			int d = inputd;
			int z = inputz;
	
			int originR = r;
			int originC = c;
			
			if(s == 0) return new int[] {r,c,s,d,z};
			System.out.println("origin Shark [r=" + inputr + ", c=" + inputc + ", s=" + inputs + ", d=" + inputd + ", z=" + inputz + "]");
			
			// 1 : 상, 2: 하 , 3: 우 , 4: 좌
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
					
					if(divide3 % 2 == 0) { //몫이 짝수
						c = C - mod3;
						d = 4;
					} else { // 홀수
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
					
					if(divide4 % 2 == 0) { //몫이 짝수
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

			System.out.println("move Shark [r=" + r + ", c=" + c + ", s=" + inputs + ", d=" + d + ", z=" + inputz + "]");
			// 상어가 이동한 방향에 상어넣기
			
			// 해당 지점에 상어 있으면 크고 작음 비교
			if(map[r][c] != 0 ) {
				if(map[originR][originC] > map[r][c]) { // 기존 상어가 이동할 곳에 있는 상어보다 크면 리스트에서 제거함
					for (int sharkIdx = 0; sharkIdx < sharkList.size(); sharkIdx++) {
						Shark curShark = sharkList.get(sharkIdx);
						int curR = curShark.r;
						int curC = curShark.c;
						if(curR == r && curC == c && curShark.alive) {
							curShark.alive = false;
						}
					}
				}
				// 기존 상어가 이동할 곳에 있는 상어보다 작으면 기존 상어 제거함.  
				else {
					for (int sharkIdx = 0; sharkIdx < sharkList.size(); sharkIdx++) {
						Shark curShark = sharkList.get(sharkIdx);
						int curR = curShark.r;
						int curC = curShark.c;
						if(curR == r && curC == c && curShark.alive) {
							curShark.alive = false;
						}
					}
				}
			}
			
			//원래있던 상어 없애기
			map[originR][originC] = 0;
			map[r][c] = inputz;
			
			return new int[] {r, c, inputs, d, inputz};
		
	}
	
	public static void sol() {
		int fisherLocation = 1;
		while(true) {
			System.out.println("fisherLocation : "+ fisherLocation);
//			System.out.println("map : " + Arrays.deepToString(map));
			
			System.out.println("time");
			for (int i = 0; i <= R; i++) {
				for (int j = 0; j <= C; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
//			
			// 낚시왕이 있는 열에 상어 중에서 땅과 제일 가까운 상어를 잡음.
			getFish(fisherLocation);
			
			System.out.println("getfish");
			for (int i = 0; i <= R; i++) {
				for (int j = 0; j <= C; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			} 
			
			// 상어 이동

			for (int j = 0; j < sharkList.size(); j++) {
				
				if(sharkList.get(j).alive) {
		
					Shark temp = new Shark(sharkList.get(j).r, sharkList.get(j).c, sharkList.get(j).s, sharkList.get(j).d, sharkList.get(j).z); 
					int r = temp.r; // 세로
					int c = temp.c; // 가로
					int s = temp.s;
					int d = temp.d; // 이동방향
					int z = temp.z; // 크기
					
					int[] getData = moveShark(r,c,s,d,z);
					
					temp.r = getData[0];
					temp.c = getData[1];
					temp.s = getData[2];
					temp.d = getData[3];
					temp.z = getData[4];
				}
				
			}
			
			System.out.println("move");
			for (int i = 0; i <= R; i++) {
				for (int j = 0; j <= C; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			
			fisherLocation++; // 낚시왕 이동
			if(fisherLocation == C+1) break; // 낚시왕이 끝가지 이동하면 멈춤
		}
	}
}
