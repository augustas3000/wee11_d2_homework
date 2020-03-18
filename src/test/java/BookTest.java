import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BookTest {

    private Book book;

    @Before
    public void before() {
        book = new Book("The Catcher in the Rye", "J.D. Salinger", "Novel");
    }

    @Test
    public void gettersWork() {
        assertEquals("The Catcher in the Rye", book.getTitle());
        assertEquals("J.D. Salinger", book.getAuthor());
        assertEquals("Novel", book.getGenre());
    }



}
