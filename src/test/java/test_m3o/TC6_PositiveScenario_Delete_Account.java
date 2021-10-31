package test_m3o;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import utilpackage.Util;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TC6_PositiveScenario_Delete_Account {

    @Test
    public void deleteAccount() {
        String uri = Util.baseUrl + "/Delete";
        Map<String, Object> payload = new HashMap<>();
        payload.put("id", TC1_PositiveScenario_Create_NewAccount.id);
        JSONObject request = new JSONObject(payload);
        given().
                header("Content-Type", "application/json").
                header("Authorization", Util.bearerToken).
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                post(uri).
        then().
                assertThat().
                statusCode(200).
                log().all().
                extract().response();
    }
}
