package SSWtest.BOJ.BOJ_17143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17143_EraseRemark_Submit {
	
	static class Shark {
		int r;
		int c;
		int s;
		int d;
		int z;

		Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	
	public static int R, C, M;
	public static Shark[][] map;
	public static int answer;
	public static int dx[] = {-1, 0, 1, 0}; //상 좌 하 우 
	public static int dy[] = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		//입력 받기 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열
		M = Integer.parseInt(st.nextToken()); // 상어 수
		answer = 0;
		
		// 상어 낚시 격자판 만들고, 각 위치에 상어 클래스로 만든 인스턴스 저장 
		map = new Shark[R][C];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken())-1; // 행 위치 
			int c = Integer.parseInt(st.nextToken())-1; // 열 위치 
			int s = Integer.parseInt(st.nextToken()); // 속력 
			int d = Integer.parseInt(st.nextToken()); // 이동 방향 
			int z = Integer.parseInt(st.nextToken()); // 크기 
 
			// 방향 쉽게 바꾸기위해 입력받은 상하좌우(1 2 3 4) -> 상좌하우(0 1 2 3)로 변경 
			if(d == 1) d = 0;
			else if(d == 4) d = 1;
            
			map[r][c] = new Shark(r, c, s, d, z);
		}
		simul();
		System.out.println(answer);
	}
	
	public static void simul() {
		for (int c = 0; c < C; c++) {
			// 상어 잡기
			fishing(c);
			
			// 상어 이동하기
			moveShark();
			
		}
	}
	
	public static void moveShark() {
		Queue<Shark> queue = new LinkedList<>();
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(map[r][c] != null) { 
					queue.add(new Shark(r, c, map[r][c].s, map[r][c].d, map[r][c].z));
				}
			}
		}

		map = new Shark[R][C];  


		while(!queue.isEmpty()) {
			Shark curShark = queue.poll();
            
			//상어 이동
			int curS = curShark.s; // 시간초과로 최소한의 이동을 위해 나머지 연산
			if(curShark.d == 0 || curShark.d == 2) //상 하
				curS %= (R - 1) * 2; 
			else if(curShark.d == 1 || curShark.d == 3) //좌 우
				curS %= (C - 1) * 2;
			
			for(int s = 0; s < curS; s++) {
				// 현재 r, c에 방향에 맞게 1칸씩 추가하며 위치 이동 
				int newR = curShark.r + dx[curShark.d]; 
				int newC = curShark.c + dy[curShark.d];

				// 이동할 새로운 위치가 범위를 벗어나 벽에 부딪히면 
				if(newR < 0 || newR >= R || newC < 0 || newC >= C) { 
					curShark.r -= dx[curShark.d]; // 값 반전
					curShark.c -= dy[curShark.d];
					curShark.d = (curShark.d + 2) % 4; // 방향 반대 
					continue;
				}

				// 새로운 위치로 이동 
				curShark.r = newR; 
				curShark.c = newC;
			}

			// 이동할 위치가 빈 공간인지 이미 상어가 있는지 확인
			if(map[curShark.r][curShark.c] != null) { // 이미 상어가 있다면 두 상어 크기 비교 
				if(map[curShark.r][curShark.c].z < curShark.z) { // 기존 상어보다 이동할 상어가 크다면 
					map[curShark.r][curShark.c] = new Shark(curShark.r, curShark.c, curShark.s, curShark.d, curShark.z); // 현재 상어 넣어줌 
				} 
			} else { // 없다면 이동할 상어 넣기
				map[curShark.r][curShark.c] = new Shark(curShark.r, curShark.c, curShark.s, curShark.d, curShark.z);
			}
		}
	}
	
	public static void fishing(int location) {
		for(int r = 0; r < R; r++) {
			if(map[r][location] != null) { 
				answer += map[r][location].z; 
				map[r][location] = null; 
				break;
			}
		}
	}
}
