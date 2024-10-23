import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int ans = 0;
        // String[] sBase = base(n, k).split("0");
        String[] sBase = Long.toString(n, k).split("0");
        for(String s : sBase) if(isPrime(s)) ans++;
        return ans;
    }
    
    public boolean isPrime(String input) {
        if(input.equals("")) return false;
        long n = Long.parseLong(input);
        if(n < 2) return false;
        for(long i = 2; i <= (long) Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
    
    // 진수변환
    // public String base(int num, int k) {
    //     StringBuilder sb = new StringBuilder();
    //     while(num > 0) {
    //         sb.append(num % k);
    //         num /= k;
    //     }
    //     return sb.reverse().toString();
    // }
    
}