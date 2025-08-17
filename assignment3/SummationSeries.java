import java.util.Scanner;

class Rational {
    private final int numerator;
    private final int denominator;

    public Rational(int n, int d) {
        this.numerator = n;
        this.denominator = d;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }

        return a;
    }

    public Rational add(Rational other) {
        int newNumerator = (this.numerator * other.denominator) + (other.numerator * this.denominator);
        int newDenominator = this.denominator * other.denominator;

        int gcd = this.gcd(newNumerator, newDenominator);

        newNumerator = newNumerator / gcd;
        newDenominator = newDenominator / gcd;
        return new Rational(newNumerator, newDenominator);
    }

    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }
}

public class SummationSeries {

    public static Rational arithmeticSeries(int n) {
        Rational r = new Rational(1, 1);
        for (int i = 2; i <= n; i++) {
            r = r.add(new Rational(1, i));
        }
        return r;
    }

    public static Rational geometricSeries(int n) {
        Rational r = new Rational(1, 1);
        for (int i = 1; i <= n; i++) {
            int denominator = (int) Math.pow(2, i);
            r = r.add(new Rational(1, denominator));
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
        System.out.println("Result of arithmetic series: " + arithmeticResult);
        System.out.println("Result of geometric series: " + geometricResult);
    }
}