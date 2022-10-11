package SSWtest.SWEA.SWEA_4013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_4013_TRY1 {
	static StringTokenizer st;
	static int K;
	static LinkedList<Integer>[] magnetic;
	static Queue<int[]> moveMagnetic;
	static boolean[] rotateCheck;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			K = Integer.parseInt(br.readLine());
			magnetic = new LinkedList[5];
			moveMagnetic = new ArrayDeque<>();
			// 자석 값 넣기
			for (int i = 1; i <= 4; i++) {
				magnetic[i] = new LinkedList<>();
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < 8; j++) {
					magnetic[i].add(Integer.parseInt(st.nextToken()));
				}				
			}
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int target = Integer.parseInt(st.nextToken());
				int dire = Integer.parseInt(st.nextToken());
				moveMagnetic.add(new int[] {target, dire});
			}
			
			solution();
			System.out.printf("#%d %d\n", t, calc());
			
		} // test-case end
	} // main end
	
	private static int calc() {
		return magnetic[1].get(0) + magnetic[2].get(0)*2 + magnetic[3].get(0)*4 + magnetic[4].get(0)*8;
	}

	private static void solution() {
		while(moveMagnetic.size() != 0) {
			rotateCheck = new boolean[5];
			int[] currentMagnetic = moveMagnetic.poll();
			int curTarget = currentMagnetic[0];
			int curDire = currentMagnetic[1];
			rotateCheck[curTarget] = true;
		
			if(curTarget == 1) {
				simul(curTarget, 1);
			} else if(curTarget == 4) {
				simul(curTarget, -1);
			} else {
				simul(curTarget, 1);
				simul(curTarget, -1);
			}
			
			if(curTarget % 2 == 0) {
				int[] dire = {0, -curDire, curDire, -curDire, curDire};
				for (int i = 1; i <= 4; i++) {
					if(rotateCheck[i]) {
						rotate(i, dire[i]);
					}
				}
			}
			
			else if(curTarget % 2 == 1) {
				int[] dire = {0, curDire, -curDire, curDire, -curDire};
				for (int i = 1; i <= 4; i++) {
					if(rotateCheck[i]) {
						rotate(i, dire[i]);
					}
				}
			}
			
		}
		
		
	}
	
	public static void rotate(int target, int dire) {
		if(dire == 1) {
			magnetic[target].addFirst(magnetic[target].removeLast());
		} else {
			magnetic[target].addLast(magnetic[target].removeFirst());
		}
	}

	private static void simul(int curTarget, int curMove) {
		if(curTarget + curMove >= 1 && curTarget + curMove <= 4) {
			if(isEqual(curTarget, curTarget + curMove)) {
				rotateCheck[curTarget + curMove] = true;
				simul(curTarget + curMove, curMove);
			}
		}
		
	}

	private static boolean isEqual(int target1, int target2) {
		if(target1 > target2) {
			int temp = target2;
			target2 = target1;
			target1 = temp;
		}
		int firstMagneticRightSide = magnetic[target1].get(2);
		int secondMagneticLeftSide = magnetic[target2].get(6);
		return firstMagneticRightSide != secondMagneticLeftSide;
	}
	
	
} // class end
