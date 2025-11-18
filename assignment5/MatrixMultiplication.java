public class MatrixMultiplication {
    
    static int[][] matrixA = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    
    static int[][] matrixB = {
        {9, 8, 7},
        {6, 5, 4},
        {3, 2, 1}
    };
    
    static int[][] result = new int[3][3];
    
    public static void main(String[] args) {
        System.out.println("Matrix A:");
        printMatrix(matrixA);
        
        System.out.println("\nMatrix B:");
        printMatrix(matrixB);
        
        Thread[] threads = new Thread[3];
        
        for (int i = 0; i < 3; i++) {
            final int row = i;
            threads[i] = new Thread(() -> {
                System.out.println("Thread " + row + " computing row " + row);
                multiplyRow(row);
            });
            threads[i].start();
        }
        
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("\nResult Matrix (A * B):");
        printMatrix(result);
    }
    
    static void multiplyRow(int row) {
        for (int col = 0; col < matrixB[0].length; col++) {
            result[row][col] = 0;
            for (int k = 0; k < matrixB.length; k++) {
                result[row][col] += matrixA[row][k] * matrixB[k][col];
            }
        }
    }
    
    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }
}