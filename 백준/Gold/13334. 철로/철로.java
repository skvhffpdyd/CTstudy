import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
             st = new StringTokenizer(br.readLine());
             int a = Integer.parseInt(st.nextToken());
             int b = Integer.parseInt(st.nextToken());
             int w = Math.max(a, b);
             int h = Math.min(a, b);
             arr[i][0] = h;
             arr[i][1] = w;
        }
        int d = Integer.parseInt(br.readLine());
        Arrays.sort(arr, (o1, o2) -> o1[1] - o2[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        for(int i=0; i < n; i++){
            pq.add(arr[i][0]);
            while(!pq.isEmpty() && pq.peek() < arr[i][1] - d) pq.remove();
            answer = Math.max(answer, pq.size());
        }
        
        System.out.println(answer);
    }
}