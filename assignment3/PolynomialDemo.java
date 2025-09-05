import java.util.*;

class Polynomial {
    private ArrayList<Integer> coefficients;

    public Polynomial(int[] coeffs) {
        coefficients = new ArrayList<>();
        for (int c : coeffs) {
            coefficients.add(c);
        }
    }

    public Polynomial add(Polynomial other) {
        int max = Math.max(coefficients.size(), other.coefficients.size());
        int[] result = new int[max];
        for (int i = 0; i < max; i++) {
            int a = (i < coefficients.size()) ? coefficients.get(i) : 0;
            int b = (i < other.coefficients.size()) ? other.coefficients.get(i) : 0;
            result[i] = a + b;
        }
        return new Polynomial(result);
    }

    public Polynomial subtract(Polynomial other) {
        int max = Math.max(coefficients.size(), other.coefficients.size());
        int[] result = new int[max];
        for (int i = 0; i < max; i++) {
            int a = (i < coefficients.size()) ? coefficients.get(i) : 0;
            int b = (i < other.coefficients.size()) ? other.coefficients.get(i) : 0;
            result[i] = a - b;
        }
        return new Polynomial(result);
    }

    public Polynomial multiply(Polynomial other) {
        int[] result = new int[coefficients.size() + other.coefficients.size() - 1];
        for (int i = 0; i < coefficients.size(); i++) {
            for (int j = 0; j < other.coefficients.size(); j++) {
                result[i + j] += coefficients.get(i) * other.coefficients.get(j);
            }
        }
        return new Polynomial(result);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = coefficients.size() - 1; i >= 0; i--) {
            int c = coefficients.get(i);
            if (c != 0) {
                if (sb.length() > 0) {
                    sb.append(" + ");
                }
                sb.append(c);
                if (i > 0) {
                    sb.append("x");
                }
                if (i > 1) {
                    sb.append("^").append(i);
                }
            }
        }
        return sb.length() > 0 ? sb.toString() : "0";
    }
}

public class PolynomialDemo {
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial(new int[]{5, 2, 3}); // 3x^2 + 2x + 5
        Polynomial p2 = new Polynomial(new int[]{1, 1});    // x + 1

        System.out.println("P1: " + p1);
        System.out.println("P2: " + p2);
        System.out.println("Addition: " + p1.add(p2));
        System.out.println("Subtraction: " + p1.subtract(p2));
        System.out.println("Multiplication: " + p1.multiply(p2));
    }
}
