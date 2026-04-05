import java.util.*;

public class CycleDirectedGraph {

    static boolean dfs(int node, List<List<Integer>> adj, boolean[] visited, boolean[] rec) {
        if (rec[node]) return true;
        if (visited[node]) return false;

        visited[node] = true;
        rec[node] = true;

        for (int nei : adj.get(node)) {
            if (dfs(nei, adj, visited, rec)) return true;
        }

        rec[node] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0); // cycle

        boolean[] visited = new boolean[V];
        boolean[] rec = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (dfs(i, adj, visited, rec)) {
                System.out.println("Cycle Detected");
                return;
            }
        }
        System.out.println("No Cycle");
    }
}