package BOJ.gomgom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ProC {
	static long[] human = new long[3];
	static long[] ticket = new long[3];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int result = 0; 
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {
			 human[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {
			ticket[i] = Integer.parseInt(st.nextToken());
		}
//		System.out.println(Arrays.toString(human));
//		System.out.println(Arrays.toString(ticket));
//		System.out.println("============");
		
		while(true) {
			if(check()) {
				break;
			}
			
			for (int i = 0; i < 3; i++) {
				if(human[i] == 0) {
					continue;
				} else if (human[i] >= ticket[i]) {
					result += (ticket[i]);
					human[i] -= ticket[i];
					ticket[i] = 0;
				} else if(human[i] < ticket[i]){
					result += (human[i]);
					ticket[i] -= human[i];
					human[i] = 0;
				}
				
//				System.out.println(result);
//				System.out.println(Arrays.toString(human));
//				System.out.println(Arrays.toString(ticket));
			}
			
			for (int i = 0; i < 2; i++) {
				if(ticket[i] >= 3) {
//					System.out.println(ticket[i]);
//					System.out.println(ticket[i]/3);
					ticket[i+1] += ticket[i]/3;
					ticket[i] = ticket[i]%3;
					
					i+=1;
					if (human[i] >= ticket[i]) {
						result += (ticket[i]);
						human[i] -= ticket[i];
						ticket[i] = 0;
					} else if(human[i] < ticket[i]){
						result += (human[i]);
						ticket[i] -= human[i];
						human[i] = 0;
					}
//					System.out.println(result);
//					System.out.println(Arrays.toString(human));
//					System.out.println(Arrays.toString(ticket));
				}
			}
			if(ticket[2] >= 3) {
				ticket[0] += ticket[2]/3;
				ticket[2] %= 3;
			}
			
			if (human[0] >= ticket[0]) {
				result += (ticket[0]);
				human[0] -= ticket[0];
				ticket[0] = 0;
			} else if(human[0] < ticket[0]){
				result += (human[0]);
				ticket[0] -= human[0];
				human[0] = 0;
			}
//			System.out.println(result);
//			System.out.println(Arrays.toString(human));
//			System.out.println(Arrays.toString(ticket));
//			System.out.println("============");
		}
		System.out.println(result);
		
	} 
	
	public static boolean check() {
		for (int i = 0; i < 3; i++) {
			if(ticket[i] >=3 ) {
				return false;
			}
		}
		return true;
	}
}
