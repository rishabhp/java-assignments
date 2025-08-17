import java.util.Scanner;

public class StudentMarks {
    
    private int mathsMarks;
    private int scienceMarks;
    private int englishMarks;

    public StudentMarks(int mathsMarks, int scienceMarks, int englishMarks) {
        this.mathsMarks = mathsMarks;
        this.scienceMarks = scienceMarks;
        this.englishMarks = englishMarks;
    }

    public double getAverage() {
        return (this.mathsMarks + this.scienceMarks + this.englishMarks) / 3.0;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the marks of maths, science and english subjects respectively: ");
        int mathsMarks = scanner.nextInt();
        int scienceMarks = scanner.nextInt();
        int englishMarks = scanner.nextInt();
        scanner.close();

        StudentMarks studentMarks = new StudentMarks(mathsMarks, scienceMarks, englishMarks);
        System.out.println("The average of the student is " + studentMarks.getAverage());
    }
}
