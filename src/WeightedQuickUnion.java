package src;

public class WeightedQuickUnion implements DisjointSets {
    private int[] parent;
    private int[] size;

    public WeightedQuickUnion(int N) {
        parent = new int[N];
        size = new int[N];

        for (int i = 0; i < N; i += 1) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    private int find(int p) {
        if (p == parent[p]) {
            return p;

        } else {
            parent[p] = find(parent[p]);
            return parent[p];

        }

//        while (p != parent[p]) {
//            p = parent[p];
//        }
//
//        return p;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void connect(int p, int q) {
        int i = find(p);
        int j = find(q);

        if (i == j) {
            return;
        }

        if (size[i] > size[j]) {
            parent[i] = j;
            size[j] += size[i];

        } else {
            parent[j] = i;
            size[i] += size[j];

        }
    }
}



