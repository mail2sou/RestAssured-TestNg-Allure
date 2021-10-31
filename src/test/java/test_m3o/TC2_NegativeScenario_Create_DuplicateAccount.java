package test_m3o;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import utilpackage.Util;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TC2_NegativeScenario_Create_DuplicateAccount {

    @Test
    public void createDuplicateAccount() {
        String uri = Util.baseUrl + "/Create";
        String timeStamp = Util.test();
        System.out.println("timeStamp generated is: " + timeStamp);
        Map<String, Object> payload = new HashMap<>();
        String generatedUName = "tomcat-" + timeStamp;
        payload.put("email", TC1_PositiveScenario_Create_NewAccount.email);
        payload.put("password", "mySecretPass123");
        payload.put("username", generatedUName);
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
                statusCode(400).
                log().all().
                extract().response();
    }
}
