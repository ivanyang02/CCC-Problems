import java.util.*;
import java.io.*;

public class hotandcold {

    static ArrayList<Integer> adj[] = new ArrayList[6005];
    static ArrayList<Integer> dist[] = new ArrayList[6005];
    static int[] depth = new int[6005];
    static int[][] sparse = new int[6005][15];
    static long[][] sum = new long[6005][15];

    //visit all the nodes and initialize important values
    static void dfs(int N, int P, int D){
        //get the depth of each node. If it is the root, the depth is 0, otherwise the depth is one higher than the parent's depth
        if (N == 0) depth[N] = 0;
        else depth[N] = depth[P] + 1;

        //the first node above is the parent, and the distance is the length to the parent
        sparse[N][0] = P;
        sum[N][0] = D;

        //loop up to the highest power above log_2(N)
        for (int l = 1; l < 14; ++l){
            //jumping 2^l is the same as jumping 2^(l-1) twice
            sparse[N][l] = sparse[sparse[N][l-1]][l-1];
            //the total is the sum of lengths of the two jumps
            sum[N][l] = sum[N][l-1] + sum[sparse[N][l-1]][l-1];
        }

        for (int l = 0; l < adj[N].size(); ++l){
            //visit every child
            if (adj[N].get(l) == P) continue;
            dfs(adj[N].get(l), N, dist[N].get(l));
        }
    }

    static long pathLength(int A, int B){
        long ans = 0;
        int pow = 13;
        //if A is lower than B, reduce it to an ancestor of the same depth as B
        while(depth[A] > depth[B]){
            while(pow > 0 && depth[A] - (1<<pow) < depth[B]) pow--;
            //if 2^pow reduces the depth of A to less than B, it goes too far
            //add current jump length to the total
            ans += sum[A][pow];
            A = sparse[A][pow];
        }
        //vice versa
        while(depth[B] > depth[A]){
            while(pow > 0 && depth[B] - (1<<pow) < depth[A]) pow--;
            ans += sum[B][pow];
            B = sparse[B][pow];
        }
        //A and B will now have the same depth

        //System.out.println(A + " " + B);
        pow = 13;
        while(A != B){
            while(pow > 0 && sparse[A][pow]==sparse[B][pow]) pow--;
            //if jumping up A and B goes to an identical node and pow > 1, it is possible that there is a lower ancestor, so the power should be smaller
            //then jump until you reach the LCA
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
        int q = in.nextInt();
        for (int l = 1; l <= n; l++){
            adj[l] = new ArrayList<Integer>();
        }
        for(int l = 1; l < n; l++){
            int a = in.nextInt(), b = in.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }

        dfs(0, 0, 0);

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