class Solution {
    public long solution(int n, int[] times) {
        long MIN = 1;
        long MAX = 1000000000;
        for (int time : times) {
            MIN = Math.min(MIN, time);
            MAX = Math.max(MAX, time);
        }
        
        long start = MIN;
        long end = MAX * n;
            
        while (start < end) {
            long mid = (start + end) / 2;
            long cnt = 0;
            
            for (int time : times) {
                cnt += mid / time;
            }
            
            if (cnt < n) start = mid + 1;
            else end = mid;
        }
            
        return start;
    }
}
