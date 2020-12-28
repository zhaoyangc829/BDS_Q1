import java.util.*;





public class Main {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(9, 9);
        List<String> allOperations = matrix.findAllPaths(90);
        for (String operation : allOperations) {
            System.out.println(operation);
        }
    }
}