import java.util.ArrayList;
import java.util.List;

public class OrderOfCourses {

    private List<List<Integer>> graph;
    private List<Integer> visited;
    private List<Integer> answer;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[]{};
        }

        answer = new ArrayList<>();
        visited = new ArrayList<>();
        graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            visited.add(0);
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int to = prerequisites[i][0];
            int from = prerequisites[i][1];
            graph.get(from).add(to);
        }

        for (int i = 0; i < numCourses; i++) {
            boolean indexVisited = visited.get(i) != 0;
            if (!indexVisited) {
                boolean cycle = dfs(i);
                if (cycle) {
                    return new int[]{};
                }
            }
        }

        int result[] = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = answer.get(numCourses - i - 1);
        }
        return result;
    }

    private boolean dfs(int index) {
        visited.set(index, 1);

        for (int i = 0; i < graph.get(index).size(); i++) {
            int to = graph.get(index).get(i);
            if (visited.get(to) == 1) {
                return true;
            }
            if (visited.get(to) == 0) {
                boolean cycle = dfs(to);
                if (cycle) {
                    return true;
                }
            }
        }

        visited.set(index, 2);
        answer.add(index);
        return false;
    }

}
