import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Library {

    private ArrayList<Book> books;
    private int capacity;

    public Library(int capacity) {
        this.books = new ArrayList<Book>();
        this.capacity = capacity;
    }

    public ArrayList<Book> getAll() {
        return this.books;
    }

    public Book findByTitle(String title) {
        Book bookFound = null;

        for (int i = 0; i < countBooks(); i++ ) {
            if (this.books.get(i).getTitle().equals(title)) {
                bookFound = this.books.get(i);
            }
        }
        return bookFound;
    }


//    public boolean equals(Object obj) {
//        if (obj == null) return false;
//        if (obj == this) return true;
//        if (!(obj instanceof ArrayTest)) return false;
//        ArrayTest o = (ArrayTest) obj;
//        return o.i == this.i;
//    }


    public Book lendBook(Book bookToLend) {

        Boolean result;

        result = this.books.remove(bookToLend);
        if (result) {
           return bookToLend;
        } else {
            return null;
        }
    }


    public int countBooks() {
        return this.books.size();
    }

    public void addBook(Book book) {

        if (!this.isFull()) {
            this.books.add(book);
            this.capacity -= 1;
        }

    }

    public int checkCapacity() {
        return this.capacity;
    }

    public boolean isFull() {
        if (this.capacity == 0) {
            return true;
        } else
            return false;

    }

    public HashMap<String, Integer> booksByGenre() {

        HashMap<String, Integer> booksClassified;

        booksClassified = new HashMap<String, Integer>();

        for (int i = 0; i < countBooks(); i++) {

            String bookGenre = this.books.get(i).getGenre();

            if (booksClassified.containsKey(bookGenre)) {
                booksClassified.put(bookGenre, booksClassified.get(bookGenre) + 1) ;
            } else {
                booksClassified.put(bookGenre, 1);
            }
        }

        return booksClassified;
    }




}
