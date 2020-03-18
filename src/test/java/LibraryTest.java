import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class LibraryTest {

//    declare instance variables:
    private Library library;
    private Book book;
    private Borrower client1;

    @Before
    public void before() {
        library = new Library(10);
        book = new Book("The Catcher in the Rye", "J.D. Salinger", "Novel");

    }


    @Test
    public void canAddBook() {
        library.addBook(book);
        assertEquals(1,library.countBooks());
    }


    @Test
    public void canCheckCapacity() {
        library.addBook(book);
        assertEquals(9,library.checkCapacity());
    }

    @Test
    public void canCheckIfFull() {

        Book newBook;
        for (int i = 0; i < 5; i++) {
            newBook = new Book("","","");
            library.addBook(newBook);
        }
        assertEquals(5, library.checkCapacity());
        assertFalse(library.isFull());
    }

    @Test
    public void canCountByGenre() {
        ArrayList<Book> allBooks;
        allBooks = new ArrayList<Book>();

        HashMap<String, Integer> booksClassified;
        HashMap<String, Integer> booksClassifiedExpectation;
        booksClassifiedExpectation = new HashMap<String, Integer>();

        booksClassifiedExpectation.put("comedy", 2);
        booksClassifiedExpectation.put("drama", 2);
        booksClassifiedExpectation.put("biography", 1);

        allBooks.add(new Book("some name", "some author", "comedy"));
        allBooks.add(new Book("some name", "some author", "drama"));
        allBooks.add(new Book("some name", "some author", "drama"));
        allBooks.add(new Book("some name", "some author", "biography"));
        allBooks.add(new Book("some name", "some author", "comedy"));

        for (int i = 0; i < allBooks.size(); i++) {
            this.library.addBook(allBooks.get(i));
        }

        booksClassified = this.library.booksByGenre();

        assertEquals(booksClassifiedExpectation,booksClassified);

    }

    @Test
    public void canFindByTitle() {
        library.addBook(book);
        Book book2 = new Book("Cat's Cradle", "Kurt Vonnegut", "Sci-fi");
        library.addBook(book2);

//        getAll()

        assertEquals("Cat's Cradle", library.findByTitle("Cat's Cradle").getTitle());

    }

    @Test
    public void canLendBook() {
        library.addBook(book);
        assertEquals(book, library.lendBook(book));
    }

    @Test
    public void canLendBookNotPresent() {
        library.addBook(book);
        Book newBook = new Book("some title", "wtv", "horror");
        assertEquals(null, library.lendBook(newBook));
    }

    @Test
    public void canLendBorrowWithCustomer() {
        library.addBook(book);
        Book book2 = new Book("Cat's Cradle", "Kurt Vonnegut", "Sci-fi");
        library.addBook(book2);
        client1 = new Borrower("John");

        client1.borrowBook(library, "Cat's Cradle");

        assertEquals(1, library.countBooks());
        assertEquals(1, client1.countBorrowedBooks());


    }

}


