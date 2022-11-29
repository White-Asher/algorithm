package BOJ.gomgom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProA {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split("-");
			int num = Integer.parseInt(input[1]);
			if(num <= 90) {
				result += 1;
			}
		}
		System.out.println(result);
	}
}