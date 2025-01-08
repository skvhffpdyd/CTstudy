import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int a = 0;
        int b = 0;
        int zero = 2000000000;
        int left = 0;
        int right = n - 1;

        while(left < right){
            int sum = arr[left] + arr[right];
            if(Math.abs(sum) < Math.abs(zero)){
                zero = sum;
                a = arr[left];
                b = arr[right];
            }
            if(sum == 0) break;
            if(sum > 0) right--;
            else left++;
        }

        System.out.println(a + " " + b);
    }
}