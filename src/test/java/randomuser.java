import io.restassured.response.*;
import org.junit.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class randomuser {
    public static Response response;
    @Test
    public void checkGenerateUserData(){
        response = given().log().body()
                .contentType("application/json")
                .when()
                .get("https://randomuser.me/api/?results=1&inc=gender,name,nat&nat=gb")
                .then()
                .log()
                .body()
                .statusCode(200)
                .extract()
                .response();
        User responseBody = response.as(User.class);
        Assert.assertEquals("GB", responseBody.nat);
    }
}
