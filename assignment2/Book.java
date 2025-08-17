import java.util.Scanner;

public class Book {
    private String bookName;
    private String authorName;

    public Book(String bookName, String authorName) {
        this.bookName = bookName;
        this.authorName = authorName;
    }

    public void display() {
        System.out.println("Book Name: " + this.bookName + "\nAuthor Name: " + this.authorName);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of book: ");
        String bookName = scanner.nextLine();
        System.out.print("Enter the name of author: ");
        String authorName = scanner.nextLine();
        scanner.close();

        Book book = new Book(bookName, authorName);
        System.out.println("Displaying Book Information: ");
        book.display();
    }
}