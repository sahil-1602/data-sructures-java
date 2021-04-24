package graph;

public class Test {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVertex("B");
        g.addVertex("A");
        g.addVertex("C");
        g.addVertex("D");
        g.addVertex("E");
        g.addVertex("F");

        g.addEdge("A", "B");
        g.addEdge("A", "C");
        g.addEdge("B", "D");
        g.addEdge("C", "E");
        g.addEdge("D", "E");
        g.addEdge("D", "F");
        g.addEdge("E", "F");

        System.out.println(g.DFSRecursive("A"));
        System.out.println(g.DFSIterative("A"));
        System.out.println(g.BFS("A"));

        // WeightedGraph wG = new WeightedGraph();
        // wG.addVertex("A");
        // wG.addVertex("B");
        // wG.addEdge("A", "B", 10);
        // wG.print();
    }
}