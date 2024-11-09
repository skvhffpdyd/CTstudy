class Solution {
    public static long solution(int n, int[] times) {
        long start = 0;
        long end = 1000000000L * 1000000000;

        while(end > start){
            long minute = (start + end) / 2;
            if(check(times, minute, n))
                end = minute;
            else
                start = minute + 1;
        }
        return start;
    }

    public static boolean check(int[] times, long minute, int n){
        long count = 0;
        for(int t : times){
            count += minute/t;
        }
        return count >= n;
    }
}