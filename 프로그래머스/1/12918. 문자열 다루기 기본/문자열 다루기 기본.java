class Solution {
    public boolean solution(String s) {
        if(s.length() != 4 && s.length() != 6) return false;
        for(int i = 0 ; i < s.length(); i++) {
            try {
                Double a = Double.parseDouble(String.valueOf(s.charAt(i)));
            } catch (Exception e) {
                return false;
            }
        }
            
        return true;
    }
}