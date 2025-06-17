import java.util.*;
class Graph {
    private Map<Integer, List<Integer>> adjList;
    public Graph() {
        adjList = new HashMap<>();
    }
    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.get(u).add(v);
        adjList.get(v).add(u); 
    }
    public int countConnectedComponents() {
        Set<Integer> visited = new HashSet<>();
        int componentCount = 0;
        for (Integer node : adjList.keySet()) {
            if (!visited.contains(node)) {
                dfs(node, visited);
                componentCount++; 
            }
        }
        return componentCount;
    }
    private void dfs(int node, Set<Integer> visited) {
        visited.add(node); 
        for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited);
            }
        }
    }
}
public class CountComponents {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        int numComponents = graph.countConnectedComponents();
        System.out.println("Number of connected components: " + numComponents);
    }
}
