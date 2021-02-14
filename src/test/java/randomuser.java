import io.restassured.response.*;
import org.junit.*;
import org.testng.annotations.Test;
import pojo.*;

import static io.restassured.RestAssured.*;

public class randomuser {
    public static Response response;

    @Test
    public void checkGenerateUserData() {
        response = given().log().body()
                .contentType("application/json")
                .when()
                .get("https://randomuser.me/api/?results=1&inc=gender,name,nat&nat=gb&noinfo")
                .then()
                .log()
                .body()
                .statusCode(200)
                .extract()
                .response();
        var responseBody = response.getBody().as(User.class);
        for (int i = 0; i < responseBody.getResults().length; i++) {
            Assert.assertEquals("GB", responseBody.getResults()[i].getNat());
        }
    }
}
