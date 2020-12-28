import java.util.*;


// Question b)


public class OptimizationSol {
    private final int m;
    private final int n;

    public OptimizationSol(int m, int n) {
        this.m = m;
        this.n = n;
    }

    public List<String> findPathLoop(long target) {
        List<String> allOperations = new LinkedList<>();
        Stack<Stage> stageStack = new Stack<>();
        stageStack.push(new Stage(1, 1, 1, ""));    // from left-top corner
        while (!stageStack.empty()) {
            Stage currentStage = stageStack.pop();  // take out the bottom (最上面) stage
            if (currentStage.value == target && currentStage.m == this.m && currentStage.n == this.n) {
                allOperations.add(currentStage.path);
            }
            // Create two new stage,  R (right) and D (down)
            if (currentStage.m < this.m) {
                stageStack.push(new Stage(currentStage.m + 1, currentStage.n, currentStage.value + currentStage.m + 1, currentStage.path + "D"));    // Down
            }
            if (currentStage.n < this.n) {
                stageStack.push(new Stage(currentStage.m, currentStage.n + 1, currentStage.value + currentStage.m, currentStage.path + "R"));  // Right
            }
        }
        return allOperations;
    }

    static class Stage {
        final int m, n;
        final long value;
        final String path;

        Stage(int m, int n, long value, String path) {
            this.m = m;
            this.n = n;
            this.value = value;
            this.path = path;
        }
    }
}
