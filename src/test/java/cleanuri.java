import io.restassured.response.*;
import org.junit.*;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.file.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import static org.testng.AssertJUnit.*;


public class cleanuri {
    public static Response response;
    public static String jsonAsString;

    @Test()
    public void testCorrectUrl() throws IOException {
        String url = Files.readString(Path.of("src/test/resources/correctUrl.txt"));
//        assertNotNull(url);

        response = given().log().body()
                .contentType("application/json").body("{\"url\":\"" + url + "\"}")
                .when()
                .post("https://cleanuri.com/api/v1/shorten")
                .then()
                .log()
                .body()
                .statusCode(200)
                .extract()
                .response();
        assertNotNull(response);
        jsonAsString = response.asString();
        Assert.assertThat(jsonAsString, containsString("result_url"));
    }

    @Test()
    public void testIncorrectUrl() throws IOException {
        String url = Files.readString(Path.of("src/test/resources/incorrectUrl.txt"));
        assertNotNull(url);

        response = given().log().body()
                .contentType("application/json").body("{\"url\":\"" + url + "\"}")
                .when()
                .post("https://cleanuri.com/api/v1/shorten")
                .then()
                .log()
                .body()
                .statusCode(400)
                .extract()
                .response();
        assertNotNull(response);
        jsonAsString = response.asString();
        Assert.assertThat(jsonAsString, containsString("Error"));
    }
}
