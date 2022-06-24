package Course.CodeWars;

import java.util.*;

public class Finder {

    public static boolean pathFinder(String maze) {
        String nMaze = maze.replace("\n","");
        Integer lengthMaze = Double.valueOf(Math.sqrt(Double.valueOf(nMaze.length()))).intValue();
        List<Node> nodes = new ArrayList<>();
        Edge[] edges = new Edge[((nMaze.length()-1)*nMaze.length())/2];

        fillEdges(nMaze, lengthMaze, nodes, edges);

        List<Edge> listEdges = new ArrayList<>();
        listEdges.addAll(Arrays.asList(edges));

        Edge edge = Edge.findEdge(nodes.get(0),nodes.get(nodes.size()-1),listEdges);
        edge.weight = Integer.MAX_VALUE;

        calculateWeight(listEdges,new HashMap<Node,Node>(),edge,edge.node1);

        return !(edge.weight == Integer.MAX_VALUE);
    }

    private static void fillEdges(String nMaze, Integer lengthMaze, List<Node> nodes, Edge[] edges) {
        int count = 0;
        for (int i = 0; i < lengthMaze; i++) {
            for (int j = 0; j < lengthMaze; j++) {
                if (!nMaze.substring(count,count+1).equals("W")) {
                    Node node = new Node(j, i, nMaze.substring(count, count + 1));
                    nodes.add(node);
                }
                count++;
            }
        }

        count = 0;
        for (int i = 0; i < nodes.size(); i++) {
            for (int j = 0; j < nodes.size(); j++) {
                Edge edge = new Edge(nodes.get(i), nodes.get(j),0);
                boolean create = true;
                for (int k = 0; k < edges.length; k++) {
                    if (edges[k] == null) break;
                    if (edges[k].node1 == nodes.get(j) && edges[k].node2 == nodes.get(i)){
                        create = false;
                    }
                }
                if (nodes.get(j) == nodes.get(i)) create = false;
                if (create) {
                    edges[count] = edge;
                    if (!edge.node2.value.equals("W")) {
                        Integer delta = edge.node1.x - edge.node2.x + edge.node1.y - edge.node2.y;
                        if (delta == -1 || delta == 1) edge.weight++;
                    }else edge.weight = Integer.MAX_VALUE;
                    count++;
                }
            }
        }
    }

    private static void calculateWeight(List<Edge> edges, Map<Node,Node> way, Edge firstEdge, Node firstNode){
        Map<Node,Node> nWay = new HashMap<>(way);

        List<Edge> listEdges = new ArrayList<>();
        listEdges.addAll(edges);

        for (int i = 0; i < listEdges.size(); i++) {
            Edge edge = listEdges.get(i);
            if (!edge.node2.value.equals("W") && !edge.node1.value.equals("W")) {
                if (edge.node1 != firstNode)
                    continue;
                if (!(way.get(edge.node2) == null)) listEdges.remove(edge);
                else if (edge.weight > 0 && edge != firstEdge) {
                    if (firstEdge.node2 == edge.node2) {
                        firstEdge.weight = nWay.size() > firstEdge.weight ? firstEdge.weight : nWay.size();
                    }
                    nWay.put(edge.node2, edge.node2);//listEdges.node2
                    calculateWeight(edges, nWay, firstEdge, edge.node2);
                }
            }
        }
    }

    private static class Node{
        int x = 0,y = 0;
        String value = "";

        public Node(int x, int y, String value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    private static class Edge{
        Node node1;
        Node node2;
        int weight;

        public Edge(Node node1, Node node2, int weight) {
            this.node1 = node1;
            this.node2 = node2;
            this.weight = weight;
        }

        public static Edge findEdge(Node node1, Node node2,List<Edge> edgeList){
            Edge result = null;

            for (int i = 0; i < edgeList.size(); i++) {
                Edge nowEdge = edgeList.get(i);
                if (nowEdge == null) continue;
                if (nowEdge.node1.equals(node1) && nowEdge.node2.equals(node2)) result = nowEdge;
            }

            return result;
        }
    }

}
