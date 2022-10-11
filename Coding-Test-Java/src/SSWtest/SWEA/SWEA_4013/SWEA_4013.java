package SSWtest.SWEA.SWEA_4013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_4013 {
	static StringTokenizer st;
	static LinkedList<Integer>[] magnetic; // 자석 장보를 저장할 배열 리스트 선언
	static Queue<int[]> moveMagnetic; // 자석 움직일 task 넣는 큐
	static boolean[] rotateCheck; // 자석이 돌아갔는지 체크용
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			magnetic = new LinkedList[5]; // 선언 (중요)
			moveMagnetic = new ArrayDeque<>(); // 자석을 돌리는 정보를 저장할 큐 선언
			
			int K = Integer.parseInt(br.readLine());
			for (int i = 1; i <= 4; i++) {
				magnetic[i] = new LinkedList<>(); // 빼먹지 말자... 
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
			System.out.printf("#%d %d\n", t, calcSum());
		}
		
	}

	private static int calcSum() {
		return magnetic[1].get(0) + magnetic[2].get(0)*2 + magnetic[3].get(0)*4 + magnetic[4].get(0)*8;
	}


	private static void solution() {
		// 자석을 돌리는 수행 시작.
		while(moveMagnetic.size() != 0) {
			rotateCheck = new boolean[5];
			int[] currentMagnetic = moveMagnetic.poll();
			int curTarget = currentMagnetic[0];
			int curDire = currentMagnetic[1];
			rotateCheck[curTarget] = true;
			
			// 현재 자석에서 +1은 오른쪽 자석 탐색 -1은 왼쪽 자석 탐색 
			if(curTarget == 1) {
				simulate(curTarget, 1);
			} else if(curTarget == 4) {
				simulate(curTarget, -1);
			} else {
				simulate(curTarget, 1);
				simulate(curTarget, -1);
			}
			int[] dire = null;
			// 돌리는 자석이 2, 4 면 들어온 방향에 따라 1,2,3,4 자석의 방향을 설정함.
			if(curTarget % 2 == 0) {
				dire = new int[]{0,-curDire,curDire, -curDire, curDire};
			} 
			// 돌리는 자석이 1, 3 면 들어온 방향에 따라 1,2,3,4 자석의 방향을 설정함.
			else if(curTarget % 2 == 1) {
				dire = new int[]{0, curDire, -curDire, curDire, -curDire};
			}
			
			for (int i = 1; i <= 4; i++) {
				if(rotateCheck[i]) {
					rotate(i, dire[i]);
				}
			}
			
		}
		
	}

	// 자석을 돌리는 메서드 
	private static void rotate(int target, int dire) {
		if(dire == 1) {
			magnetic[target].addFirst(magnetic[target].removeLast()); 
		} else {
			magnetic[target].addLast(magnetic[target].removeFirst());
		}
		
	}

	// 돌릴 수 있는 자석을 탐색해본다. 
	private static void simulate(int curTarget, int curMove) {
		if(curTarget + curMove >= 1 && curTarget + curMove <= 4) {
			if(isEqual(curTarget, curTarget + curMove)) {
				rotateCheck[curTarget + curMove] = true;
				simulate(curTarget + curMove, curMove);
			}
		}
		
	}

	// 자석이 같은 극인지 확인한다. (만약 다른 극이면 돌릴 수 있음 -> true값 리턴)
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
}
