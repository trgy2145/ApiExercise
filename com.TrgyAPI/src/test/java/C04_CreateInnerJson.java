import org.json.JSONObject;
import org.junit.Test;

public class C04_CreateInnerJson {

    /* {
    "firstname": "Josh",
    "lastname": "Allen",
    "lastname": "Allen",,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "super bowls"
}

     */
    @Test
    public void createJson(){
        JSONObject innerObj =  new JSONObject();
        innerObj.put("checkin", "2018-01-01");
        innerObj.put("checkout", "2019-01-01");
        JSONObject obje =  new JSONObject();

        obje.put("firstname", "Josh");
        obje.put("lastname", "Allen");
        obje.put("lastname", "Allen");
        obje.put("depositpaid", true);
        obje.put("bookingdates", innerObj);
        obje.put("additionalneeds", "super bowls");

        System.out.println(obje);

    }
}
