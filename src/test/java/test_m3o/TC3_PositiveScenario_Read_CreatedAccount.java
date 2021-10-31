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

public class TC3_PositiveScenario_Read_CreatedAccount {

    @Test
    public void readCreatedAccount() {
        String uri = Util.baseUrl + "/Read";
        Map<String, Object> payload = new HashMap<>();
        payload.put("email", TC1_PositiveScenario_Create_NewAccount.email);
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

        String userName = response.jsonPath().getString("account.username");
        String email = response.jsonPath().getString("account.email");
        String created = response.jsonPath().getString("account.created");
        String updated = response.jsonPath().getString("account.updated");
        assertEquals(email, TC1_PositiveScenario_Create_NewAccount.email);
        assertEquals(userName, TC1_PositiveScenario_Create_NewAccount.userName);
        assertEquals(created, TC1_PositiveScenario_Create_NewAccount.created);
        assertEquals(updated, TC1_PositiveScenario_Create_NewAccount.updated);
    }
}
