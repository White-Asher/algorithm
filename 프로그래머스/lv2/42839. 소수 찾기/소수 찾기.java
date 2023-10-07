import java.util.*;
import java.io.*;

class Solution {
    static String[] sarr;
    static String[] arr;
    static String[] input;
    static boolean[] check;
    static boolean[] check2;
    static int n;
    static HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        sarr = numbers.split("");
        n = sarr.length;
        check = new boolean[n];
        sub(0);
        
        return set.size();
    }
    
    // 부분집합
    static void sub(int idx) {
        if(idx == n){
            // 순열
            int size = 0;
            for(int i = 0; i < n; i++) {
                if(check[i]) {
                    size++;
                }
            }
            if(size == 0) return;
            // System.out.println("sub");
            // for(int i = 0; i < n; i++)  {
            //     if(check[i]) System.out.print(sarr[i]);
            // }
            System.out.println();
            
            // 순열 체크용 배열
            check2 = new boolean[size];
            arr = new String[size];
            int a = 0;
            for(int i = 0; i < n; i++)  {
                if(check[i]) arr[a++] = sarr[i];
            }
            input = new String[arr.length];
            per(0, size);
            return;
        }
        
        check[idx] = true;
        sub(idx+1);
        check[idx] = false;
        sub(idx+1);
    }
    
    static void per(int cnt, int size) {
        if(cnt == size) {
            int res = isPrime();
            // System.out.println("res :" + res);
            if(res != 0) {
                set.add(res);
            }
            // System.out.print("sarr ");
            // System.out.println(Arrays.toString(sarr));
            // System.out.print("arr ");
            // System.out.println(Arrays.toString(arr));
            return;
        }
        
        for(int i = 0; i < size; i++) {
            if(check2[i]) continue;
            input[cnt] = arr[i];
            check2[i] = true;
            per(cnt + 1, size);
            check2[i] = false;
        }
        
        
    }
    
    // 소수판별
    static int isPrime() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < check2.length; i++) {
            if(check2[i]) {
                sb.append(input[i]);
            }
        }
        if(sb.toString().equals("")) return 0;
        int tar = Integer.parseInt(sb.toString());
        // System.out.println("tar : " + tar);
        if(tar == 2) return tar;
        if(tar <= 1) return 0;
        for(int i = 2; i <= tar / 2; i++) {
            if (tar % i == 0) {
                return 0;
            }
        }
        return tar;
    }
}