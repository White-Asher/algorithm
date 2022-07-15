package inflearnJavaCodingTest.string01_01findText;

import java.util.*;

public class Main {
	public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char c = scanner.next().charAt(0);

        System.out.print(main.solution(str, c));
        scanner.close();
    }
	
    public int solution(String str, char t){
        int answer = 0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);
        
        // 향상된 for문 사용 (for-each)
        for(char x : str.toCharArray()) {
        	if (x == t) {
				answer++;
			}
        }
        
        // 기본 반복문 사용
        /* 
        System.out.println(str + " " + t);
        
        for(int i = 0; i< str.length(); i++) {
        	if(str.charAt(i) == t) {
        		answer++;
        	}
        }
        */
        
        return answer;
    }
}