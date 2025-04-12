class Solution {
    public int[] solution(String s) {
        int loopCnt = 0;
        int removeCnt = 0;
        
        while(!s.equals("1")) {
            int zeros = countZeros(s);
            loopCnt++;
            removeCnt+=zeros;
            
            int decimal = s.length() - zeros;
            s = Integer.toString(decimal, 2); // 이진수 변환
        }
        return new int[]{loopCnt, removeCnt};
    }
    
    int countZeros(String s) {
        int cnt = 0;
        for(char c : s.toCharArray()) {
            if(c == '0') cnt++;
        }
        return cnt;
    }
}