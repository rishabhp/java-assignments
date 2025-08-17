import java.util.Scanner;

class Book {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author =  author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }
}

class Library {

    private String libraryName;
    private Book[] books;

    public Library(String name, Book []books) {
        this.libraryName = name;
        this.books = books;
    }

    public Book searchBookByTitle(String bookTitle) {
        for (Book book : books) {
            if (book.getTitle().equals(bookTitle)) {
                return book;
            }
        }
        return null;
    }

}

public class LibraryMain {
    public static void main(String[] args) {
        Book []books = {
            new Book(1, "Lightbringer", "C.J. Charlie"),
            new Book(2, "Red Rising", "Ritcher Thomson"),
            new Book(3, "Do Sheep Dreams?", "Roger Faraday")
        };

        Library lib = new Library("Dewevilley Library", books);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title of book you want to search: ");
        String title = scanner.nextLine();
        scanner.close();

        Book searchedBook = lib.searchBookByTitle(title);

        if (searchedBook != null) {
            System.out.println("Book written by " + searchedBook.getAuthor() + " with ID " + searchedBook.getId());
        } else {
            System.out.println("We dont have the book in our library!");
        }
    }
}
