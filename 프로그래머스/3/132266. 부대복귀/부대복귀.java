import java.util.*;

class Node implements Comparable<Node>{
    int index;
    int cost;

    public Node(int index, int cost){
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }
}

class Solution {
    static ArrayList<Node>[] graph;
    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        graph = new ArrayList[n + 1];
        int INF = Integer.MAX_VALUE;
        for(int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

        for (int[] road : roads) {
            graph[road[0]].add(new Node(road[1], 1));
            graph[road[1]].add(new Node(road[0], 1));
        }

        int[] ans = Dijkstra(n, destination);

        for(int i = 0; i < sources.length; i++){
            if(ans[sources[i]] == INF)
                answer[i] = -1;
            else
                answer[i] = ans[sources[i]];
        }

        return answer;
    }

    public static int[] Dijkstra(int n, int start){
        boolean[] check = new boolean[n + 1];
        int[] dist = new int[n + 1];
        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            int nowVertex = pq.poll().index;

            if(check[nowVertex]) continue;
            check[nowVertex] = true;

            for(Node next : graph[nowVertex]){
                if(dist[next.index] > dist[nowVertex] + next.cost){
                    dist[next.index] = dist[nowVertex] + next.cost;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }

        return dist;
    }
}