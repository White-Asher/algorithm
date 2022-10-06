package BOJ.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 메모리: 12484	
 * 실행시간: 96ms
 * 코드길이: 2234
 * BFS사용
 */

public class BOJ_9205_HW {
	static int N, startX, startY, destX, destY;
	static StringTokenizer st;
	static int[][] store;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			store = new int[N][2]; // 편의점 좌표 저장 배열 선언
			
			// 시작지점 입력
			st = new StringTokenizer(br.readLine());
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			
			// 편의점 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				store[i][0] = Integer.parseInt(st.nextToken());
				store[i][1] = Integer.parseInt(st.nextToken());
			}
			
			// 목적지점 입력
			st = new StringTokenizer(br.readLine());
			destX = Integer.parseInt(st.nextToken());
			destY = Integer.parseInt(st.nextToken());
			
			if(BFS()) System.out.println("happy");
			else System.out.println("sad");
			
		}
	}

	
	private static boolean BFS() {
		// 시작 좌표부터 탐색
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {startX, startY});
		boolean[] visited = new boolean[N];
		
		while(queue.size()!= 0) {
			int[] q = queue.poll();
			int qx = q[0];
			int qy = q[1];
			
			// 두 좌표 사이 거리  => |X0-X1| + |Y0-Y1|
			// 두 거리 사이가 맥주를 마시며 갈 수 있을 경우 -> true
			if(Math.abs(qx - destX) + Math.abs(qy - destY) <= 20*50) return true;
			
			// 편의점 까지 탐색
			for (int i = 0; i < N; i++) {
				if(!visited[i]) {
					int storeX = store[i][0];
					int storeY = store[i][1];
					int destinationDistance = Math.abs(qx - storeX) + Math.abs(qy - storeY);
					// 맥주 떨어지기 전까지 이동 가능한가
					if(destinationDistance <= 20*50) {
						visited[i] = true;
						queue.add(new int[] {storeX,storeY});
					}
					
				}
			}
			
		}
		// 위의 조건에 해당하지 않으므로 -> false
		return false;
	}
}
