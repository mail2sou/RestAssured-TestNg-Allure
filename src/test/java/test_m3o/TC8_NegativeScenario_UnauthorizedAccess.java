package test_m3o;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import utilpackage.Util;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TC8_NegativeScenario_UnauthorizedAccess {
    @Test
    public void unauthorizedAccess() {
        String uri = Util.baseUrl + "/Read";
        Map<String, Object> payload = new HashMap<>();
        payload.put("id", TC1_PositiveScenario_Create_NewAccount.id);
        JSONObject request = new JSONObject(payload);
        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                post(uri).
        then().
                assertThat().
                statusCode(401).
                log().all().
                extract().response();
    }
}
