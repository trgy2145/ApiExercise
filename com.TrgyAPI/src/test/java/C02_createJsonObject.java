import org.json.JSONObject;
import org.junit.Test;

public class C02_createJsonObject {

    @Test
    public void jsonObje01(){
        JSONObject firstOBje =  new JSONObject();

        firstOBje.put("title","Ahmet");
        firstOBje.put("body","Merhaba");
        firstOBje.put("userId",1);
        System.out.println(firstOBje);
    }
}
