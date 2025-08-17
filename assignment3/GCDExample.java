public class GCDExample {
    private final int largerNumber;
    private final int smallerNumber;

    public GCDExample(int a, int b) {
        this.largerNumber = (a > b)? a : b;
        this.smallerNumber = (a < b)? a : b;
    }

    public int calculateGCD() {
        return this.getRecursive(largerNumber, smallerNumber);
    }

    public int getRecursive(int a, int b) {
        if (b == 0) {
            return a;
        }
        return this.getRecursive(b, a % b);
    }

    public static void main(String[] args) {
        GCDExample example = new GCDExample(20, 16);
        System.out.println("Greatest Common Divisor(GCD) for 20 and 16 is " + example.calculateGCD());
    }
}