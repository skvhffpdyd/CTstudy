import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int death = 0;
        Arrays.sort(B);
        Arrays.sort(A);
        for(int i = B.length-1; i >= 0; i--){
            if(A[i] < B[i+death])
                answer++;
            else
                death++;
        }
        return answer;
    }
}