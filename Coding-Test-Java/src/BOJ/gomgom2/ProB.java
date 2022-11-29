package BOJ.gomgom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ProB {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		List<String> human = new ArrayList<String>();
		human.add("ChongChong");
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			if(human.contains(input[0])) {
				human.add(input[1]);				
			} else if (human.contains(input[1])) {
				human.add(input[0]);
			}
		}
		
		HashSet<String> deleteDuplicate = new HashSet<String>(human);
		System.out.println(deleteDuplicate.size());
		
	}
}
