package _Playground;

public class PalindromeChecker {
    public static void isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                System.out.println("회문이 아닙니다.");
                return; // 회문이 아닐 경우 함수 종료
            }
        }
        System.out.println("회문입니다.");
    }

    public static void main(String[] args) {
        String data = "abcba";
        isPalindrome(data);
    }
}