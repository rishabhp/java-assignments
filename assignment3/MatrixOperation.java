class Matrix {
    private int[][] matrix;
    private int rows;
    private int cols;

    public Matrix(int[][] matrix) {
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        this.matrix = new int[this.rows][this.cols];
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != this.cols) {
                throw new ArithmeticException("Row " + i + " does not have " + this.cols + " columns.");
            }
            for (int j = 0; j < this.cols; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
    }

    public Matrix add(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Incompatible matrix operation: The matrices have different dimensions.");
        }

        int [][]newMatrix = new int[this.rows][this.cols];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                newMatrix[i][j] = this.matrix[i][j] + other.matrix[i][j];
            }
        }
        return new Matrix(newMatrix);
    }

    public Matrix subtract(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Incompatible matrix operation: The matrices have different dimensions.");
        }

        int [][]newMatrix = new int[this.rows][this.cols];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                newMatrix[i][j] = this.matrix[i][j] - other.matrix[i][j];
            }
        }
        return new Matrix(newMatrix);
    }

    public Matrix multiply(Matrix other) {
        if (this.cols != other.rows) {
            throw new IllegalArgumentException("Matrix multiplication error: this.cols (" + this.cols + ") != other.rows (" + other.rows + ")");
        }

        int [][]newMatrix = new int[this.rows][other.cols];

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                int sum = 0;
                for (int k = 0; k < this.cols; k++) {
                    sum += this.matrix[i][k] * other.matrix[k][j];
                }
                newMatrix[i][j] = sum;
            }
        }

        return new Matrix(newMatrix);
    }

    public Matrix multiply(int k) {
        int [][]newMatrix = new int[this.rows][this.cols];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                newMatrix[i][j] = this.matrix[i][j] * k;
            }
        }
        return new Matrix(newMatrix);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j]).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

public class MatrixOperation {
    public static void main(String[] args) {
        int[][] data1 = {
            {1, 2},
            {3, 4}
        };

        int[][] data2 = {
            {5, 6},
            {7, 8}
        };

        Matrix m1 = new Matrix(data1);
        Matrix m2 = new Matrix(data2);

        System.out.println("Matrix 1:");
        System.out.println(m1);

        System.out.println("Matrix 2:");
        System.out.println(m2);

        Matrix sum = m1.add(m2);
        System.out.println("Addition (m1 + m2):");
        System.out.println(sum);

        Matrix diff = m1.subtract(m2);
        System.out.println("Subtraction (m1 - m2):");
        System.out.println(diff);

        Matrix product = m1.multiply(m2);
        System.out.println("Matrix Multiplication (m1 x m2):");
        System.out.println(product);

        Matrix scalar = m1.multiply(3);
        System.out.println("Scalar Multiplication (m1 x 3):");
        System.out.println(scalar);
    }
}
