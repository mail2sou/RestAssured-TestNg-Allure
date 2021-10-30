package test_m3o;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import utilpackage.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TestCase1 {
    @Test
    void test01(){
        String URL = Util.baseURI;
        System.out.println("URL generated is: "+URL);
        JSONObject request = new JSONObject();
        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                get(URL).
                then().
                assertThat().
                statusCode(200).
                log().all();
    }
}
