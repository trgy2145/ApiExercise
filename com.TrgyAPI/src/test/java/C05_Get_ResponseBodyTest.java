import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C05_Get_ResponseBodyTest {

    /* https://jsonplaceholder.typicode.com/posts/44 url 'ine bir GET request
    * yolladıgımızda dönen response un
    * status code un 200,
    * ve contenttype inin ContentType.JSON,
    * ve response bodysinde bulunan userId 'nin 5
    * ve response bodysinde bulunan title ın "optio dolor molestias sit"
    * oldugunu test edin
    * */

    @Test
    public void get01(){
        // url hazırla
        String url = "https://jsonplaceholder.typicode.com/posts/44";

        // soruda isteniyorsa expected data hazırla

        // response kaydet
        Response response = given().when().get(url);

        response.prettyPrint();

        // assertion
        response.then().assertThat().statusCode(200)
        .contentType(ContentType.JSON)
        .body("userId", Matchers.equalTo(5))
        .body("title", Matchers.equalTo("optio dolor molestias sit"));

    }
}
