class Solution {
    public static int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n+1][n+1];
        int INF = 4500;

        for(int i = 0 ; i <= n; i++){
            for(int j = 0 ; j <= n; j++){
                graph[i][j] = INF;
            }
        }

        for(int i = 0; i < results.length; i++){
            graph[results[i][0]][results[i][1]] = 1;
        }

        floyd(graph, n);
        
        for(int i = 1; i <= n; i++){
            int count = 0;

            for(int j = 1; j <= n; j++){
                if(graph[i][j] != INF || graph[j][i] != INF)
                    count++;
            }

            if(count == n-1)
                answer++;
        }

        return answer;
    }

    public static void floyd(int[][] graph, int n){
        for(int i = 1 ; i <= n; i++){
            for(int j = 1 ; j <= n; j++){
                for(int k = 1 ; k <= n; k++){
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }
    }
}