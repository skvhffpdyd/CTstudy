import java.util.*;
class Node implements Comparable<Node>{
    int index;
    int cost;
    public Node(int index, int cost) {
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
    public static int solution(int n, int[][] edge) {
        int answer = 0;
        graph = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < edge.length; i++) {
            graph[edge[i][0]].add(new Node(edge[i][1], 1));
            graph[edge[i][1]].add(new Node(edge[i][0], 1));
        }

        answer = Dijkstra(n);

        return answer;
    }

    public static int Dijkstra(int n){
        boolean[] check = new boolean[n + 1];
        int[] dist  = new int[n + 1];
        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist, INF);
        dist[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        while(!pq.isEmpty()){
            int nowVertex = pq.poll().index;

            if(check[nowVertex]) continue;
            check[nowVertex] = true;

            for (Node next : graph[nowVertex]){
                if(dist[next.index] > dist[nowVertex] + next.cost){
                    dist[next.index] = dist[nowVertex] + next.cost;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }

        Arrays.sort(dist);
        int max = -1;
        int answer = 0;
        for(int i = dist.length - 1; i >= 0; i--){
            if(max == -1 && dist[i] != INF)
                max = dist[i];

            if(max != -1 && dist[i] != max)
                break;

            if(max != -1)
                answer++;
        }
        return answer;
    }
}