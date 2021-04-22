import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.assertj.core.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookSearchSteps {
    Library library = new Library();
    List<Book> result = new ArrayList<>();

    //TODO: FAZER O PRIMEIRO TESTE BEM E ADICIONAR OS QUE ESTÃO NOS SLIDES (AQUELA CONF DO ISO É QUE ESTÁ A DAR ERRO)

    @ParameterType("([0-9]{4})-([0-9]{2})-([0-9]{2})")
    public LocalDateTime iso8601Date(String year, String month, String day){
        return LocalDateTime.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day),0, 0);
    }


    @When("the customer searches for books published between {iso8601Date} and {iso8601Date}")
    public void setSearchParameters(final LocalDateTime from, final LocalDateTime to) {
        result = library.findBooks(from, to);
    }


     @Given("a book with the title {string}, written by {string}, published in {iso8601Date}")
     public void a_book_with_the_title_written_by_published_in(String string, String string2, Date date_iso_local_date_time) {
     // Write code here that turns the phrase above into concrete actions
     throw new io.cucumber.java.PendingException();
     }


     @Given("(a|another) book with the title {string}, written by {string}, published in {iso8601Date}")
     public void addNewBook(final String title, final String author, final LocalDateTime published) {
     Book book = new Book(title, author, published);
     library.addBook(book);
     }


     @Given("another book with the title {string}, written by {string}, published in {iso8601Date}")
     public void another_book_with_the_title_written_by_published_in(String string, String string2, LocalDateTime date_iso_local_date_time) {
     // Write code here that turns the phrase above into concrete actions
     throw new io.cucumber.java.PendingException();
     }


     @When("the customer searches for books published between {iso8601Date} and {iso8601Date}")
     public void setSearchParameters(final LocalDateTime from, final LocalDateTime to) {
     result = library.findBooks(from, to);
     }


     @Then("{int} books should have been found")
     public void books_should_have_been_found(Integer int1) {
     // Write code here that turns the phrase above into concrete actions
     throw new io.cucumber.java.PendingException();
     }


     @Then("Book {int} should have the title {string}")
     public void book_should_have_the_title(Integer int1, String string) {
     // Write code here that turns the phrase above into concrete actions
     throw new io.cucumber.java.PendingException();
     }


}
