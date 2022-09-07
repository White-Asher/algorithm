package SSWtest.BOJ.Unsolve;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_14891_Pro {
	static LinkedList<Integer>[] magnet;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/swea_4013.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int K = sc.nextInt();
			magnet = new LinkedList[5];
			for (int i = 1; i <= 4; i++) {
				magnet[i] = new LinkedList<>();   // 자석
				for (int j = 0; j < 8; j++) {
					magnet[i].add(sc.nextInt());  // 톱니정보
				}
			}
			for (int k = 0; k < K; k++) {
				int magNum = sc.nextInt();  // 자석번호
				boolean dir = sc.nextInt() == 1 ? true : false;
				if 		(magNum == 1) execute(magNum, 2, dir);  
				else if (magNum == 4) execute(magNum, 6, dir);
				else {
					execute(magNum, 2, dir);  
					rotate(magNum, !dir);
					execute(magNum, 6, dir);
				}
			}
			
			int ans = 0;
			for (int i = 1; i <= 4; i++) {
				ans += magnet[i].get(0) << (i - 1); 
			}
			System.out.println(ans);
		}
	}
	private static void rotate(int magNum, boolean dir) {
		if (dir) {
			magnet[magNum].addFirst(magnet[magNum].removeLast());
		} else {
			magnet[magNum].addLast(magnet[magNum].removeFirst());
		}
	}
	private static void execute(int magNum, int ind, boolean dir) {
		int next = magNum + (ind == 2 ? 1 : -1); 
		if (next > 0 && next < 5 && magnet[magNum].get(ind) != magnet[next].get(8 - ind)) {
			execute(next, ind, !dir);
		}
		rotate(magNum, dir);
	}
}