import java.util.Scanner;

public class SwapNumber {
    private int first_num;
    private int second_num;
    
    public SwapNumber(int a, int b) {
        first_num = a;
        second_num = b;
    }

    void display() {
        System.out.println("First Number: " + first_num + "\nSecond Number: " + second_num);
    }

    void swapThreeVariable() {
        int temp = first_num;
        first_num = second_num;
        second_num = temp;
    }

    void swapTwoVariable() {
        second_num = first_num + second_num;
        first_num = second_num - first_num;
        second_num = second_num - first_num;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first number:-");
        int a = scanner.nextInt();
        System.out.println("Enter the second number:-");
        int b = scanner.nextInt();
        scanner.close();
        SwapNumber obj = new SwapNumber(a, b);
        System.out.println("Before Swapping:-");
        obj.display();
        System.out.println("\nSwapping with 3 variables:-");
        obj.swapThreeVariable();
        obj.display();
        System.out.println("\nSwapping again with 2 variables:-");
        obj.swapTwoVariable();
        obj.display();
    }
}