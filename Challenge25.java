import java.util.*;
public class Challenge25{
    
    private static boolean dfs(int node, int parent, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, adj, visited)) return true;
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasCycle(int V, List<List<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        Set<String> edgeSet = new HashSet<>();

        for (List<Integer> edge : edges) {
            int u = edge.get(0), v = edge.get(1);
            if (u == v) continue; 

            String pair = u < v ? u + "-" + v : v + "-" + u;
            if (edgeSet.contains(pair)) return true;
            edgeSet.add(pair);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, adj, visited)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test Case 1
        int V1 = 5;
        List<List<Integer>> edges1 = Arrays.asList(
                Arrays.asList(0, 1), Arrays.asList(1, 2),
                Arrays.asList(2, 3), Arrays.asList(3, 4), Arrays.asList(4, 0)
        );
        System.out.println("Test 1: " + hasCycle(V1, edges1));  

        // Test Case 2
        int V2 = 3;
        List<List<Integer>> edges2 = Arrays.asList(
                Arrays.asList(0, 1), Arrays.asList(1, 2)
        );
        System.out.println("Test 2: " + hasCycle(V2, edges2));  

        // Test Case 3
        int V3 = 4;
        List<List<Integer>> edges3 = Arrays.asList(
                Arrays.asList(0, 1), Arrays.asList(1, 2), Arrays.asList(2, 0)
        );
        System.out.println("Test 3: " + hasCycle(V3, edges3)); 

        // Edge Case: No edges
        int V4 = 5;
        List<List<Integer>> edges4 = new ArrayList<>();
        System.out.println("Test 4: " + hasCycle(V4, edges4));  /

        // Edge Case: Tree (connected, no cycles)
        int V5 = 5;
        List<List<Integer>> edges5 = Arrays.asList(
                Arrays.asList(0, 1), Arrays.asList(1, 2),
                Arrays.asList(2, 3), Arrays.asList(3, 4)
        );
        System.out.println("Test 5: " + hasCycle(V5, edges5)); 

    }

}