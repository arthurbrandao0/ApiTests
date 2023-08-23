import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;

public class APITest {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://petstore.swagger.io";
    }


    public void getStoreInventory() {

        Response response = RestAssured.get("/v2/store/inventory");

        // Obter o corpo da resposta como uma string
        String responseBody = response.getBody().asString();

        // Imprimir o corpo da resposta na console
        System.out.println(responseBody);

        response
                .then()
                .statusCode(200)
                .body(
                    "AVAILABLE", equalTo(2),
                    "unavailable", equalTo(1));

    }

    @Test
    public void postStoreOrder() {

        String requestBody =
                "{\n" +
                        "  \"id\": 0,\n" +
                        "  \"petId\": 0,\n" +
                        "  \"quantity\": 0,\n" +
                        "  \"shipDate\": \"2023-08-23T13:31:06.217Z\",\n" +
                        "  \"status\": \"placed\",\n" +
                        "  \"complete\": true\n" +
                        "}";

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/v2/store/order");

        // Obter o corpo da resposta como uma string
        String responseBody = response.getBody().asString();

        // Imprimir o corpo da resposta na console
        System.out.println(responseBody);

    }
}
