import java.util.*;
class Solution {
    public static long solution(int n, int[] works) {
        long answer = 0;
        int len = works.length - 1;
        Arrays.sort(works);
        for(int i = 0; i < n; i++) {
            if(works[len] == 0)
                break;
            works[len]--;
            insert_sort(works, len);
        }
        for(int i : works){
            if(i > 0)
                answer += (long) i * i;
        }

        return answer;
    }

    public static void insert_sort(int[] works, int len){
        for(int i = len; i >= 0; i--){
            boolean sort = false;
            int target = works[i];
            int j = i - 1;
            while(j >= 0 && target < works[j]){
                works[j+1] = works[j];
                j--;
                sort = true;
            }
            works[j+1] = target;
            if(!sort){
                break;
            }
        }
    }
}