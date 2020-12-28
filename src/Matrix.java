import java.util.*;


// Question a)


public class Matrix {
    private final List<ArrayList<Integer>> path = new ArrayList<>();
    private final int m;
    private final int n;

    public Matrix (int m, int n) {
        this.m = m;
        this.n = n;
        this.constructMatrix(m, n);
    }


    private void constructMatrix(int m , int n) {
        for (int i = 0; i < m; i++) {
            path.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                path.get(i).add(i + 1);
            }
        }
    }


    public List<String> findAllPaths(int target) {
        List<String> allOperations = new LinkedList<>();
        this.findPath(0, 0, target, "", allOperations);
        return allOperations;
    }


    /**
    * find all path
    * @param m column number
    * @param n row number
    * @param target summed number
    * @param accumulator path accumulator
    * @param allOperations record all path
    */
    private void findPath(int m, int n, int target, String accumulator, List<String> allOperations) {
        if (m < this.m && n < this.n) {
            target -= path.get(m).get(n);
            if (target == 0 && m == this.m - 1 && n == this.n - 1) {    //right-bottom corner!!
                allOperations.add(accumulator);
            } else {    // backtracking
                findPath(m, n + 1, target, accumulator + "R", allOperations);
                // accumulator.deleteCharAt(accumulator.length() - 1);
                findPath(m + 1, n, target,accumulator + "D", allOperations);
                // accumulator.deleteCharAt(accumulator.length() - 1);
            }
        }
    }
}