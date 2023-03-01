package _Playground.Theory.SJB;

import java.util.Scanner;

public class SubsetTest {
	static int N, totalCnt;
	static int[] input;
	static boolean[] isSelected;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		totalCnt = 0;
		input = new int[N];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		subset(0);
		System.out.println("총 경우의 수 : "+ totalCnt);
	}
	
	// 매개변수에 카운트 보다는 인덱스 개념을 넣는게 더 좋아보인다! 
	// 만약 카운트 개념으로 간다면 cnt : 직전까지 고려한 원소 수.. (거기까지 탐색했다는 의미)
	// index : 부분집합에 고려할 대상
	private static void subset(int index) {
		
		// 더이상 고려할 원소가 없다면 부분집합의 구성이 완성
		if(index == N) {
			totalCnt++;
			for (int i = 0; i < N; i++) {
				System.out.print(isSelected[i] ? input[i] : "X"); // 모든 원소에 대해 출력 (참: 원소, 거짓: 선택되지 않음)
				System.out.print("\t");
			}
			System.out.println();
			return;
		}
		
		// 원소 선택
		isSelected[index] = true;
//		if(index + 1 < N) subset(index+1); // 이 코드의 반대가 기저조건 (이 조건은 탐색할 수 있을 때만 선택)
		subset(index+1);
		// 원소 미선택
		isSelected[index] = false;
		subset(index+1);
		
	}
}
