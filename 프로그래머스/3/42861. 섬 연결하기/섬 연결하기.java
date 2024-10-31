import java.util.*;
class Solution {
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, ((o1, o2) -> o1[2] - o2[2]));
        int[] parents = new int[n + 1];
        for(int i = 0; i < parents.length; i++)
            parents[i] = i;

        return kruskal(costs, parents);
    }


    public static int kruskal(int[][] graph, int[] parents){
        int cost = 0;
        for(int i = 0; i < graph.length; i++){
            if(find(parents, graph[i][0]) != find(parents, graph[i][1])){
                cost += graph[i][2];
                union(parents, graph[i][0], graph[i][1]);
            }
        }
        return cost;
    }
    public static int find(int[] parents, int x){ // 루트 탐색
        if(parents[x] == x) return x;
        else return find(parents, parents[x]);
    }

    public static void union(int[] parents, int x, int y){
        x = find(parents, x);
        y = find(parents, y);

        if(x < y) parents[y] = x;
        else parents[x] = y;
    }
}