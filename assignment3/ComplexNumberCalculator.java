class ComplexNumber {
    private int real;
    private int imaginary;

    public ComplexNumber(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        int newReal = (this.real * other.real) - (this.imaginary * other.imaginary);
        int newImaginary = (this.real * other.imaginary) + (this.imaginary * other.real);
        return new ComplexNumber(newReal, newImaginary);
    }

    public ComplexNumber divide(ComplexNumber other) {
        int denominator = (other.real * other.real) + (other.imaginary * other.imaginary);
        int newReal = ((this.real * other.real) + (this.imaginary * other.imaginary)) / denominator;
        int newImaginary = ((this.imaginary * other.real) - (this.real * other.imaginary)) / denominator;
        return new ComplexNumber(newReal, newImaginary);
    }

    @Override
    public String toString() {
        return this.real + " + " + this.imaginary + "i";
    }
} 

public class ComplexNumberCalculator {
    public static void main(String[] args) {
        ComplexNumber cn1 = new ComplexNumber(4, 3); 
        ComplexNumber cn2 = new ComplexNumber(1, 2);

        System.out.println("First complex number: " + cn1);
        System.out.println("Second complex number: " + cn2);
        System.out.println("Sum: " + cn1.add(cn2));
        System.out.println("Difference: " + cn1.subtract(cn2));  
        System.out.println("Product: " + cn1.multiply(cn2));  
        System.out.println("Quotient: " + cn1.divide(cn2));  
    }
}
