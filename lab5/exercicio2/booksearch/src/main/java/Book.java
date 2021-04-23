import java.time.LocalDateTime;
import java.util.Date;

public class Book {
    private final String title;
    private final String author;
    private final LocalDateTime published;

    public Book(String title, String author, LocalDateTime published) {
        this.title = title;
        this.author = author;
        this.published = published;
    }

    public java.lang.String getTitle() {
        return title;
    }

    public java.lang.String getAuthor() {
        return author;
    }

    public LocalDateTime getPublished() {
        return published;
    }


// constructors, getter, setter ommitted
}
