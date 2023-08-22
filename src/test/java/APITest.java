import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class APITest {

    @BeforeClass
    public void setUp() {
        // Configuração inicial, como a base URL da API
        RestAssured.baseURI = "https://petstore.swagger.io";
    }

    @Test
    public void testAPIEndpoint() {
        Response response = RestAssured.get("/v2/store/inventory");

        // Adicione asserções para verificar a resposta
        response.then().statusCode(200);
    }
}
