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

public class TC7_NegativeScenario_Read_DeletedAccount {

    @Test
    public void readDeletedAccount() {
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
                statusCode(500).
                log().all().
                extract().response();
        assertEquals("not found", response.jsonPath().getString("Detail"));
    }
}
