package inflearnJavaCodingTest._01string._05ReverseSpecificCharacters;

import java.io.*;
import java.util.*;

public class Main {
	public Main() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		
	}
	
	public static ArrayList<String> solution( String[] str) {
		ArrayList<String> answer = new ArrayList<>();
		for (String x : str) {
			char[] s = x.toCharArray();
			int lt = 0, rt = x.length() - 1;
			while(lt<rt) {
				char tmp = s[lt];
				if(Character.isLetterOrDigit(tmp)) {
					s[lt] = s[rt];
					s[rt] = tmp;
				}
				lt++;
				rt--;
			}
			String tmp = String.valueOf(s);
			answer.add(tmp);
		}
		
		
		return answer;
	}
}
