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
        try {
            String uri = Util.baseUrl + "/Update";
            String timeStamp = Util.time();
            System.out.println("timeStamp generated is: " + timeStamp);
            Util.readJson("data");
            Map<String, Object> payload = new HashMap<>();
            updatedEmail = Util.jsonObject.get("name") + timeStamp + Util.jsonObject.get("domain");
            updatedUserName = Util.jsonObject.get("name") + timeStamp;
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
        } catch (Exception e) {
            System.out.println("Test case failed");
        }
    }
}
