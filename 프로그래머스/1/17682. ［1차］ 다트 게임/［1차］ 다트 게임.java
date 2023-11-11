import java.util.*;
import java.io.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] value = new int[10];
        int idx = 1;
        int it = 1;
        String[] s = dartResult.split("￦#|￦*|S|D|T");
        // System.out.println(Arrays.toString(s));
        for(int i = 0; i < dartResult.length(); i++) {
            char tar = dartResult.charAt(i);
            
            // System.out.println(tar);
            // 숫자라면
            if(Character.isDigit(tar)) {
                it = idx;
                char tar2 = dartResult.charAt(i+1);
                // System.out.println("tar2 :" + tar2);
                if(Character.isDigit(tar2)){
                    StringBuilder sb = new StringBuilder();
                    sb.append(String.valueOf(tar)).append(String.valueOf(tar2));
                    // System.out.println(n);
                    value[idx] = Integer.parseInt(sb.toString());
                    i++;
                } else {
                    value[idx] = Integer.parseInt(String.valueOf(tar));
                } 
                idx++;
            
            } 
            // 숫자가 아니라면
            else {
                // 문자라면
                if(Character.isLetter(tar)) {
                    
                    // 1제곱
                    if (tar == 'S') {
                        value[it] = (int) Math.pow(value[it],1);
                    } 
                    // 2제곱
                    else if (tar == 'D') {
                        value[it] = (int) Math.pow(value[it],2);  
                    } 
                    // 3제곱
                    else if (tar == 'T') {
                        value[it] = (int) Math.pow(value[it],3);
                    }
                }
                // 문자가 아니라 특수라면
                else {
                    // 스타상
                    if (tar == '*') {
                        value[it-1] = value[it-1] * 2;
                        value[it] = value[it] * 2;
                    } else if(tar == '#') {
                        value[it] = value[it] * (-1);
                    }
                }
            }
        }
System.out.println(Arrays.toString(value));
        for(int i = 1; i <= 3; i++) {
            // System.out.println(Arrays.toString(value));
            answer += value[i];
        }
        return answer;
    }
}