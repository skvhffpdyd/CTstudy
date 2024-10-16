import java.util.*;
class Solution {
    static Set<Integer> allSet;
    static Set<Integer> removeSet;
    static int network = 0;
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        allSet = new HashSet<>();
        removeSet = new HashSet<>();
        for(int i = 0; i < n; i++){
            allSet.add(i);
        }
        for(int i = 0; i < n; i++){
            Set<Integer> set = new HashSet<>();
            if(allSet.contains(i)) {
                set.add(i);
                dfs(computers, set, i, n, 0);

            }
        }

        return network;
    }

    public static void dfs(int[][] computers, Set<Integer> set, int cur, int n, int count){
        boolean check = true;

        for(int i = 0; i < n; i++){
            if(i == cur || set.contains(i))
                continue;
            if(computers[cur][i] == 1){
                set.add(i);
                dfs(computers, set, i, n, count + 1);
                check = false;
            }
        }

        if(check){
            removeSet.addAll(set);
        }
        if(count == 0){
            allSet.removeAll(removeSet);
            network++;
        }
    }
}