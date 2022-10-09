package SSWtest.BOJ.BOJ_17143;

import java.io.*;
import java.util.*;

public class BOJ_17143_Sol1 {
	static class Shark {
		int r, c, speed, direction, size;
		
		public Shark(int r, int c, int speed, int direction, int size) {
			this.r = r;
			this.c = c;
			this.speed = speed;
			this.direction = direction;
			this.size = size;
            if (direction <= 2) speed %= R * 2;
            else speed %= C * 2;
		}

		void flip() {
			switch (direction) {
			case 0: direction = 1; return;
			case 1: direction = 0; return;
			case 2: direction = 3; return;
			case 3: direction = 2; return;
			}
		}
		
		void move() {
			for(int t = 0; t < speed; ++t) {
				int nr = r + dr[direction];
				int nc = c + dc[direction];
				if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
					flip();
					r += dr[direction];
					c += dc[direction];
					continue;
				}
				r = nr;
				c = nc;
			}
		}
	}
	
	static int R, C;
	static Shark[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new Shark[R][C];
		Deque<Shark> sharks = new ArrayDeque<>(); 
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int speed = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken()) - 1;
			int size = Integer.parseInt(st.nextToken());
			sharks.offer(new Shark(r, c, speed, direction, size));
			map[r][c] = sharks.peekLast();
		}
		
		int meat = 0;
		
		for (int t = 0; t < C; ++t) {
			// 사냥
			for (int i = 0; i < R; ++i) {
				if (map[i][t] != null) {
					meat += map[i][t].size;
					sharks.remove(map[i][t]);
					map[i][t] = null;
					break;
				}
			}
			
			// 맵 초기화, 이동
			for (Shark s: sharks) {
                map[s.r][s.c] = null;
                s.move();
            }
			
			// 배치, 포식
			Deque<Shark> temp = new ArrayDeque<>(); 
			while (!sharks.isEmpty()) {
				Shark cur = sharks.poll();
				if (map[cur.r][cur.c] == null) {
					map[cur.r][cur.c] = cur;
					temp.offer(cur);
					continue;
				}
				if (map[cur.r][cur.c].size > cur.size) continue;
				temp.remove(map[cur.r][cur.c]);
				map[cur.r][cur.c] = cur;
				temp.offer(cur);
			}
			sharks = temp;
		}
		System.out.println(meat);
	}
}
