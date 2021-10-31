package test_m3o;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import utilpackage.Util;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class TC2_NegativeScenario_Create_DuplicateAccount {

    @Test
    public void createDuplicateAccount() {
        try {
            String uri = Util.baseUrl + "/Create";
            String timeStamp = Util.time();
            System.out.println("timeStamp generated is: " + timeStamp);
            Util.readJson("data");
            Map<String, Object> payload = new HashMap<>();
            String generatedUName = Util.jsonObject.get("name") + timeStamp;
            payload.put("email", TC1_PositiveScenario_Create_NewAccount.email);
            payload.put("password", Util.jsonObject.get("password"));
            payload.put("username", generatedUName);
            JSONObject request = new JSONObject(payload);
            Response response =
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
            assertEquals("email already exists", response.jsonPath().getString("Detail"));
        } catch (Exception e) {
            System.out.println("Test case failed");
        }
    }
}
