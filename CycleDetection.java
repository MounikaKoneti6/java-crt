import java.util.*;
class Graph {
    private Map<Integer, List<Integer>> adjList;
        adjList = new HashMap<>();
    }
    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.get(u).add(v);
        adjList.get(v).add(u);  
    }
    public boolean hasCycle() {
        Set<Integer> visited = new HashSet<>();
        for (Integer node : adjList.keySet()) {
            if (!visited.contains(node)) {
                if (dfs(node, visited, -1)) {
                    return true; // Cycle detected
                }
            }
        }
        return false; // No cycle detected
    }
    private boolean dfs(int current, Set<Integer> visited, int parent) {
        visited.add(current);
        for (int neighbor : adjList.get(current)) {
            if (!visited.contains(neighbor)) {
                if (dfs(neighbor, visited, current)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }
}
public class CycleDetection {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        if (graph.hasCycle()) {
            System.out.println("Cycle detected in the graph.");
        } else {
            System.out.println("No cycle detected in the graph.");
        }
    }
}
