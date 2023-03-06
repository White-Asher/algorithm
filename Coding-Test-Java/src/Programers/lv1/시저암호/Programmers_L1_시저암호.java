// 프로그래머스 L1 -  시저암호

package Programers.lv1.시저암호;

public class Programmers_L1_시저암호 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.solution("AB", 1);
        System.out.println(result);
    }
}

class Solution{

    String solution(String s, int n) {
        String answer = "";
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isLowerCase(ch)){
                ch = (char) ((ch - 'a'+ n) % 26 + 'a');
            } else if(Character.isUpperCase(ch)){
                ch = (char) ((ch - 'A'+ n) % 26 + 'A');
            }

            answer += ch;
        }

        return answer;
    }
}