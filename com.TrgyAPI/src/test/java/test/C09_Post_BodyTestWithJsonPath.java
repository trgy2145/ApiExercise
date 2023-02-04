package test;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C09_Post_BodyTestWithJsonPath {


    @Test
    public void post01(){
         /*
            https://restful-booker.herokuapp.com/booking
             url’ine asagidaki body'ye sahip
            bir POST request gonderdigimizde
                       {
                            "firstname" : "Ali",
                            "lastname" : "Bak",
                            "totalprice" : 500,
                            "depositpaid" : false,
                            "bookingdates" : {
                                "checkin" : "2021-06-01",
                                "checkout" : "2021-06-10"
                            },
                            "additionalneeds" : "wi-fi"
                        }
            donen Response’un,
            status code’unun 200,
            ve content type’inin application-json,
            ve response body’sindeki
                "firstname“in,"Ali",
                ve "lastname“in, "Bak",
                ve "totalprice“in,500,
                ve "depositpaid“in,false,
                ve "checkin" tarihinin 2021-06-01
                ve "checkout" tarihinin 2021-06-10
                ve "additionalneeds“in,"wi-fi"
            oldugunu test edin
     */

        JSONObject obj = new JSONObject();
        JSONObject innerObj = new JSONObject();
        innerObj.put( "checkin" , "2021-06-01");
        innerObj.put("checkout" , "2021-06-10");
        obj.put("firstname", "Ali");
        obj.put("lastname", "Bak");
        obj.put("totalprice", 500);
        obj.put("depositpaid", false);
        obj.put("bookingdates", innerObj);
        obj.put("additionalneeds", "wi-fi");
        System.out.println(obj.toString());

        String url =  "https://restful-booker.herokuapp.com/booking";

        Response response = given().contentType("application/json").
                            when().body(obj.toString()).post(url);

        response.then().assertThat().statusCode(200).
                contentType("application/json").
                body("booking.firstname", equalTo("Ali"),
                        "booking.lastname", equalTo("Bak"),
                        "booking.totalprice",equalTo(500),
                        "booking.depositpaid",equalTo(false),
                        "booking.bookingdates.checkin",equalTo("2021-06-01"),
                        "booking.bookingdates.checkout",equalTo("2021-06-10"),
                        "booking.additionalneeds",equalTo("wi-fi"));


    }
}
