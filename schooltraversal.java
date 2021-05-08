import java.util.*;
import java.io.*;

public class schooltraversal {

    static ArrayList<Integer> adj[] = new ArrayList[6005];
    static ArrayList<Integer> dist[] = new ArrayList[6005];
    static int[] depth = new int[6005];
    static int[][] sparse = new int[6005][15];
    static long[][] sum = new long[6005][15];

    static void dfs(int N, int P, int D){
        if (N == 0) depth[N] = 0;
        else depth[N] = depth[P] + 1;
        sparse[N][0] = P;
        sum[N][0] = D;

        for (int l = 1; l < 14; ++l){
            sparse[N][l] = sparse[sparse[N][l-1]][l-1];
            sum[N][l] = sum[N][l-1] + sum[sparse[N][l-1]][l-1];
        }

        for (int l = 0; l < adj[N].size(); ++l){
            if (adj[N].get(l) == P) continue;
            dfs(adj[N].get(l), N, dist[N].get(l));
        }
    }

    static long pathLength(int A, int B){
        long ans = 0;
        int pow = 13;
        while(depth[A] > depth[B]){
            while(pow > 0 && depth[A] - (1<<pow) < depth[B]) pow--;
            ans += sum[A][pow];
            A = sparse[A][pow];
        }
        while(depth[B] > depth[A]){
            while(pow > 0 && depth[B] - (1<<pow) < depth[A]) pow--;
            ans += sum[B][pow];
            B = sparse[B][pow];
        }

        //System.out.println(A + " " + B);
        pow = 13;
        while(A != B){
            while(pow > 0 && sparse[A][pow]==sparse[B][pow]) pow--;
            ans += sum[A][pow];
            ans += sum[B][pow];
            A = sparse[A][pow];
            B = sparse[B][pow];
        }

        return ans;

    }

    public static void main(String[] args) {
        //Input
        FastReader in = new FastReader();
        int n = in.nextInt();
        for (int l = 0; l < n; ++l){
            adj[l] = new ArrayList<Integer>();
            dist[l] = new ArrayList<Integer>();
        }
        for(int l = 0; l < n-1; ++l){
            int a = in.nextInt(), b = in.nextInt(), d = in.nextInt();
            adj[a].add(b);
            dist[a].add(d);
            adj[b].add(a);
            dist[b].add(d);
        }

        dfs(0, 0, 0);

        int q = in.nextInt();
        for (int l = 0; l < q; ++l){
            int a = in.nextInt(), b = in.nextInt();
            System.out.println(pathLength(a, b));
        }


    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}