package BOJ.Implementation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BOJ_1244_스위치켜고끄기 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/1244.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 스위치 번호가 1부터 오기 때문에 하나 더 인덱스 크기를 늘려 생성
		int[] data = new int[N + 1];
		for (int i = 1; i < N; i++) {
			data[i] = sc.nextInt();
		}
		int stuNum = sc.nextInt(); // 학생수
		int loc = 0; // 스위치의 위치를 나타낸다.
		int[] change = {1,0};
		
		for (int i = 0; i < stuNum; i++) {			
			switch (sc.nextInt()) {
			case 1: // 남학생
				loc = sc.nextInt();
				for (int j = 0; j < N; j+=loc) {
					data[j] = change[data[j]];
				}
				break;
				
			case 2: // 여학생
				loc = sc.nextInt();
				// left, right가 처음에는 똑같은데 하나씩 커지게 할 것..
				int l = loc, r = loc;
				while(l > 1 && r <= N) {
					if (data[i] != data[r]) break;
					data[l] = data[r] = change[data[l]];
					l++; r++;
				}
				
			}
		}
		for (int i = 1; i < N; i++) {
			System.out.printf("%d%s", data[i], i % 20 == 0 ? "\n" : " " );
		}
		sc.close();
	}
}

