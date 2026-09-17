import java.util.*;

public class CycleDetectionBFS {

    static boolean hasCycle(int[][] graph) {

        int n = graph.length;
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }

        for (int start = 0; start < n; start++) {

            if (!visited[start]) {

                Queue<Integer> queue = new LinkedList<>();

                queue.add(start);
                visited[start] = true;

                while (!queue.isEmpty()) {

                    int node = queue.poll();

                    for (int i = 0; i < n; i++) {

                        if (graph[node][i] == 1) {

                            if (!visited[i]) {

                                visited[i] = true;
                                parent[i] = node;
                                queue.add(i);
                            }

                            else if (parent[node] != i) {
                                return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[][] graph = {
            {0, 1, 1, 0},
            {1, 0, 1, 0},
            {1, 1, 0, 1},
            {0, 0, 1, 0}
        };

        if (hasCycle(graph))
            System.out.println("Cycle exists");
        else
            System.out.println("No cycle");
    }
}
