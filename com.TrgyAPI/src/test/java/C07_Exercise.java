import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C07_Exercise {


    @Test
    public void get01(){

        /*
                https://restful-booker.herokuapp.com/booking/14018 url’ine
                bir GET request gonderdigimizde donen Response’un,
                status code’unun 200,
                ve content type’inin application-json,
                ve response body’sindeki
                    "firstname“in,"James",
                    ve "lastname“in, "Brown",
                    ve "totalprice“in, 111,
                    ve "depositpaid“in,true,
                    ve "additionalneeds“in,"Breakfast"
                oldugunu test edin
         */

        String  url = "https://restful-booker.herokuapp.com/booking/14018";

        Response response = given().when().get(url);

        response.then().contentType("application-json").
                statusCode(200).
                body("firstname", equalTo("James"),
                        "lastname", equalTo("Brown"),
                        "totalprice", equalTo(111),
                        "depositpaid", equalTo(true),
                        "additionalneeds", equalTo("Breakfast"));


    }
}
