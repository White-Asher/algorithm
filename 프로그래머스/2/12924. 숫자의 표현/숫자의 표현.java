class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[n+1];
        for(int i = 0; i < n; i++){
            arr[i] = i+1;
        }
        
        int left = 0;
        int right = 0;
        int sum = 0;
        while(left != n) {
            if(sum >= n) {
                sum -= arr[left++];
            }
            else if(sum < n) {
                sum += arr[right++];
            }
            
            if(sum == n) {
                answer++;
            }
        }
        return answer;
    }
}