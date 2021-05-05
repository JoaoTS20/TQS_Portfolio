import org.junit.jupiter.api.Test;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;


public class Tests {



    @Test
    public void endpoint_to_list_all_ToDo_is_available() {
        get("https://jsonplaceholder.typicode.com/todos").then().assertThat().statusCode(200);
    }

    @Test
    public void title_of_ToDo_test() {
        get("https://jsonplaceholder.typicode.com/todos/4").then().assertThat().body("title", is("et porro tempora"));
    }

    @Test
    public void test_listing_all_ToDos() {
        get("https://jsonplaceholder.typicode.com/todos").then().assertThat().body("id",hasItems(198,199));
    }

}
