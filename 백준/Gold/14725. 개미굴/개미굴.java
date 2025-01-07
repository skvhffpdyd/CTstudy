import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeMap<String, Object> root = new TreeMap<>();

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            TreeMap<String, Object> current = root;

            for(int j=0; j<k; j++){
                String val = st.nextToken();
                current.putIfAbsent(val, new TreeMap<>());
                current = (TreeMap<String, Object>) current.get(val);
            }
        }
        printTree(root, 0);
    }

    private static void printTree(TreeMap<String, Object> tree, int depth){
        for(var entry : tree.entrySet()){
            System.out.println("--".repeat(depth) + entry.getKey());
            printTree((TreeMap<String, Object>) entry.getValue(), depth+1);
        }
    }
}