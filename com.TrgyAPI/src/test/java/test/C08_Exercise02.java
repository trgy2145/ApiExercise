package test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C08_Exercise02 {

    @Test
    public void callObject(){
 /*
    {
    "firstName": "John",
    "lastName": "doe",
    "age": 26,
    "address": {
        "streetAddress": "naist street",
        "city": "Nara",
        "postalCode": "630-0192"
    },
    "phoneNumbers": [
        {
            "type": "iPhone",
            "number": "0123-4567-8888"
        },
        {
            "type": "home",
            "number": "0123-4567-8910"
        }
    ]
}*/

        JSONObject obj = new JSONObject();
        JSONObject adressObj = new JSONObject();
        JSONArray phoneNumObj = new JSONArray();
        JSONObject homePhObj = new JSONObject();
        JSONObject persPhoneObj = new JSONObject();

        persPhoneObj.put("type", "iPhone");
        persPhoneObj.put("number", "0123-4567-8888");
        homePhObj.put(  "type", "home");
        homePhObj.put("number", "0123-4567-8910");
        phoneNumObj.put( persPhoneObj);
        phoneNumObj.put( homePhObj);
        adressObj.put("streetAddress", "naist street");
        adressObj.put( "city", "Nara");
        adressObj.put( "postalCode", "630-0192");
        obj.put( "firstName", "John");
        obj.put( "lastName", "doe");
        obj.put( "age", 26);
        obj.put( "address", adressObj);
        obj.put( "phoneNumbers", phoneNumObj);

        System.out.println("isim ==>"+obj.get("firstName"));
        System.out.println("city ==>"+obj.getJSONObject("address").get("city"));
        System.out.println("number ==>"+ obj.getJSONArray("phoneNumbers").getJSONObject(1).get("number"));



    }
}
