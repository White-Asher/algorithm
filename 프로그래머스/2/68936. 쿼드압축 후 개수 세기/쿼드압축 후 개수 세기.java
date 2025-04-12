class Solution {
    static int[] ans = new int[]{0,0};
    
    public int[] solution(int[][] arr) {
        int[] answer = {};
        recursive(0, 0, arr.length, arr);
        return ans;
    }

    void recursive(int h, int w, int size, int[][] arr) {
        int tar = arr[h][w];
        boolean sameValChk = true;
        for(int i = h; i < h + size; i++) {
            for(int j = w; j < w + size; j++) {
                if(tar != arr[i][j]) {
                    sameValChk = false;
                }
            }
        }
        if(sameValChk) ans[tar]++;
        
        else {
            size /= 2;
            recursive(h, w, size,arr);
            recursive(h + size, w, size, arr);
            recursive(h, w + size, size, arr);
            recursive(h + size, w + size, size, arr);
        }
    }
}