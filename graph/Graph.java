package graph;

import java.util.*;

public class Graph {
    HashMap<String, ArrayList<String>> adjacencyList = new HashMap<String, ArrayList<String>>();

    public void addVertex(String vertex){
        adjacencyList.putIfAbsent(vertex, new ArrayList<String>());
    }

    public void addEdge(String vertex1, String vertex2){
        adjacencyList.get(vertex1).add(vertex2);
        adjacencyList.get(vertex2).add(vertex1);
    }

    public void removeVertex(String vertex){
        adjacencyList.remove(vertex);
        Set<String> set = adjacencyList.keySet();
        Iterator<String> iterator = set.iterator();

        while(iterator.hasNext()){
            Object v = iterator.next();
            ArrayList<String> list = adjacencyList.get(v);
            for (int i = 0; i <list.size() ; i++) {
                if(list.contains(vertex))
                    list.remove(vertex);
            }
        }
    }

    public void removeEdge(String vertex1, String vertex2){
        System.out.println(vertex1 +" " + vertex2);
        adjacencyList.get(vertex1).remove(vertex2);
        adjacencyList.get(vertex2).remove(vertex1);
    }

    public ArrayList<String> DFSRecursive(String vertex){
        ArrayList<String> result = new ArrayList<>();
        HashMap<String, Boolean> visited = new HashMap<>();
        Set<String> set = adjacencyList.keySet();
        Iterator<String> iterator = set.iterator();

        while(iterator.hasNext()){
            Object v = iterator.next();
            visited.put(v.toString(), false);
        }
        DFS(vertex, visited, result);
        return result;
    }

    void DFS(String vertex, HashMap<String, Boolean> visited, ArrayList<String> result){
        ArrayList<String> list = adjacencyList.get(vertex);
        visited.replace(vertex, true);
        result.add(vertex);
        for (int i = 0; i <list.size() ; i++) {
            if(!visited.get(list.get(i))) DFS(list.get(i), visited, result);     
        }   
    }

    public ArrayList<String> DFSIterative(String vertex){
        Stack<String> stack = new Stack<>();
        ArrayList<String> result = new ArrayList<>();
        HashMap<String, Boolean> visited = new HashMap<>();
        String currentVertex;
        Set<String> set = adjacencyList.keySet();
        Iterator<String> iterator = set.iterator();

        while(iterator.hasNext()){
            Object v = iterator.next();
            visited.put(v.toString(), false);
        }
        
        stack.push(vertex);
        visited.replace(vertex, true);
        while(!stack.isEmpty()){
            currentVertex = stack.pop();
            result.add(currentVertex);
            ArrayList<String> list = adjacencyList.get(currentVertex);
            for(String item : list){
                if(!visited.get(item)){
                    visited.replace(item, true);
                    stack.push(item);
                }
            }
        }
        return result;
    }

    public ArrayList<String> BFS(String vertex){
        Queue<String> q = new LinkedList<String>();
        ArrayList<String> result = new ArrayList<>();
        HashMap<String, Boolean> visited = new HashMap<>();
        String currentVertex;
        Set<String> set = adjacencyList.keySet();
        Iterator<String> iterator = set.iterator();

        while(iterator.hasNext()){
            Object v = iterator.next();
            visited.put(v.toString(), false);
        }
        
        q.add(vertex);
        visited.replace(vertex, true);
        while(!q.isEmpty()){
            currentVertex = q.poll();
            result.add(currentVertex);
            ArrayList<String> list = adjacencyList.get(currentVertex);
            for(String item : list){
                if(!visited.get(item)){
                    visited.replace(item, true);
                    q.add(item);
                }
            }
        }
        return result;
    }

    public void print(){
        System.out.println(adjacencyList.keySet());
        System.out.println(adjacencyList.values());
    }
}