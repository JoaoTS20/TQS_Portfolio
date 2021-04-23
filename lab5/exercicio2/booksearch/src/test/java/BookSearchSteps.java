import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import org.assertj.core.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookSearchSteps {
    Library library = new Library();
    List<Book> result = new ArrayList<>();

    @ParameterType("([0-9]{4})-([0-9]{2})-([0-9]{2})")
    public LocalDateTime iso8601Date(String year, String month, String day){
        return LocalDateTime.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day),0, 0);
    }

    @ParameterType("([0-9]{4})")
    public LocalDateTime year(String year) {
        LocalDateTime ldt = LocalDateTime.of(Integer.parseInt(year), 01, 01, 0, 0);
        return ldt;
    }

    @Given("(a/another) book with the title {string}, written by {string}, published in {iso8601Date}")
    public void addNewBook(final String title, final String author, final LocalDateTime published) {
        Book book = new Book(title, author, published);
        library.addBook(book);

    }
    @When("remove from library book with the title {string}, written by {string}, published in {iso8601Date}")
    public void removeBook(final String title, final String author, final LocalDateTime published){
        System.out.println(library);
        Book book = new Book(title, author, published);
        library.removeBook(book);
        System.out.println("After Remove:\n"+library);
    }

    @When("the customer searches for books published between {year} and {year}")
    public void setSearchParameters(final LocalDateTime from, LocalDateTime to) {
        result = library.findBooks(from, to);
    }

    @Then("{int} books should have been found")
    public void verifyAmountOfBooksFound(final int booksFound) {
        assertThat(result.size(), equalTo(booksFound));
    }

    @Then("Book {int} should have the title {string}")
    public void verifyBookAtPosition(final int position, final String title) {
        assertThat(result.get(position - 1).getTitle(), equalTo(title));
    }





}
