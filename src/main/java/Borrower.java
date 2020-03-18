import java.util.ArrayList;

public class Borrower {
    ArrayList<Book> booksBorrowed;
    String name;

    public Borrower(String name) {
        this.name = name;
        this.booksBorrowed = new ArrayList<Book>();
    }

    public void borrowBook(Library library, String title) {
        Book bookFound = library.findByTitle(title);

        if (library.findByTitle(title) != null) {
            this.booksBorrowed.add(library.lendBook(bookFound));
        }
    }

    public int countBorrowedBooks() {
        return this.booksBorrowed.size();
    }
}
