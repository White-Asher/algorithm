package SSWtest.queuelist.SWEA_4013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_14891 {
	static boolean[] rotateCheck;
	static LinkedList<Integer>[] magnetic;
	static Queue<int[]> moveMagnetic;
	static boolean flag = false;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		moveMagnetic = new ArrayDeque<>();
		magnetic = new LinkedList[5];
		for (int i = 1; i <= 4; i++) {
			magnetic[i] = new LinkedList<>();
		}
		
		for (int m = 1; m <= 4; m++) {
			String input = br.readLine();
			for (int i = 0; i < 8; i++) {
				magnetic[m].add(Integer.parseInt(String.valueOf(input.charAt(i))));
			}
		}

		int K = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int moveTarget = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			moveMagnetic.add(new int[] { moveTarget, direction });
		}
		
		simulation();
		System.out.println(sum());
	}
	
	public static void simulation() {
		while(moveMagnetic.size() != 0) {
			rotateCheck = new boolean[5];
			
			int[] currenetMagnetic = moveMagnetic.poll();
			int curTarget = currenetMagnetic[0];
			int curDirection = currenetMagnetic[1];
			rotateCheck[curTarget] = true;
			
			if(curTarget == 1) {
				simulate(curTarget, 1);
			} else if(curTarget == 4) {
				simulate(curTarget, -1);
			} else {
				simulate(curTarget, 1);
				simulate(curTarget, -1);
			}
			
			if(curTarget % 2 == 0) {
				int[] dire = {0,-curDirection,curDirection,-curDirection,curDirection};
				for (int i = 1; i <= 4; i++) {
					if(rotateCheck[i] == true) {
						rotate(i, dire[i]);
					}
				}
			} else if (curTarget % 2 == 1) {
				int[] dire = {0,curDirection,-curDirection,curDirection,-curDirection};
				for (int i = 1; i <= 4; i++) {
					if(rotateCheck[i] == true) {
						rotate(i, dire[i]);
					}
				}
			}
			
		}
	}
	
	public static void simulate(int curTarget, int searchDir) {
		if(curTarget+searchDir >= 1 && curTarget+searchDir <=4) {
			if (isEqual(curTarget, curTarget + searchDir)) {
				rotateCheck[curTarget + searchDir] = true;
				simulate(curTarget + searchDir, searchDir);
			}
		}

	}
	
	public static void rotate(int targetNum, int direction) {
		if(direction == 1) {
			magnetic[targetNum].addFirst(magnetic[targetNum].removeLast());
		} else if(direction == -1) {
			magnetic[targetNum].addLast(magnetic[targetNum].removeFirst());
		}
	}
	
	public static boolean isEqual(int target1, int target2) {
		if(target1 > target2) {
			int temp = target2;
			target2 = target1;
			target1 = temp;
		}
		int rightSide = magnetic[target1].get(2);
		int leftSide = magnetic[target2].get(6);
		return rightSide != leftSide;
	}
	
	public static int sum() {
		return magnetic[1].get(0)+magnetic[2].get(0)*2+magnetic[3].get(0)*4+magnetic[4].get(0)*8;
	}

}
