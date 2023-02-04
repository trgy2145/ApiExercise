package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C03_ResponseDataAssertion {
      /* https://restful-booker.herokuapp.com/booking/256884  url sine
    bir Get request gönderdiğimizde donen response un status code unun 200,
    ve content type nın application/json; cherset=utf-8
    ve server isimli header in degerinin cowboy,
    ve status line ın HTTP/1.1 200 OK
    ve response suresinin 5 sn den kısa oldugunu manuel olarak test edin.
     */

    // 1 url hazırla
    @Test()
    public void  get02(){
        String url ="https://restful-booker.herokuapp.com/booking/69";

        // 2 gerekli ise body hazırla

        //  3 response kaydet

        Response response = given() .when().get(url);

        //4 assertion
        response.then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","Cowboy")
                .statusLine("HTTP/1.1 200 OK");

    }






}
