public class lazysegmenttree {
    // contains the sum of each node
    static int[] total = new int[400000];
    static int[] left = new int[400000], right = new int[400000];
    static int[] debt = new int[400000];
 
    static int[] data;
 
    static void push_up(int segment) {
        total[segment] = total[segment * 2] + total[segment * 2 + 1];
    }
 
    static void apply(int segment, int lazy) {
        int size = right[segment] - left[segment] + 1;
        total[segment] += lazy * size;
        debt[segment] += lazy;
    }
 
    static void push_down(int segment) {
        apply(segment * 2, debt[segment]);
        apply(segment * 2 + 1, debt[segment]);
        debt[segment] = 0;
    }
 
    static void build(int l, int r, int node) {
        // store where this node begin and end
        left[node] = l;
        right[node] = r;
        if (l + 1 == r) {
            total[node] = data[l];
            return;
        }
        int mid = (l + r) / 2;
        build(l, mid, node * 2);
        build(mid, r, node * 2 + 1);
 
        total[node] = total[node * 2] + total[node * 2 + 1];
    }
 
    static int query(int l, int r, int node) {
        // if current node is not inside interval
        if (left[node] >= r || right[node] <= l) {
            return 0;
        }
        // if current node is completely inside interval
        if (left[node] >= l && right[node] <= r) {
            return total[node];
        }
        // must make sure this segment doesn't have any lazy
//      push_down(node);
        // part of the thing
        return query(l, r, node * 2) + query(l, r, node * 2 + 1);
    }
 
    static void update(int L, int R, int value, int node) {
        // check if segment is not inside the part we want to change
        if (right[node] < L || left[node] > R) {
            return;
        }
 
        // check if segment is completely inside the part we want to change
        if (left[node] >= L || right[node] <= R) {
            apply(node, value);
            return;
        }
 
        // check children
        push_down(node);
        update(L, R, value, node * 2);
        update(L, R, value, node * 2 + 1);
 
        // update itself
        total[node] = total[node * 2] + total[node * 2 + 1];
    }
 
    public static void main(String[] args) {
        data = new int[] { 3, 2, 4, 1, 2, 7, 8, 5 };
        System.out.println(2 + 4 + 1 + 2 + 7);
        build(0, 8, 1);
        System.out.println(query(1, 6, 1));
    }
}