package JavaBoard;

import java.util.*;

public class Graph {
    private static final String NEWLINE = System.getProperty("line.separator");
    private Map<String, Node> V = new TreeMap<>();
    private int size;
    private int esize;

    /**
     * ["7","A","B","C","D","E","F","G","A-B","A-E","B-C","C-D","D-F","E-D","F-G"]
     * [5, 25, 16, 56, 78, 24, 35]
     *
     * @param input_V
     * @param input_E
     */
    public Graph(String[] input_V, Map<String, Integer> input_E) {
        size = input_V.length;
        esize = input_E.keySet().size();

        for (String v : input_V) {
            V.put(v, new Node(v));
        }

        for (String e : input_E.keySet()) {
            String[] e_nodes = e.split("-", 2);

            V.get(e_nodes[0]).addEdge(V.get(e_nodes[1]), input_E.get(e));
            V.get(e_nodes[1]).addEdge(V.get(e_nodes[0]), input_E.get(e));
        }
    }

    public int getSize() {
        return size;
    }

    public int getESize() {
        return esize;
    }

    private void validateVertex(String v) {
        if (!V.containsKey(v)) {
            throw new IllegalArgumentException("vertex " + v + " is not included in the graph.");
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(this.getSize() + " vertices, " + this.getESize() + " edges " + NEWLINE);
        for (String v : V.keySet()) {
            s.append(v + ": ");

            Node current = V.get(v);
            for (Object w : current.getAdj()) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    private class Node<T> {
        private Map<T, Integer> adj = new TreeMap<>();
        private T val;

        public Node(T val) {
            this.val = val;
        }

        public Node(T val, Node[] adj) {
            this.val = val;

            for (Node a : adj) {
                this.adj.put((T) a.getVal(), 1);
            }
        }

        public void addEdge(Node n, int weight) {
            adj.put((T) n.getVal(), weight);
        }

        public T getVal() {
            return val;
        }

        public Set<T> getAdj() {
            return adj.keySet();
        }

        public int degree(String v) {
            validateVertex(v);
            return adj.size();
        }

    }


    public static void main(String[] args) {
        String[] lst = new String[]{"A","B","C","D","E","F","G","A-B","A-E","B-C","C-D","D-F","E-D","F-G"};

        int split_index = 0;
        for (int i = 0; i < lst.length; i += 1) {
            String s = lst[i];

            if(s.contains("-")){
                split_index = i;
                break;
            }
        }

        String[] v_lst = Arrays.copyOfRange(lst, 0, split_index);
//        System.out.println(split_index);
//        System.out.println(lst.length);
//        System.out.println(lst.length - v_lst.length);

        String[] e_lst = Arrays.copyOfRange(lst, split_index + 1, lst.length);
        Integer[] w_lst = new Integer[]{5, 25, 16, 56, 78, 24, 35};

        Map<String, Integer> e_map = new TreeMap<>();

        assert e_lst.length == w_lst.length;

        for (int i = 0; i < e_lst.length; i += 1){
            e_map.put(e_lst[i], w_lst[i]);
        }

        Graph G  = new Graph(v_lst, e_map);

        System.out.println(G);
    }


}
