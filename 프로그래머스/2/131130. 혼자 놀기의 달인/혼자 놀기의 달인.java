import java.util.*;

class Solution {
    static boolean[] visited;
    public static int solution(int[] cards) {
        int answer = 0;
        visited = new boolean[cards.length];
        ArrayList<Integer> group = new ArrayList<>();

        for(int i = 0; i < cards.length; i++) {
            dfs(cards, i, group, 1);
        }

        if(group.size() <= 1)
            return 0;

        group.sort(Collections.reverseOrder());
        
        answer = group.get(0) * group.get(1);
        return answer;
    }
    public static void dfs(int[] cards, int cur, ArrayList<Integer> group, int amount){
        if(!visited[cur]){
            visited[cur] = true;
            dfs(cards, cards[cur] - 1, group, amount+1);
        }
        else if(amount > 1)
            group.add(amount - 1);
    }
}