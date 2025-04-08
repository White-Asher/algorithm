import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        int size = 0;
        List<int[]> filtered = new ArrayList<>();
        for(int[] item : data) {
            if(item[extRet(ext)] < val_ext) {
                filtered.add(item);
                size++;
            }
        }
        
        filtered.sort( (item1, item2) -> item1[extRet(sort_by)] - item2[extRet(sort_by)]);
        
        return filtered.toArray(new int[filtered.size()][]);
    }
    public int extRet(String ext) {
        if("code".equals(ext)) {
            return 0;
        } else if("date".equals(ext)) {
            return 1;
        } else if("maximum".equals(ext)) {
            return 2;
        } else {
            return 3;
        }
    }
}