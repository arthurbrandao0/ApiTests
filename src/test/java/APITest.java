import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class APITest {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://petstore.swagger.io";
    }

    @Test
    public void testAPIEndpoint() {
        Response response = RestAssured.get("/v2/store/inventory");

        response.then().statusCode(200);
    }
}
