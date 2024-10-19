import java.util.*;
class Solution {
    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[m][n];
        for(int[] p : puddles){
            map[p[0] - 1][p[1] - 1] = -1;
        }
        map[0][0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] != -1){
                    if(i >= 1 && map[i-1][j] != -1)
                        map[i][j] += map[i-1][j];
                    if(j >= 1 && map[i][j-1] != -1)
                        map[i][j] += map[i][j-1];
                    map[i][j] %= 1000000007;
                }
            }
        }
        answer = map[m-1][n-1];
        return answer;
    }
}