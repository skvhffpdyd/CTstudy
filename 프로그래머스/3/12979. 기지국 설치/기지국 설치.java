class Solution {
    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int count = 0;
        int min = stations[count]-w-1;
        int max = stations[count]+w-1;
        for(int i = 0; i < n; i++){
            if(i < min) {
                answer++;
                i += (w * 2);
            }
            else if(i > max && count < stations.length - 1){
                count++;
                min = stations[count] - w - 1;
                max = stations[count] + w - 1;
                i--;
            }
            else if(i > max && count == stations.length - 1){
                answer++;
                i += (w * 2);
            }
            else{
                i = max;
            }
        }

        return answer;
    }
}