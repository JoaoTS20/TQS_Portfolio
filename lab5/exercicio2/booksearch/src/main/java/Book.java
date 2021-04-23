import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(published, book.published);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, published);
    }
    // constructors, getter, setter ommitted

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", published=" + published +
                '}';
    }
}
