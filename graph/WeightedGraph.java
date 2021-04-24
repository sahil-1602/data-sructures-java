package graph;
import java.util.*;
public class WeightedGraph {
    HashMap<String, ArrayList<Node>> adjacencyList = new HashMap<String, ArrayList<Node>>();

    public void addVertex(String vertex){
        adjacencyList.putIfAbsent(vertex, new ArrayList<Node>());
    }

    public void addEdge(String vertex1, String vertex2, int weight){
        adjacencyList.get(vertex1).add(new Node(vertex2, weight));
        adjacencyList.get(vertex2).add(new Node(vertex1, weight));
    }

    public void print(){
        System.out.println(adjacencyList.keySet());
        Set<String> set = adjacencyList.keySet();
        Iterator<String> iterator = set.iterator();
        System.out.println();
        System.out.print("[ ");
        while(iterator.hasNext()){
            Object v = iterator.next();
            ArrayList<Node> list = adjacencyList.get(v);
            for(Node item : list){
                System.out.print("["+item.vertex+", "+item.weight+"] ");
            }
        }
        System.out.print("]");
        System.out.println();
    }
}

class Node {
    String vertex;
    int weight;
    Node(String vertex, int weight){
        this.vertex = vertex;
        this.weight = weight;
    }
}