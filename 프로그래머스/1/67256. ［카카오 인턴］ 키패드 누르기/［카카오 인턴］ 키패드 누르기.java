import java.util.*;

class Solution {
    static StringBuilder sb;
    public String solution(int[] numbers, String hand) {
        sb = new StringBuilder();
        int left = 10;
        int right = 12;
        
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if (num == 1 || num == 4 || num == 7) {
                sb.append("L");
                left = num;
            } else if (num == 3 || num == 6 || num == 9) {
                sb.append("R");
                right = num;
            } else {
                if(num == 0) num = 11;
                int leftDist = Math.abs(num - left) / 3  + Math.abs(num - left) % 3;
                int rightDist = Math.abs(num- right) / 3 + Math.abs(num - right) % 3;
            
                if(leftDist < rightDist) {
                    sb.append("L");
                    left = num;
                } else if (leftDist > rightDist) {
                    sb.append("R");
                    right = num;
                } else {
                    if(hand.equals("right")) {
                        sb.append("R");
                        right = num;
                    } else {
                        sb.append("L");
                        left = num;
                    }
                }
            }
        }
        
        return sb.toString();
    }
    
}