package test_m3o;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;

import org.testng.annotations.Test;
import utilpackage.Util;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TC4_PositiveScenario_Update_CreatedAccount {


    public static String updatedEmail, updatedUserName;

    @Test
    public void updateCreatedAccount() {
        String uri = Util.baseUrl + "/Update";
        String timeStamp = Util.test();
        System.out.println("timeStamp generated is: " + timeStamp);
        Map<String, Object> payload = new HashMap<>();
        updatedEmail = "tomcat_" + timeStamp + "@gmail.com";
        updatedUserName = "tomcat-" + timeStamp;
        payload.put("id", TC1_PositiveScenario_Create_NewAccount.id);
        payload.put("email", updatedEmail);
        payload.put("username", updatedUserName);
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
