import io.restassured.response.*;
import org.junit.*;
import org.testng.annotations.Test;
import pojo.*;

import static io.restassured.RestAssured.*;

public class randomuser {
    public static Response response;

    @Test
    public void checkNatGB() {
        response = given().log().body()
                .contentType("application/json")
                .queryParam("results", 5)
                .queryParam("inc", "gender,name,nat")
                .queryParam("nat", "gb")
                .queryParam("noinfo")
                .when()
                .get("https://randomuser.me/api/")
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

    @Test
    public void checkNatIR() {
        response = given().log().body()
                .contentType("application/json")
                .queryParam("results", 5)
                .queryParam("inc", "gender,name,nat")
                .queryParam("nat", "ir")
                .queryParam("noinfo")
                .when()
                .get("https://randomuser.me/api/")
                .then()
                .log()
                .body()
                .statusCode(200)
                .extract()
                .response();
        var responseBody = response.getBody().as(User.class);
        for (int i = 0; i < responseBody.getResults().length; i++) {
            Assert.assertEquals("IR", responseBody.getResults()[i].getNat());
        }
    }

    @Test
    public void checkGenderFemale() {
        response = given().log().body()
                .contentType("application/json")
                .queryParam("results", 5)
                .queryParam("inc", "gender,name,nat")
                .queryParam("gender", "female")
                .queryParam("noinfo")
                .when()
                .get("https://randomuser.me/api/")
                .then()
                .log()
                .body()
                .statusCode(200)
                .extract()
                .response();
        var responseBody = response.getBody().as(User.class);
        for (int i = 0; i < responseBody.getResults().length; i++) {
            Assert.assertEquals("female", responseBody.getResults()[i].getGender());
        }
    }

    @Test
    public void checkGenderMale() {
        response = given().log().body()
                .contentType("application/json")
                .queryParam("results", 5)
                .queryParam("inc", "gender,name,nat")
                .queryParam("gender", "male")
                .queryParam("noinfo")
                .when()
                .get("https://randomuser.me/api/")
                .then()
                .log()
                .body()
                .statusCode(200)
                .extract()
                .response();
        var responseBody = response.getBody().as(User.class);
        for (int i = 0; i < responseBody.getResults().length; i++) {
            Assert.assertEquals("male", responseBody.getResults()[i].getGender());
        }
    }

    @Test
    public void checkCountOfResults() {
        response = given().log().body()
                .contentType("application/json")
                .queryParam("results", 5)
                .queryParam("inc", "gender,name,nat")
                .queryParam("gender", "female")
                .queryParam("noinfo")
                .when()
                .get("https://randomuser.me/api/")
                .then()
                .log()
                .body()
                .statusCode(200)
                .extract()
                .response();
        var responseBody = response.getBody().as(User.class);
        Assert.assertEquals(5, responseBody.getResults().length);
    }

    //Если кол-во результатов в параметре больше 5000, должен вернуться только один результат в ответе
    @Test
    public void checkExcessOfResults() {
        response = given().log().body()
                .contentType("application/json")
                .queryParam("results", 1)
                .queryParam("inc", "gender,name,nat")
                .queryParam("gender", "female")
                .queryParam("noinfo")
                .when()
                .get("https://randomuser.me/api/")
                .then()
                .log()
                .body()
                .statusCode(200)
                .extract()
                .response();
        var responseBody = response.getBody().as(User.class);
        Assert.assertEquals(1, responseBody.getResults().length);
    }
}
