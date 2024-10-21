import java.util.*;
class Solution {
    public static int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, (o1, o2) -> {
            return o2[0]-o1[0];
        });

        int in = 0;

        for(int i = 0; i < routes.length; i++){
            if(i == 0 || in > routes[i][1]){
                answer++;
                in = routes[i][0];
            }
        }

        return answer;
    }
}