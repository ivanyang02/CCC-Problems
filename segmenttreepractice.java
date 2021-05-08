import java.util.Scanner;
 
public class segmenttreepractice {
 
    static int[] originalArray;
 
    static int[] max;// store the maximum in each segment
 
    // store the array index each segment covers
    static int[] left, right;
 
    static void build(int l, int r, int segment) {
        // remember the left index and right index of each segment
        left[segment] = l;
        right[segment] = r;
 
        if (l == r) {// segment is size 1
            max[segment] = originalArray[l];
            return;
        }
 
        // cut segment in half
        int mid = (l + r) / 2;
 
        // build left and right children recursively
        build(l, mid, segment * 2 + 1);
        build(mid + 1, r, segment * 2 + 2);
 
        // get max from children
        max[segment] = Math.max(max[segment * 2 + 1], max[segment * 2 + 2]);
    }
 
    static void update(int index, int value, int segment) {
        // if this segment doesn't need to get updated
        if (left[segment] > index || right[segment] < index) {
            return;
        }
 
        // if this segment is size 1
        if (left[segment] == right[segment]) {
            // update directly
            max[segment] = value;
            return;
        }
 
        // recursively update children
        update(index, value, segment * 2 + 1);// left
        update(index, value, segment * 2 + 2);// right
 
        // update value using children
        max[segment] = Math.max(max[segment * 2 + 1], max[segment * 2 + 2]);
    }
 
    static int query(int l, int r, int segment) {
        // check if segment is inside range
        if (left[segment] > r || right[segment] < l) {
            return Integer.MIN_VALUE;
        }
 
        // check if segment is in range
        if (left[segment] >= l && right[segment] <= r) {
            return max[segment];
        }
 
        // recursively query
        return Math.max(query(l, r, segment * 2 + 1), query(l, r, segment * 2 + 2));
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();// read size of array
        int q = sc.nextInt();// read number of queries
 
        // read in original array
        originalArray = new int[n];
        for (int i = 0; i < n; i++) {
            originalArray[i] = sc.nextInt();
        }
 
        // builds segtree
        max = new int[n * 4];
        left = new int[n * 4];
        right = new int[n * 4];
        build(0, n - 1, 0);
 
        // read in queries
        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                int index = sc.nextInt() - 1;
                int value = sc.nextInt();
                update(index, value, 0);
            } else {
                int l = sc.nextInt() - 1;
                int r = sc.nextInt() - 1;
                System.out.println(query(l, r, 0));
            }
        }
    }
 
}