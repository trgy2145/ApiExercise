package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_Get_ApiQuery {

    /* https://restful-booker.herokuapp.com/booking/256884  url sine
    bir Get request gönderdiğimizde donen response un status code unun 200,
    ve content type nın application/json; cherset=utf-8
    ve server isimli header in degerinin cowboy,
    ve status line ın HTTP/1.1 200 OK
    ve response suresinin 5 sn den kısa oldugunu manuel olarak test edin.
     */

    @Test
    public void get01(){
        String url =  "https://restful-booker.herokuapp.com/booking/69";

        Response response =  given().when().get(url);
        response.prettyPrint();

        System.out.println("status code = " + response.statusCode());
        System.out.println("getContentType = " + response.getContentType());
        System.out.println("getHeader = " + response.getHeader("Server"));
        System.out.println("getTime = " + response.getTime());

    }
}
