class Solution {
    public static int[] solution(int n, int s) {
        int[] answer = new int[n];
        int all = s/n;
        if(all == 0)
            return new int[]{-1};
        int remain = s%n;
        for(int i = answer.length-1; i >= 0; i--){
            answer[i] = all;
            if(remain > 0) {
                answer[i] += 1;
                remain--;
            }
        }

        return answer;
    }
}