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

    public Node getNode(String v) {
        return V.get(v);
    }

    public Set<String> getVetex() {
        return V.keySet();
    }

    public int getSize() {
        return size;
    }

    public int getESize() {
        return esize;
    }

    public String traversePath(Map<String, Node> edgeTo, String source) {
        StringBuilder output = new StringBuilder();
        output.append(source);

        while (edgeTo.containsKey(source)) {
            source = (String) edgeTo.get(source).getVal();
//            System.out.println(source);

            output.append(" -> " + source);
        }

        /**
        for(String s : edgeTo.keySet()) {
            StringBuilder out = new StringBuilder();

            out.append(s + " -> ");
            out.append(edgeTo.get(s).getVal());

            System.out.println(out.toString());
        }
        */

        return output.toString();
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

    public static class DepthFirstPaths {
        private Map<String, Boolean> marked = new HashMap<>();
        private Map<String, Node> edgeTo = new TreeMap<>();
        private String source;

        public DepthFirstPaths(Graph G, String source) {
            this.source = source;

            for (String v : G.getVetex()) {
                marked.put(v, false);
            }

            dfs(G, this.source);

            for(String s : edgeTo.keySet()) {
                StringBuilder out = new StringBuilder();

                out.append(s + " -> ");
                out.append(edgeTo.get(s).getVal());

                System.out.println(out.toString());
            }
        }

        private void dfs(Graph G, String source) {
            marked.replace(source, true);
            for (Object obj : G.getNode(source).getAdj()) {
                String s = (String) obj;
//                System.out.println(s);
                if(!marked.get(s)) {
                    edgeTo.put(s, G.getNode(source));
                    dfs(G, s);
                }
            }
//            System.out.println(edgeTo.keySet().size());
        }
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
        String[] lst = new String[]{"A","B","C","D","E","F","A-B","A-F","B-C","B-D","D-C","D-E","C-E", "F-E"};

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
        Integer[] w_lst = new Integer[]{5, 9, 6, 10, 3, 5, 7, 21};

        Map<String, Integer> e_map = new TreeMap<>();

        assert e_lst.length == w_lst.length;

        for (int i = 0; i < e_lst.length; i += 1){
            e_map.put(e_lst[i], w_lst[i]);
        }

        Graph G  = new Graph(v_lst, e_map);

        System.out.println(G);

        DepthFirstPaths p = new DepthFirstPaths(G, v_lst[0]);
        p.dfs(G, v_lst[0]);
        
//        System.out.println(G.traversePath(p.edgeTo, v_lst[0]));

    }

}


