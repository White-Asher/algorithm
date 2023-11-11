import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        boolean[][] b1 = new boolean[n][n];
        boolean[][] b2 = new boolean[n][n];
        
        for(int t = 0; t < n; t++) {
            int tar1 = arr1[t];
            for(int i = n-1; i >= 0; i--) {
                int min = (int) Math.pow(2, i);
                if(tar1 - min >= 0) {
                    tar1 -= min;
                    b1[t][n-1-i] = true;
                }
            }
            
            int tar2 = arr2[t];
            for(int i = n-1; i >= 0; i--) {
                int min = (int) Math.pow(2, i);
                if(tar2 - min >= 0) {
                    tar2 -= min;
                    b2[t][n-1-i] = true;
                }
            }
        }
        
//         for(int i = 0; i < n; i++) {
//             System.out.println(Arrays.toString(b1[i]));
//         }
        
//         for(int i = 0; i < n; i++) {
//             System.out.println(Arrays.toString(b2[i]));
//         }
        
        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++) {
                if(b1[i][j] || b2[i][j]) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }  
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}