import java.util.*;
class Rational {
    int numerator;
    int denominator;

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;

        cleanup();
    }

    private void cleanup() {
        int gcd = getGCD(numerator, denominator);

        numerator = numerator / gcd;
        denominator = denominator / gcd;
    }

    private int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public Rational add(Rational other) {
        int newNumerator = (other.denominator * this.numerator) + (this.denominator * other.numerator);
        int newDenominator = this.denominator * other.denominator;
        return new Rational(newNumerator, newDenominator);
    }
}

public class SummationSeries {

    public static Rational arithmeticSeries(int n) {
        Rational r = new Rational(1, 1);

        for (int i = 2; i <= n; i++) {
            Rational other = new Rational(1, i);
            r = r.add(other);
        }

        return r;
    }

    public static Rational geometricSeries(int n) {
        Rational r = new Rational(1, 1);

        for (int i = 1; i <= n; i++) {
            Rational other = new Rational(1, (int) Math.pow(2, i));
            r = r.add(other);
        }

        return r;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();
        scanner.close();
        Rational arithmeticResult = SummationSeries.arithmeticSeries(n);
        Rational geometricResult = SummationSeries.geometricSeries(n);
        System.out.println("Result for series-1: " + arithmeticResult);
        System.out.println("Result for series-2: " + geometricResult);
    }
}