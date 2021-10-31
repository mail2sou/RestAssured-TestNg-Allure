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

public class TC5_PositiveScenario_Read_UpdatedAccount {

    @Test
    public void readUpdatedAccount() {
        String uri = Util.baseUrl + "/Read";
        Map<String, Object> payload = new HashMap<>();
        payload.put("id", TC1_PositiveScenario_Create_NewAccount.id);
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
        assertEquals(email, TC4_PositiveScenario_Update_CreatedAccount.updatedEmail);
        assertEquals(userName, TC4_PositiveScenario_Update_CreatedAccount.updatedUserName);
    }
}
