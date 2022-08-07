package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 스위치 토글 배열 선언
		int[] swOnOFF = {1, 0};
		
		// 스위치 개수, 스위치 초기상태 입력
		int swCnt = Integer.parseInt(br.readLine());
		int[] sw = new int[swCnt];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < sw.length; i++) {
			sw[i] = Integer.parseInt(st.nextToken());
		}
		
		// 학생수, 성별, 받은 수 입력
		int h = Integer.parseInt(br.readLine());
		for (int i = 0; i < h; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			int gender = Integer.parseInt(st2.nextToken());
			int swNum = Integer.parseInt(st2.nextToken()) - 1;

			// 남학생 입력
			if (gender == 1) {
				int idx = swNum;
				// 스위치 갯수 전까지 받은 수의 배수만큼 스위치 토글
				while(swNum < swCnt) {
					sw[swNum] = swOnOFF[sw[swNum]];
					swNum += (idx+1);
				}
			} 
			// 여학생 입력
			else {
				// 범위 인덱스 크기 지정
				int leftIdx = swNum-1;
				int rightIdx = swNum+1;
				sw[swNum] = swOnOFF[sw[swNum]];
				
				while(leftIdx >= 0 && rightIdx < swCnt) {
					if(sw[leftIdx] == sw[rightIdx]) {
						sw[leftIdx] = swOnOFF[sw[leftIdx]];
						sw[rightIdx] = swOnOFF[sw[rightIdx]];
						leftIdx-=1;
						rightIdx+=1;
					}
					else {
						break;
					}
				}
			}
		}
		for (int i = 0; i < swCnt; i++) {
			System.out.print(sw[i]+ " ");
			if((i+1) % 20 == 0) {
				System.out.println();
			}
			
		}
	}
}
