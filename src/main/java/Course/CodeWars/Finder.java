package Course.CodeWars;

import java.util.*;

public class Finder {

    public static boolean pathFinder(String maze) {
        String nMaze = maze.replace("\n","");
        Integer lengthMaze = Double.valueOf(Math.sqrt(Double.valueOf(nMaze.length()))).intValue();
        Node[] nodes = new Node[nMaze.length()];
        Edge[] edges = new Edge[((nMaze.length()-1)*nMaze.length())/2];

        fillEdges(nMaze, lengthMaze, nodes, edges);

        List<Edge> listEdges = new ArrayList<>();
        listEdges.addAll(Arrays.asList(edges));

        Edge edge = Edge.findEdge(nodes[0],nodes[nodes.length-1],listEdges);

        calculateWeight(listEdges,new HashMap<Node,Node>(),edge);

        return false;
    }

    private static void fillEdges(String nMaze, Integer lengthMaze, Node[] nodes, Edge[] edges) {
        int count = 0;
        for (int i = 0; i < lengthMaze; i++) {
            for (int j = 0; j < lengthMaze; j++) {
                Node node = new Node(j,i, nMaze.substring(count,count+1));
                nodes[count] = node;
                count++;
            }
        }

        count = 0;
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes.length; j++) {
                Edge edge = new Edge(nodes[i], nodes[j],0);
                boolean create = true;
                for (int k = 0; k < edges.length; k++) {
                    if (edges[k] == null) break;
                    if (edges[k].node1 == nodes[j] && edges[k].node2 == nodes[i]){
                        create = false;
                    }
                }
                if (nodes[j] == nodes[i]) create = false;
                if (create) {
                    edges[count] = edge;
                    if (!edge.node2.value.equals("w")) {
                        Integer delta = edge.node1.x - edge.node2.x + edge.node1.y - edge.node2.y;
                        if (delta == -1 || delta == 1) edge.weight++;
                    }else edge.weight = Integer.MAX_VALUE;
                    count++;
                }
            }
        }
    }

    private static void calculateWeight(List<Edge> edges, Map<Node,Node> way, Edge firstEdge){
        List<Edge> listEdges = new ArrayList<>();
        listEdges.addAll(edges);

        for (Edge edge: listEdges) {
            if (!(way.get(edge.node2) == null)) listEdges.remove(edge);
        }

        for (int i = 0; i < listEdges.size(); i++) {
            Edge edge = listEdges.get(i);
            way.put(edge.node2,edge.node2);//listEdges.node2

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
                if (nowEdge.node1.equals(node1) && nowEdge.node2.equals(node2)) result = nowEdge;
            }

            return result;
        }
    }

}
