class Solution {
    public String solution(int n) {
        String answer = "";
        
        int a = n/2;
        for(int i = 0; i < a; i++){
            answer += "수박";
        }
        if(n % 2 == 1) {
            answer+= "수";
        }
        return answer;
    }
}