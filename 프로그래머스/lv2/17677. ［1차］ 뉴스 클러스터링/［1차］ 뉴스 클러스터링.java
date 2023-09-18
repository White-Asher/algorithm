import java.util.*;
import java.io.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        List<String> st1 = new ArrayList<>();
        List<String> st2 = new ArrayList<>();
        
        // str1
        for(int i = 0; i < str1.length()-1; i++) {
            String tar = str1.substring(i, i+2);
            // 확인
            if(!String.valueOf(tar.charAt(0)).matches("^[a-zA-Z]*$")) {
                continue;
            } 
            
            if(!String.valueOf(tar.charAt(1)).matches("^[a-zA-Z]*$")) {
                continue;
            } 
            
            st1.add(tar);
        }
        
        // str2
        for(int i = 0; i < str2.length()-1; i++) {
            String tar = str2.substring(i, i+2);
            // 확인
            if(!String.valueOf(tar.charAt(0)).matches("^[a-zA-Z]*$")) {
                continue;
            } 
            
            if(!String.valueOf(tar.charAt(1)).matches("^[a-zA-Z]*$")) {
                continue;
            } 
            
            st2.add(tar);
        }
        
        Collections.sort(st1);
        Collections.sort(st2);
        
        List<String> union = new ArrayList<>();
        List<String> inter = new ArrayList<>();
        
        for(String str : st1) {
            if(st2.remove(str)) {
                inter.add(str);
            }
            union.add(str);
        }
        
        for(String str : st2) {
            union.add(str);
        }
        double temp = 1.0;
        if(union.size() == 0){
            return 65536;
        }
        
        if(inter.size() == 0) {
            return 0;
        } else if(inter.size() !=0 ){
            temp = (double) inter.size()/ (double) union.size();
        }
        
        return (int) (temp * 65536);
    }
}