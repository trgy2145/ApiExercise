package test;

import baseURL.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C15_BaseUrIJsonplaceHolder extends JsonPlaceHolderBaseUrl {
    //Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin

    /*
        1-  https://jsonplaceholder.typicode.com/posts endpointine bir GET
         request gonderdigimizde donen response’un status code’unun 200 oldugunu
         ve Response’ta 100 kayit oldugunu test edin.
        */

    /*
        2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET
            request gonderdigimizde donen response’un status code’unun 200 oldugunu
            ve “title” degerinin “optio dolor molestias sit” oldugunu test edin
         */
    /*
        3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE
            request gonderdigimizde donen response’un status code’unun 200 oldugunu ve
            response body’sinin null oldugunu test edin
         */

    @Test
    public void get01() {

       // URl hazırla
        specJsonPlace.pathParam("pp1","posts");

        // response kaydet

        Response response =  given().spec(specJsonPlace).when().get("/{pp1}");

        // assertion

        response.then().assertThat().statusCode(200).body("title",equalTo("optio dolor molestias sit"));

    }
    @Test
    public void get02() {

        // URl hazırla
        specJsonPlace.pathParams("pp1","posts","pp2",44);

        // response kaydet

        Response response =  given().spec(specJsonPlace).when().get("/{pp1}/{pp2}");

        // assertion

        response.then().assertThat().statusCode(200).body("title",hasSize(100));

    }

    @Test
    public void delete(){
        specJsonPlace.pathParams("pp1","posts","pp2",50);


        Response response =  given().spec(specJsonPlace).when().delete("/{pp1}/{pp2}");

        response.prettyPrint();

        response.then().assertThat().statusCode(200).body("body",nullValue());
    }
}
