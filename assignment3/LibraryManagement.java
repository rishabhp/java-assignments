import java.util.ArrayList;
import java.util.Scanner;

interface LibraryOperations {
    public void addBook(Book b);
    public void removeBook(int bookId);
    public Book searchBook(String bookTitle);
}

class Book {
    private int bookId;
    private String bookTitle;
    private String authorName;

    public Book(int bookId, String bookTitle, String authorName) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.authorName = authorName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    @Override
    public String toString() {
        return "Book ID: " + this.bookId + "\nBook Title: " + this.bookTitle;
    }

}

class Library implements LibraryOperations {
    private ArrayList<Book> bookSet;

    public Library() {
        this.bookSet = new ArrayList<>();
    }

    public void addBook(Book b) {
        this.bookSet.add(b);
    }

    public void removeBook(int bookId) {
        Book bookToRemove = null;
        for (Book book : this.bookSet) {
            if (book.getBookId() == bookId) {
                bookToRemove = book;
                break;
            }
        }

        if (bookToRemove == null) {
            System.out.println("No book with the said id exists");
        } else {
            this.bookSet.remove(bookToRemove);
        }
    }

    public Book searchBook(String bookTitle) {
        Book searchedBook = null;

        for (Book book : this.bookSet) {
            if (book.getBookTitle().equals(bookTitle)) {
                searchedBook = book;
                break;
            }
        }

        return searchedBook;
    }

    public void displayBookSet() {
        System.out.println("Displaying all the books in the library:-\n");
        for (Book book : this.bookSet) {
            System.out.println(book);
            System.out.println("--------------------------------------------------------------------------");
        }
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        int choice = -1;
        while (choice != 0) { 
            System.out.print("\n0. Exit\n1. Add Book\n2. Remove Book\n3. Search Book\n4. Display Book Collection\nChoose:- ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 0: {
                    break;
                }

                case 1: {
                    System.out.print("Enter the book ID: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter the book title: ");
                    String bookTitle = scanner.nextLine();
                    System.out.print("Enter the author name: ");
                    String authorName = scanner.nextLine();
                    Book book = new Book(bookId, bookTitle, authorName);
                    library.addBook(book);
                    break;
                }

                case 2: {
                    System.out.print("Enter the ID of book you want to remove: ");
                    int bookId = scanner.nextInt();
                    library.removeBook(bookId);
                    break;
                }

                case 3: {
                    System.out.print("Enter the title of the book you are searching: ");
                    String bookTitle = scanner.nextLine();
                    Book searchedBook = library.searchBook(bookTitle);
                    if (searchedBook == null) {
                        System.out.println("No book with given title exist in the library!");
                    } else {
                        System.out.println("Displaying searched book information:-\n" + searchedBook);
                    }
                    break;
                }

                case 4: {
                    System.out.println();
                    library.displayBookSet();
                    break;
                }

                default: {
                    System.out.println("Please select a valid option!");
                }
            }
        }
        scanner.close();
    }
}
