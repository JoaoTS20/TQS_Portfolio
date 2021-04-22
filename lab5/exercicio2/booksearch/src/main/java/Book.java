import java.util.Date;

public class Book {
    private final String title;
    private final String author;
    private final Date published;

    public Book(String title, String author, Date published) {
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

    public Date getPublished() {
        return published;
    }


// constructors, getter, setter ommitted
}
