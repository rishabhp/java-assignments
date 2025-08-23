import java.util.ArrayList;

class Polynomial {
    private ArrayList<Integer> coeffs;

    public Polynomial(ArrayList<Integer> inputCoeff) {
        coeffs = inputCoeff;
    }

    public Polynomial add(Polynomial other) {
        int thisSize = this.coeffs.size();
        int otherSize = other.coeffs.size();
        int min = (thisSize < otherSize)? thisSize : otherSize;
        int max = (thisSize > otherSize)? thisSize : otherSize;
        ArrayList<Integer> resultCoeffs = new ArrayList<>();
        for (int i = 0; i < min; i++) {
            resultCoeffs.add(this.coeffs.get(i) + other.coeffs.get(i));
        }
        if (thisSize > otherSize) {
            for (int i = min; i < max; i++) {
                resultCoeffs.add(this.coeffs.get(i));
            }
        } else {
            for (int i = min; i < max; i++) {
                resultCoeffs.add(other.coeffs.get(i));
            }
        }
        return new Polynomial(resultCoeffs);
    }

    public Polynomial subtract(Polynomial other) {
        int thisSize = this.coeffs.size();
        int otherSize = other.coeffs.size();
        int min = (thisSize < otherSize)? thisSize : otherSize;
        int max = (thisSize > otherSize)? thisSize : otherSize;
        ArrayList<Integer> resultCoeffs = new ArrayList<>();
        for (int i = 0; i < min; i++) {
            resultCoeffs.add(this.coeffs.get(i) - other.coeffs.get(i));
        }
        if (thisSize > otherSize) {
            for (int i = min; i < max; i++) {
                resultCoeffs.add(this.coeffs.get(i));
            }
        } else {
            for (int i = min; i < max; i++) {
                resultCoeffs.add(-other.coeffs.get(i));
            }
        }
        return new Polynomial(resultCoeffs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(50);
        int size = coeffs.size();
        sb.append(coeffs.get(0));
        for (int i = 1; i < size - 1; i++) {
            int coeff = coeffs.get(i);
            if (coeff != 0) {
                sb.append(" + ").append(coeff).append("x^").append(i);
            }
        }
        int coeff = coeffs.get(size - 1);
        if (coeff != 0) {
            sb.append(" + ").append(coeff).append("x^").append((size-1));
        }
        return sb.toString();
    }
}

public class PolynomialOperation {
    public static void main(String[] args) {
        ArrayList<Integer> coeffs = new ArrayList<>();
        coeffs.add(5);
        coeffs.add(4);
        coeffs.add(3);
        coeffs.add(2);
        Polynomial p = new Polynomial(coeffs);
        System.out.println(p);
    }
}
