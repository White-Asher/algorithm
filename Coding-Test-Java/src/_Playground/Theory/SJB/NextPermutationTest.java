package _Playground.Theory.SJB;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutationTest {
	static int N;
	static int[] input, numbers;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 원소의 갯수,
		input = new int[N]; // 원소들을 저장할 배열
		numbers = new int[N]; // 순열을 저장할 배열
		
		for(int i =0; i<N; i++) {
			input[i] = sc.nextInt(); // 원소들을 저장
		}
        
		System.out.println("===============permutation================");
		
		permutation(0, 0); // 순열을 생성하는 함수 호출
		sc.close();
	}
	
	
	private static void permutation(int cnt, int flag) {
		if(cnt == N) {
			System.out.println(Arrays.toString(numbers)); // 완성된 순열로 취할 동작
			return;
		}
		
		for(int i=0; i<N; i++) {
			if((flag & 1<<i) != 0) continue;
			
			numbers[cnt] = input[i]; // cnt자리부터 들어가서 순서가 결정됨
			permutation(cnt+1, flag | 1<<i); //선택한 인덱스 1로 마킹, 결국 다 111111...이 됨
		}
	}

}
