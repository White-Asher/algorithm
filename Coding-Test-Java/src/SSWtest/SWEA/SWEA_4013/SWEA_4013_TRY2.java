package SSWtest.SWEA.SWEA_4013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_4013_TRY2 {
	static int K;
	static LinkedList<Integer>[] magnetic;
	static Queue<int[]> movement;
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			K = Integer.parseInt(br.readLine());
			magnetic = new LinkedList[5];
			movement = new ArrayDeque<int[]>();
			
			for (int i = 1; i <= 4; i++) {
				magnetic[i] = new LinkedList<>();
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					int input = Integer.parseInt(st.nextToken());
					magnetic[i].add(input);
				}
			} // input end
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int target = Integer.parseInt(st.nextToken());
				int dire = Integer.parseInt(st.nextToken());
				movement.add(new int[] {target, dire});
			}
			
			simultate();
			int ans = calc();
			System.out.printf("#%d %d\n", t, ans);
		} // test-case end
	}

	private static int calc() { 
		return magnetic[1].get(0) + magnetic[2].get(0)*2 + magnetic[3].get(0)*4 + magnetic[4].get(0)*8; 
	}

	private static void simultate() {
		
		while(!movement.isEmpty()) {
			int[] curOp = movement.poll();
			int curTarget = curOp[0];
			int curTargetMove = curOp[1];
			
			boolean[] check = new boolean[5];
			check[curTarget] = true;
			
			// 돌아가는지 확인
			if(curTarget == 1) {
				search(curTarget, 1, check);
			} else if(curTarget == 4) {
				search(curTarget, -1,check);
			} else {
				search(curTarget, 1, check);
				search(curTarget, -1, check);
			}
			
			// 돌아가는거 방향 바꾸기
//			for (int target = 1; target <= 4; target++) {
//				// 짝수
//				if(target % 2 == 0) {
//					int[] dire = {0, -direction, direction, -direction, direction};
//					rotate(check, dire);
//				}
//				// 홀수
//				else if(target % 2 == 1) {
//					int[] dire = {0, direction, -direction, direction, -direction};
//					rotate(check, dire);
//				}
//			}
			
//			if(curTarget % 2 == 0) {
//				int[] dire = {0,-curTargetMove,curTargetMove, -curTargetMove, curTargetMove};
//				for (int i = 1; i <= 4; i++) {
//					if(check[i] == true) {
//						rotate(i, dire[i] );
//					}
//				}
//			} else if(curTarget % 2 == 1) {
//				int[] dire = {0, curTargetMove, -curTargetMove, curTargetMove, -curTargetMove};
//				for (int i = 1; i <= 4; i++) {
//					if(check[i] == true) {
//						rotate(i, dire[i]);
//					}
//				}
//			}
			
			if(curTarget % 2 == 0) {
				int[] dire = {0, -curTargetMove, curTargetMove, -curTargetMove, curTargetMove};
				for (int i = 1; i <= 4 ; i++) {
					if(check[i]) rotate(i, dire[i]);
				}
			} else if(curTarget % 2 == 1) {
				int[] dire = {0, curTargetMove, -curTargetMove, curTargetMove, -curTargetMove};
				for (int i = 1; i <= 4 ; i++) {
					if(check[i]) rotate(i, dire[i]);
				}
			}
		}
	}
	
	public static void rotate(int target, int dire) {
			if(dire == 1) {
				magnetic[target].addFirst(magnetic[target].removeLast());
			} 
			// 역방향
			else if(dire == -1) {
				magnetic[target].addLast(magnetic[target].removeFirst());
			}

	}

	private static void search(int curTarget, int moveTarget, boolean[] check) {
		if(curTarget + moveTarget >= 1 && curTarget + moveTarget <= 4) {
			if(isRotate(curTarget, curTarget + moveTarget)) {
				check[curTarget + moveTarget] = true;
				search(curTarget + moveTarget, moveTarget, check);
			}
		}
		
	}
	
	public static boolean isRotate(int target1, int target2) {
		int temp = 0;
		if(target1 > target2) {
			temp = target2;
			target2 = target1;
			target1 = temp;
		}
		int firstRightSide = magnetic[target1].get(2);
		int secondLeftSide = magnetic[target2].get(6);
		return firstRightSide != secondLeftSide;
	}
}
