package SSWtest.BOJ.BOJ_17143;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_17143_Pro {
	static int R, C, M;
	static int ans;
	static Shark[][] map;
	static ArrayList<Shark> list;
	static int[] dir = { 0, 2, 1, 4, 3 }; // 방향 전환용
	static int[] dr = { 0, -1, 1, 0, 0 }; // 버리기, 상,하,우,좌
	static int[] dc = { 0, 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt(); // 격자판 행
		C = sc.nextInt(); // 격자판 열
		M = sc.nextInt(); // 상어의 수

		list = new ArrayList<Shark>();
		map = new Shark[R + 1][C + 1];
		for (int i = 0; i < M; i++) {
			int r = sc.nextInt(), c = sc.nextInt();
			list.add(map[r][c] = new Shark(r, // r : 행
					c, // c : 열
					sc.nextInt(), // s : 속도
					sc.nextInt(), // d : 방향
					sc.nextInt()));
		}

		for (int i = 1; i <= C; i++) { // 낚시왕은 열의 수만큼 이동
			catchShark(i);// 낚시왕 이동, 상어 잡기
			moveShark(); // 각 상어 이동
			killShark(); // 만약 한칸에 두마리 이상의 상어가 있을 시 한마리 잡아먹기
		}

		System.out.println(ans);
		sc.close();
	}

	private static void moveShark() {
		for (Shark s : list) {
			// 원래의 자기 자리 기준으로 보면 2 * (컬럼 또는 로우 - 1) 일 경우 다시 자기 자신 자리임
			int cnt = (s.d == 1 || s.d == 2 ? R : C) - 1;
			for (int i = 0, move = s.s % (cnt * 2); i < move; i++) {
				if (
						(s.d == 1 && s.r == 1) || 	// 위쪽일때 가장 위쪽 행에 도달하면
						(s.d == 2 && s.r == R) || 	// 아래쪽일때 가장 아래쪽 행에 도달하면
						(s.d == 3 && s.c == C) || 	// 오른쪽일때 가장 오른쪽 열에 도달하면
						(s.d == 4 && s.c == 1) 		// 왼쪽일때 가장 왼쪽 열에 도달하면
				) {
					s.d = dir[s.d];					
				}
				s.r += dr[s.d];
				s.c += dc[s.d];
			}
		}
	}
	private static void catchShark(int col) {
		for (int i = 1; i <= R; i++) {
			if (map[i][col] != null) {
				ans += map[i][col].z;
				list.remove(map[i][col]);
				return;
			}
		}
	}
	private static void killShark() {  // 상어 이동 후 중첩된 상어 정리하기
		map = new Shark[R + 1][C + 1];
		Collections.sort(list, (s1, s2) -> s1.z - s2.z);
		int size = list.size();
		for (int i = size - 1; i >= 0; i--) {
			Shark s = list.get(i);
			if (map[s.r][s.c] == null) 	map[s.r][s.c] = s;
			else 						list.remove(s);
		}
	}
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
}