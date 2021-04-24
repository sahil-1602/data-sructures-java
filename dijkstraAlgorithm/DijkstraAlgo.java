package dijkstraAlgorithm;

import java.util.*;

public class DijkstraAlgo {
    public static void main(String[] args) {
        var graph = new WeightedGraph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 2);
        graph.addEdge("B", "E", 3);
        graph.addEdge("C", "D", 2);
        graph.addEdge("C", "F", 4);
        graph.addEdge("D", "E", 3);
        graph.addEdge("D", "F", 1);
        graph.addEdge("E", "F", 1);

        System.out.println(graph.Dijkstra("A", "C"));
    }
}

class WeightedGraph {
    HashMap<String, ArrayList<Node>> adjacencyList = new HashMap<String, ArrayList<Node>>();

    public void addVertex(String vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<Node>());
    }

    public void addEdge(String vertex1, String vertex2, int weight) {
        adjacencyList.get(vertex1).add(new Node(vertex2, weight));
        adjacencyList.get(vertex2).add(new Node(vertex1, weight));
    }

    public ArrayList<String> Dijkstra(String start, String finish) {
        PriorityQueue nodes = new PriorityQueue();
        HashMap<String, Integer> distances = new HashMap<>();
        HashMap<String, String> previous = new HashMap<>();
        String smallest;
        ArrayList<String> path = new ArrayList<>(); // PATH TO RETURN AT THE END

        // Build up the initial state
        Set<String> set = adjacencyList.keySet();
        Iterator<String> iterator = set.iterator();

        while (iterator.hasNext()) {
            Object vertex = iterator.next();
            previous.put(vertex.toString(), null);
            if (vertex.toString().equals(start)) {
                distances.put(start, 0);
                nodes.enqueue(vertex.toString(), 0);
            } else {
                distances.put(vertex.toString(), Integer.MAX_VALUE);
                nodes.enqueue(vertex.toString(), Integer.MAX_VALUE);
            }
        }

        while (!nodes.isEmpty()) {
            smallest = nodes.dequeue().val;

            if (smallest.equals(finish)) {
                // WE ARE DONE
                // BUILD UP PATH TO RETURN AT THE END
                while (previous.get(smallest) != null) {
                    path.add(smallest);
                    smallest = previous.get(smallest);
                }
                break;
            }
            if (distances.get(smallest) != Integer.MAX_VALUE) {
                ArrayList<Node> list = adjacencyList.get(smallest);
                int length = list.toArray().length;
                for (int i = 0; i < length; i++) {
                    // FIND NEIGHBORING NODE
                    Node nextNode = list.get(i);
                    // CALCULATE NEW DISTANCE TO NEIGHBORING NODE
                    String nextNeighbor = nextNode.vertex;
                    int candidate = distances.get(smallest) + nextNode.weight;
                    if (candidate < distances.get(nextNeighbor)) {
                        // UPDATING NEW SMALLEST DISTANCE OF THE NEIGHBORSs
                        distances.replace(nextNeighbor, candidate);
                        // UPDATING PREVIOUS - HOW WE GOT TO NEXT NEIGHBOR
                        previous.replace(nextNeighbor, smallest);
                        // ENQUEUE IN PRIORITY QUEUE WITH NEW PRIORITY
                        nodes.enqueue(nextNeighbor, candidate);
                    }
                }
            }
        }
        path.add(start);
        ArrayList<String> reversedPath = new ArrayList<>();
        for (int i = path.toArray().length - 1; i >= 0; i--) {
            reversedPath.add(path.get(i));
        }
        return reversedPath;
    }
}

class Node {
    String vertex;
    int weight;

    Node(String vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

class PriorityQueue {

    ArrayList<NodeP> values = new ArrayList<NodeP>();

    public void enqueue(String val, int priority) {
        NodeP toAdd = new NodeP(val, priority);
        values.add(toAdd);
        bubbleUp();
    }

    public NodeP dequeue() {
        int idx = 0;
        NodeP min = values.get(idx);
        int length = (values.toArray().length);
        NodeP element = values.remove(length - 1);
        if (!values.isEmpty()) {
            values.set(idx, element);
            sinkDown();
        }
        return min;
    }

    public boolean isEmpty() {
        return values.isEmpty();
    }

    void bubbleUp() {
        int idx = (values.toArray().length) - 1;
        NodeP element = values.get(idx);
        while (idx > 0) {
            int parentIdx = (idx - 1) / 2;
            NodeP parent = values.get(parentIdx);
            if (element.priority >= parent.priority)
                break;
            values.set(parentIdx, element);
            values.set(idx, parent);
            idx = parentIdx;
        }
    }

    void sinkDown() {
        int idx = 0;
        int length = values.toArray().length;
        NodeP element = values.get(idx);

        while (true) {

            int leftChildIdx = 2 * idx + 1;
            int rightChildIdx = 2 * idx + 2;
            NodeP leftChild, rightChild;
            int swapIdx = 0;
            boolean noSwaps = true;
            leftChild = null;
            if (leftChildIdx < length) {
                leftChild = values.get(leftChildIdx);
                if (leftChild.priority < element.priority) {
                    swapIdx = leftChildIdx;
                    noSwaps = false;
                }
            }
            if (rightChildIdx < length) {
                rightChild = values.get(rightChildIdx);
                if ((noSwaps && rightChild.priority < element.priority)
                        || (!noSwaps && rightChild.priority < leftChild.priority)) {
                    swapIdx = rightChildIdx;
                    noSwaps = false;
                }
            }

            if (noSwaps)
                break;
            values.set(idx, values.get(swapIdx));
            values.set(swapIdx, element);
            idx = swapIdx;
        }
    }
}

class NodeP {
    String val;
    int priority;

    NodeP(String val, int priority) {
        this.val = val;
        this.priority = priority;
    }

}
