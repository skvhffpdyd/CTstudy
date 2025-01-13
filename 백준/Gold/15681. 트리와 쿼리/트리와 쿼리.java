import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int root = 0;
    public static int[] count;
    public static Map<Integer, ArrayList<Integer>> tree;
    public int ts = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        tree = new HashMap<>();
        int n = Integer.parseInt(st.nextToken());
        root = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        count = new int[n + 1];
        count[root] = n;
        for(int i = 1; i <= n; i++){
            tree.put(i, new ArrayList<>());
        }

        for(int i = 0; i < n - 1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        buildTree(root, -1);

        for(int i = 0; i < q; i++){
            int u = Integer.parseInt(br.readLine());
            System.out.println(count[u]);
        }

    }

    public static void buildTree(int current, int parent){
        count[current] = 1;
        ArrayList<Integer> child = tree.get(current);

        for(int c : child){
            if(c == parent) continue;
            buildTree(c, current);
            count[current] += count[c];
        }
    }
}