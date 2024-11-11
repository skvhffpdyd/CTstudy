import java.util.*;
class Solution
{
    public static int solution(String s) {
        int answer = 0;

        char[] sc = s.toCharArray();

        for(int i = 0; i < sc.length; i++){
            answer = Math.max(answer, validSize(sc, i-1, i+1));
            answer = Math.max(answer, validSize(sc, i, i+1));
        }

        return answer;
    }

    public static int validSize(char[] sc, int x, int y){
        while(x >= 0 && y < sc.length && sc[x] == sc[y]){
            x--;
            y++;
        }
        while(y==sc.length && x >= 0 && sc[x] == sc[y-1]){
            x--;
        }
        while(x == -1 && y < sc.length && sc[x+1] == sc[y]){
            y++;
        }

        return y-x-1;
    }
}