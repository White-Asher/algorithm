package Programers.lv0.옹알이1;

public class Programmers_L0_옹알이1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"aya", "yee", "u", "maa", "wyeoo"}));
    }
}

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(int i = 0; i < babbling.length; i++){
            String[] tempStr = babbling[i].split("aya|ye|woo|ma");
            if(tempStr.length == 0) answer++;
        }
        return answer;
    }
}