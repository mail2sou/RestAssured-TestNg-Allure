package test_m3o;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static org.junit.Assert.assertEquals;

import org.testng.annotations.Test;
import utilpackage.Util;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;

public class TC1_PositiveScenario_Create_NewAccount {

    public static String id, userName, email, created, updated;

    @Test
    public void createNewAccount() {
        try {
            String uri = Util.baseUrl + "/Create";
            String timeStamp = Util.time();
            System.out.println("timeStamp generated is: " + timeStamp);
            Util.readJson("data");
            Map<String, Object> payload = new HashMap<>();
            String generatedEmail = Util.jsonObject.get("name") + timeStamp + Util.jsonObject.get("domain");
            String generatedUName = Util.jsonObject.get("name") + timeStamp;
            payload.put("email", generatedEmail);
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
                            statusCode(200).
                            log().all().
                            extract().response();

            id = response.jsonPath().getString("account.id");
            userName = response.jsonPath().getString("account.username");
            email = response.jsonPath().getString("account.email");
            created = response.jsonPath().getString("account.created");
            updated = response.jsonPath().getString("account.updated");
            assertNotNull(id);
            assertNotNull(created);
            assertNotNull(updated);
            assertEquals(email, generatedEmail);
            assertEquals(userName, generatedUName);
        } catch (Exception e) {
            System.out.println("Test case failed");
        }
    }
}
