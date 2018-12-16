package interview;

import java.util.*;

public class ShortestPath {
    public static String ShortestPath(String[] strArr) {
        int size = Integer.parseInt(strArr[0]);
        String[] inputNodes = Arrays.copyOfRange(strArr, 1, size + 1);
        String[] inputConnections = Arrays.copyOfRange(strArr, size + 1, strArr.length);
        Graph graph = new Graph(size);
        for (String inputConnection : inputConnections) {
            String[] connectedNodes = inputConnection.split("-");
            graph.addEdge(connectedNodes[0], connectedNodes[1]);
        }
        String start = inputNodes[0];
        String end = inputNodes[size - 1];
        return graph.shortestPath(start, end);
    }

    static class Graph {
        int size;
        Map<String, SequentialList<String>> connections;

        Graph(int size) {
            this.size = size;
            connections = new TreeMap<>();
        }

        void addEdge(String src, String dest) {
            SequentialList<String> connectionsSrc = this.connections.computeIfAbsent(src, k -> new SequentialList<>());
            connectionsSrc.addFirst(dest);
            SequentialList<String> connectionsDest = this.connections.computeIfAbsent(dest, k -> new SequentialList<>());
            connectionsDest.addFirst(src);
        }

        String shortestPath(String src, String dest) {
            Set<String> visited = new HashSet<>();
            SequentialList<String> queue = new SequentialList<>();
            Map<String, Integer> dist = new HashMap<>();
            Map<String, String> pred = new HashMap<>();
            for (String node : this.connections.keySet()) {
                dist.put(node, Integer.MAX_VALUE);
                pred.put(node, "");
            }
            visited.add(src);
            dist.put(src, 0);
            queue.addLast(src);
            while (!queue.isEmpty()) {
                String u = queue.getFirst();
                queue.removeFirst();
                SequentialList<String> connectedNodes = this.connections.get(u);
                if (connectedNodes != null) {
                    for (String connectedNode : connectedNodes) {
                        if (!visited.contains(connectedNode)) {
                            visited.add(connectedNode);
                            dist.put(connectedNode, dist.get(u) + 1);
                            pred.put(connectedNode, u);
                            queue.addLast(connectedNode);
                            if (connectedNode.equals(dest)) {
                                return printPath(pred, dest);
                            }
                        }
                    }
                }
            }
            return "-1";
        }

        private String printPath(Map<String, String> pred, String dest) {
            SequentialList<String> path = new SequentialList<>();
            String crawl = dest;

            path.addLast(crawl);
            while (!pred.get(crawl).equals("")) {
                path.addLast(pred.get(crawl));
                crawl = pred.get(crawl);
            }

            StringBuilder sb = new StringBuilder();
            for (int i = path.size() - 1; i >= 0; i--) {
                sb.append(path.get(i)).append("-");
            }
            return sb.toString().substring(0, sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(ShortestPath(new String[]{s.nextLine()}));
    }

}
