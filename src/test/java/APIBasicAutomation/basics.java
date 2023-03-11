package APIBasicAutomation;

import PayloadFiles.payloadfromJavaClass;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

public class basics {

    //Validate if Add place API is working as expected
    //given - All input details
    //when - Submit the APIs
    //then - Validate the response
    public static void main(String[] args) {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body(payloadfromJavaClass.AddPlace()).when().post("maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP")).header("server","Apache/2.4.41 (Ubuntu)");
    }

}
