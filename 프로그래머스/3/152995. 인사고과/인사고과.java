import java.util.*;
class Solution {
    public static int solution(int[][] scores) {
        int score = scores[0][0]+scores[0][1];
        int rank = 1;
        int[][] rankScore = new int[scores.length][3];

        for(int i = 0; i < scores.length; i++){
            rankScore[i][0] = scores[i][0];
            rankScore[i][1] = scores[i][1];
            rankScore[i][2] = i;
        }

        Arrays.sort(rankScore, (o1, o2) -> {
            if(o2[0] != o1[0]) return o2[0] - o1[0];
            return o2[1] - o1[1];
        });

        int cur = rankScore[0][0];
        int last = rankScore[0][1];

        for(int i = 0; i < rankScore.length; i++){
            boolean safe = true;

            if(cur > rankScore[i][0]){
                if(last > rankScore[i][1]) safe = false;
                cur = rankScore[i][0];
            }
            else{
                for(int j = 0; j < i; j++){
                    if(rankScore[j][0] == rankScore[i][0]) break;
                    if(rankScore[j][1] <= rankScore[i][1]) continue;
                    safe = false;
                    break;
                }
            }

            if(last < rankScore[i][1]) last = rankScore[i][1];

            if(safe && score < rankScore[i][0] + rankScore[i][1]) rank++;
            if(!safe && rankScore[i][2] == 0) return -1;
        }

        return rank;
    }
}